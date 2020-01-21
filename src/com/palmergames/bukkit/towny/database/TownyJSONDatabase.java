package com.palmergames.bukkit.towny.database;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.palmergames.bukkit.towny.Towny;
import com.palmergames.bukkit.towny.TownyMessaging;
import com.palmergames.bukkit.towny.database.io.FileManager;
import com.palmergames.bukkit.towny.object.TownyObject;
import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.TownyWorld;
import com.palmergames.util.FileMgmt;
import org.apache.logging.log4j.Level;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
	private String residentFilePath;
	private String worldFilePath;
	private String townBlockFilePath;
	private String townFilePath;
	
	public TownyJSONDatabase() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		
		// Make sure file format is readable.
		gsonBuilder.setPrettyPrinting();
		
		// Create.
		gson = gsonBuilder.create();
		
		// Make sure directories are in place.
		databaseFilePath = Towny.getPlugin().getDataFolder() + File.separator + "database" + File.separator + "json" + File.separator;
		residentFilePath = databaseFilePath + File.separator + "residents";
		worldFilePath = databaseFilePath + File.separator + "worlds";
		townBlockFilePath = databaseFilePath + File.separator + "townblocks";
		townFilePath = databaseFilePath + File.separator + "towns";
		FileMgmt.checkOrCreateFolders(
			databaseFilePath, 
			worldFilePath,
			databaseFilePath + File.separator + "nations",
			townFilePath,
			residentFilePath,
			townBlockFilePath);
	}
	
	@Override
	public boolean backup() {
		// TODO: - Implement
		return true;
	}
	
	@Nonnull
	@Override
	public Map<UUID, Resident> loadResidents() {
		return load(residentFilePath, Resident.class);
	}
	
	@Override
	public boolean loadResident(String identifier) {
		return true;
	}
	
	@Nonnull
    @Override
	public Map<UUID, Town> loadTowns() {
		return load(townFilePath, Town.class);
	}
	
	@Override
	public boolean loadTown(String name) {
		return true;
	}
	
	@Nonnull
	@Override
	public Map<UUID, Nation> loadNations() {
		// TODO: - Implement
		return new HashMap<>();
	}
	
	@Override
	public boolean loadNation(String name) {
		return true;
	}

	/**
	 * Loads a HashMap keyed by an UUID, and a town object itself.
	 * 
	 * @param path The root directory of where all the object files are listed.
	 * @param type The {@link TownyObject} subclass to load the file into.
	 * @param <T> The TownyObject type.
	 * @return A HashMap keyed by UUID and the type specified.
	 * 
	 * @author Suneet Tipirneni (Siris)
	 */
	private <T extends TownyObject> Map<UUID, T> load(String path, Class<T> type) {
		
		// Initialize map.
		HashMap<UUID, T> objMap = new HashMap<>();
		
		// Get files in directory.
		File[] files = FileMgmt.getFilesInDirectory(path);

		// Iterate through each file
		for (File residentFile : files) {

			// Create a reader to read the json file.
			JsonReader reader;
			try {
				reader = new JsonReader(new FileReader(residentFile));
			} catch (FileNotFoundException e) {
				TownyMessaging.sendErrorMsg(e.getMessage());
				continue;
			}

			// Get the object via gson and save it to the global map.
			T obj = gson.fromJson(reader, type);
			objMap.put(obj.getIdentifier(), obj);
		}

		return objMap;
	}
	
	@Nonnull
	@Override
	public Map<UUID, TownyWorld> loadWorlds() {
		return load(worldFilePath, TownyWorld.class);
	}
	
	@Override
	public boolean loadTownyWorld(String name) {
		return true;
	}
	
	@Nonnull
	@Override
	public Map<UUID, TownBlock> loadTownBlocks() {
		return load(townBlockFilePath, TownBlock.class);
	}
	
	@Override
	public boolean loadTownBlock(int x, int z, TownyWorld world) {
		return true;
	}
	
	@Override
	public boolean save(Saveable obj) {

		// Convert the obj to json.
		String contents = gson.toJson(obj);

		// Get file properties
		String fileName = obj.getStorableName() + ".json";
		String filePath = databaseFilePath + obj.getStorableRootFilePath() + File.separator + fileName;
		DATABASE_LOGGER.log(Level.DEBUG, "Contents = " + contents); //TODO: Improve debugging
		File file = new File(filePath);

		// Save file...
		FileManager.saveFile(file, contents);

		return true;
	}

	@Override
	public boolean delete(Saveable... objs) {
		return true;
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
