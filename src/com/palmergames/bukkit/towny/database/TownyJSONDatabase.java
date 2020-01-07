package com.palmergames.bukkit.towny.database;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.palmergames.bukkit.towny.Towny;
import com.palmergames.bukkit.towny.database.io.FileManager;
import com.palmergames.bukkit.towny.object.nation.Nation;
import com.palmergames.bukkit.towny.object.resident.Resident;
import com.palmergames.bukkit.towny.object.town.Town;
import com.palmergames.bukkit.towny.object.townblock.TownBlock;
import com.palmergames.bukkit.towny.object.world.TownyWorld;
import com.palmergames.util.FileMgmt;
import org.apache.logging.log4j.Level;

import javax.annotation.Nonnull;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * TownyDatabase-implementing class that deals with storing towny objects,
 * as json files.
 *
 * @author Lukas Mansour (ArticDive)
 * @author Suneet Tipirneni (Siris)
 * @see Saveable
 * @see TownyDatabase
 */
public final class TownyJSONDatabase extends TownyDatabase {
	private Gson gson;
	private String databaseFilePath;
	
	public TownyJSONDatabase() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		
		// Make sure file format is readable.
		gsonBuilder.setPrettyPrinting();
		
		// Create.
		gson = gsonBuilder.create();
		
		// Make sure directories are in place.
		databaseFilePath = Towny.getPlugin().getDataFolder() + File.separator + "database" + File.separator + "json" + File.separator;
		FileMgmt.checkOrCreateFolders(
			databaseFilePath, 
			databaseFilePath + File.separator + "worlds",
			databaseFilePath + File.separator + "nations",
			databaseFilePath + File.separator + "towns",
			databaseFilePath + File.separator + "residents",
			databaseFilePath + File.separator + "townblocks");
	}
	
	@Override
	public boolean backup() {
		// TODO: - Implement
		return true;
	}
	
	@Nonnull
	@Override
	public Map<UUID, Resident> loadResidents() {
		// TODO: - Implement
		return new HashMap<>();
	}
	
	@Override
	public boolean loadResident(String identifier) {
		return false;
	}
	
	@Nonnull
    @Override
	public Map<UUID, Town> loadTowns() {
		// TODO: - Implement
		return new HashMap<>();
	}
	
	@Override
	public boolean loadTown(String name) {
		return false;
	}
	
	@Nonnull
	@Override
	public Map<UUID, Nation> loadNations() {
		// TODO: - Implement
		return new HashMap<>();
	}
	
	@Override
	public boolean loadNation(String name) {
		return false;
	}
	
	@Nonnull
	@Override
	public Map<UUID, TownyWorld> loadWorlds() {
		// TODO: - Implement
		return new HashMap<>();
	}
	
	@Override
	public boolean loadTownyWorld(String name) {
		return false;
	}
	
	@Nonnull
	@Override
	public Map<UUID, TownBlock> loadTownBlocks() {
		return null;
	}
	
	@Override
	public boolean loadTownBlock(int x, int z, TownyWorld world) {
		return false;
	}
	
	@Override
	public boolean save(Saveable... objs) {
		
		for (Saveable obj : objs) {
			// Convert the obj to json.
			String contents = gson.toJson(obj);
			
			// Get file properties
			String fileName = obj.getStorableName() + ".json";
			String filePath = databaseFilePath + obj.getStorableRootFilePath() + File.separator + fileName;
			DATABASE_LOGGER.log(Level.DEBUG, "Contents = " + contents); //TODO: Improve debugging
			File file = new File(filePath);
			
			// Save file...
			FileManager.saveFile(file, contents);
		}
		
		return true;
	}
	
	@Override
	public boolean delete(Saveable... objs) {
		return false;
	}
	
	@Override
	public void loadRegenQueue() {
		
	}
	
	@Override
	public void saveRegenQueue() {
		
	}
	
	@Override
	public void saveRegenData() {
		
	}
	
	@Override
	public void loadRegenData() {
		
	}
}
