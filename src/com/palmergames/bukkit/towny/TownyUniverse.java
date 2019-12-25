package com.palmergames.bukkit.towny;

import com.palmergames.bukkit.towny.database.TownyFlatFileDatabase;
import com.palmergames.bukkit.towny.database.TownyJSONDatabase;
import com.palmergames.bukkit.towny.database.TownySQLDatabase;
import com.palmergames.bukkit.towny.database.Saveable;
import com.palmergames.bukkit.towny.database.TownyDatabase;
import com.palmergames.bukkit.towny.db.TownyDataSource;
import com.palmergames.bukkit.towny.db.TownyDatabaseHandler;
import com.palmergames.bukkit.towny.exceptions.KeyAlreadyRegisteredException;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.exceptions.TownyRuntimeException;
import com.palmergames.bukkit.towny.object.Coord;
import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.TownyWorld;
import com.palmergames.bukkit.towny.object.WorldCoord;
import com.palmergames.bukkit.towny.object.metadata.CustomDataField;
import com.palmergames.bukkit.towny.permissions.TownyPermissionSource;
import com.palmergames.bukkit.towny.tasks.OnPlayerLogin;
import com.palmergames.bukkit.towny.war.eventwar.War;
import com.palmergames.bukkit.util.BukkitTools;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Towny's class for internal API Methods
 *
 * @author Lukas Mansour (Articdive)
 */
public class TownyUniverse {
	private static final Logger LOGGER = LogManager.getLogger(Towny.class);
    private static TownyUniverse instance;
    private final ConcurrentMap<UUID, Resident> residents = new ConcurrentHashMap<>();
    private final ConcurrentMap<UUID, Town> towns = new ConcurrentHashMap<>();
    private final ConcurrentMap<UUID, Nation> nations = new ConcurrentHashMap<>();
    private final ConcurrentMap<UUID, TownyWorld> worlds = new ConcurrentHashMap<>();
    private final ConcurrentMap<UUID, TownBlock> townBlocks = new ConcurrentHashMap<>();
    
    private final HashMap<String, CustomDataField> registeredMetadata = new HashMap<>();
    private final List<Resident> jailedResidents = new ArrayList<>();
    private final String pluginFolder;
    private TownyDatabase database;
    private TownyDataSource dataSource;
    private TownyPermissionSource permissionSource;
    private War warEvent;
	
	private TownyUniverse() {
		pluginFolder = Towny.getPlugin().getDataFolder().getPath();
		String saveDBType = TownySettings.getSaveDatabase().toLowerCase();
		String loadDBType = TownySettings.getLoadDatabase().toLowerCase();
		// Setup any defaults before we load the dataSource.
		Coord.setCellSize(TownySettings.getTownBlockSize());
		LOGGER.log(Level.INFO, "[Towny] Database: [Load] " + loadDBType + " [Save] " + saveDBType);
		switch (loadDBType) {
			case "ff":
			case "flatfile": {
				this.database = new TownyFlatFileDatabase();
				loadDBType = "flatfile";
				break;
			}
			// Do not add aliases for these.
			case "postgresql":
			case "mysql":
			case "sqlite":
			case "h2": {
				this.database = new TownySQLDatabase();
				break;
			}
			case "json":
			case "gson": {
				this.database = new TownyJSONDatabase();
				loadDBType = "json";
				break;
			}
			default: {
				LOGGER.log(Level.ERROR, "[Towny] Error: Unsupported load format!");
				throw new TownyRuntimeException();
			}
		}
		// Before we load we will backup, just incase something goes wrong
		// This might just save a server owner's day.
		if (!database.backup()) {
			LOGGER.log(Level.ERROR, "[Towny] Error: Failed to backup database before loading!");
			throw new TownyRuntimeException();
		}
		this.worlds.putAll(database.loadWorlds());
		this.nations.putAll(database.loadNations());
		this.towns.putAll(database.loadTowns());
		this.residents.putAll(database.loadResidents());
		this.townBlocks.putAll(database.loadTownBlocks());
		switch (saveDBType) {
			case "ff":
			case "flatfile": {
				this.database = new TownyFlatFileDatabase();
				saveDBType = "flatfile";
				break;
			}
			// Do not add aliases for these.
			case "postgresql":
			case "mysql":
			case "sqlite":
			case "h2": {
				this.database = new TownySQLDatabase();
				break;
			}
			case "json":
			case "gson": {
				this.database = new TownyJSONDatabase();
				saveDBType = "json";
				break;
			}
			default: {
				LOGGER.log(Level.ERROR, "[Towny] Error: Unsupported save format!");
				throw new TownyRuntimeException();
			}
		}
		// TODO: Remove after all references are removed from Towny!
		this.dataSource = new TownyDatabaseHandler(Towny.getPlugin(), this);
		// Backup save Database aswell
		if (!database.backup()) {
			LOGGER.log(Level.ERROR, "[Towny] Error: Failed to backup database after loading!");
			throw new TownyRuntimeException();
		}
		// TODO: Add deleting unused files.
		
		// Copy over data.
		if (!loadDBType.equals(saveDBType)) {
			worlds.values().forEach(this::save);
			nations.values().forEach(this::save);
			towns.values().forEach(this::save);
			residents.values().forEach(this::save);
			townBlocks.values().forEach(this::save);
		}
    }

    
    public void onLogin(Player player) {
        
        if (!player.isOnline())
            return;
        
        // Test and kick any players with invalid names.
        player.getName();
        if (player.getName().contains(" ")) {
            player.kickPlayer("Invalid name!");
            return;
        }
        
        // Perform login code in it's own thread to update Towny data.
        //new OnPlayerLogin(plugin, player).start();
        if (BukkitTools.scheduleSyncDelayedTask(new OnPlayerLogin(Towny.getPlugin(), player), 0L) == -1) {
            TownyMessaging.sendErrorMsg("Could not schedule OnLogin.");
        }
        
    }
    
    public void onLogout(Player player) {
        
        try {
            Resident resident = dataSource.getResident(player.getName());
            resident.setLastOnline(System.currentTimeMillis());
            dataSource.saveResident(resident);
        } catch (NotRegisteredException ignored) {
        }
    }
    
    public void startWarEvent() {
        warEvent = new War(Towny.getPlugin(), TownySettings.getWarTimeWarningDelay());
    }
    
    //TODO: This actually breaks the design pattern, so I might just redo warEvent to never be null.
    //TODO for: Articdive
    public void endWarEvent() {
        if (warEvent != null && warEvent.isWarTime()) {
            warEvent.toggleEnd();
        }
    }
    
    public void addWarZone(WorldCoord worldCoord) {
        try {
        	if (worldCoord.getTownyWorld().isWarAllowed())
            	worldCoord.getTownyWorld().addWarZone(worldCoord);
        } catch (NotRegisteredException e) {
            // Not a registered world
        }
        Towny.getPlugin().updateCache(worldCoord);
    }
    
    public void removeWarZone(WorldCoord worldCoord) {
        try {
            worldCoord.getTownyWorld().removeWarZone(worldCoord);
        } catch (NotRegisteredException e) {
            // Not a registered world
        }
        Towny.getPlugin().updateCache(worldCoord);
    }
    
    public TownyPermissionSource getPermissionSource() {
        return permissionSource;
    }
    
    public void setPermissionSource(TownyPermissionSource permissionSource) {
        this.permissionSource = permissionSource;
    }
    
    public War getWarEvent() {
        return warEvent;
    }
    
    public void setWarEvent(War warEvent) {
        this.warEvent = warEvent;
    }
    
    public String getRootFolder() {
        return pluginFolder;
    }
	@Deprecated
	public ConcurrentHashMap<String, TownyWorld> getWorldMap() {
		ConcurrentHashMap<String, TownyWorld> output = new ConcurrentHashMap<>();
		for (TownyWorld townyWorld : worlds.values()) {
			output.put(townyWorld.getName(), townyWorld);
		}
		return output;
	} 
	
    @Deprecated
    public ConcurrentHashMap<String, Nation> getNationsMap() {
    	ConcurrentHashMap<String, Nation> output = new ConcurrentHashMap<>();
		for (Nation nation : nations.values()) {
			output.put(nation.getName(), nation);
		}
        return output;
    }
	@Deprecated
	public ConcurrentHashMap<String, Town> getTownsMap() {
		ConcurrentHashMap<String, Town> output = new ConcurrentHashMap<>();
		for (Town town : towns.values()) {
			output.put(town.getName(), town);
		}
		return output;
	}
	
    @Deprecated
    public ConcurrentHashMap<String, Resident> getResidentMap() {
		ConcurrentHashMap<String, Resident> output = new ConcurrentHashMap<>();
		for (Resident resident : residents.values()) {
			output.put(resident.getName(), resident);
		}
		return output;
    }
	
	public List<TownyWorld> getWorlds() {
		return new ArrayList<>(worlds.values());
	}
	
	public List<Nation> getNations() {
		return new ArrayList<>(nations.values());
	}
	
	public List<Town> getTowns() {
		return new ArrayList<>(towns.values());
	}
	
	public List<Resident> getResidents() {
		return new ArrayList<>(residents.values());
	}
	
	public List<TownBlock> getTownBlocks() {
		return new ArrayList<>(townBlocks.values());
	}
    
	public List<Resident> getJailedResidentMap() {
		return jailedResidents;
	}
    
    public TownyDataSource getDataSource() {
        return dataSource;
    }
    
    public boolean backupDatabase() {
		return database.backup();
	}
    
    public List<String> getTreeString(int depth) {
        
        List<String> out = new ArrayList<>();
        out.add(getTreeDepth(depth) + "Universe (1)");
        if (Towny.getPlugin() != null) {
            out.add(getTreeDepth(depth + 1) + "Server (" + Bukkit.getServer().getName() + ")");
            out.add(getTreeDepth(depth + 2) + "Version: " + Bukkit.getServer().getVersion());
            //out.add(getTreeDepth(depth + 2) + "Players: " + BukkitTools.getOnlinePlayers().length + "/" + BukkitTools.getServer().getMaxPlayers());
            out.add(getTreeDepth(depth + 2) + "Worlds (" + Bukkit.getWorlds().size() + "): " + Arrays.toString(Bukkit.getWorlds().toArray(new World[0])));
        }
        out.add(getTreeDepth(depth + 1) + "Worlds (" + worlds.size() + "):");
        for (TownyWorld world : worlds.values()) {
            out.addAll(world.getTreeString(depth + 2));
        }
        
        out.add(getTreeDepth(depth + 1) + "Nations (" + nations.size() + "):");
        for (Nation nation : nations.values()) {
            out.addAll(nation.getTreeString(depth + 2));
        }
        
        Collection<Town> townsWithoutNation = dataSource.getTownsWithoutNation();
        out.add(getTreeDepth(depth + 1) + "Towns (" + townsWithoutNation.size() + "):");
        for (Town town : townsWithoutNation) {
            out.addAll(town.getTreeString(depth + 2));
        }
        
        Collection<Resident> residentsWithoutTown = dataSource.getResidentsWithoutTown();
        out.add(getTreeDepth(depth + 1) + "Residents (" + residentsWithoutTown.size() + "):");
        for (Resident resident : residentsWithoutTown) {
            out.addAll(resident.getTreeString(depth + 2));
        }
        return out;
    }
    
    private String getTreeDepth(int depth) {
        
        char[] fill = new char[depth * 4];
        Arrays.fill(fill, ' ');
        if (depth > 0) {
            fill[0] = '|';
            int offset = (depth - 1) * 4;
            fill[offset] = '+';
            fill[offset + 1] = '-';
            fill[offset + 2] = '-';
        }
        return new String(fill);
    }
    
    /**
     * Pretty much this method checks if a townblock is contained within a list of locations.
     *
     * @param minecraftcoordinates - List of minecraft coordinates you should probably parse town.getAllOutpostSpawns()
     * @param tb                   - TownBlock to check if its contained..
     * @return true if the TownBlock is considered an outpost by it's Town.
     * @author Lukas Mansour (Articdive)
     */
    public boolean isTownBlockLocContainedInTownOutposts(List<Location> minecraftcoordinates, TownBlock tb) {
        if (minecraftcoordinates != null && tb != null) {
            for (Location minecraftcoordinate : minecraftcoordinates) {
                if (Coord.parseCoord(minecraftcoordinate).equals(tb.getCoord())) {
                    return true; // Yes the TownBlock is considered an outpost by the Town
                }
            }
        }
        return false;
    }
    
    public void addCustomCustomDataField(CustomDataField cdf) throws KeyAlreadyRegisteredException {
    	
    	if (this.getRegisteredMetadataMap().containsKey(cdf.getKey()))
    		throw new KeyAlreadyRegisteredException();
    	
    	this.getRegisteredMetadataMap().put(cdf.getKey(), cdf);
	}
	
	public HashMap<String, CustomDataField> getRegisteredMetadataMap() {
		return registeredMetadata;
	}
	
	public boolean unsafeDelete(Saveable saveable) {
    	return database.delete(saveable);
	}
	
	public boolean save(Saveable saveable) {
		return database.save(saveable);
	}
	
	public static TownyUniverse getInstance() {
		if (instance == null) {
			instance = new TownyUniverse();
		}
		return instance;
	}
}
