package com.palmergames.bukkit.towny.database;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.palmergames.bukkit.towny.Towny;
import com.palmergames.bukkit.towny.TownyMessaging;
import com.palmergames.bukkit.towny.database.io.FileManager;
import com.palmergames.bukkit.towny.database.io.json.deserializers.TownDeserializer;
import com.palmergames.bukkit.towny.database.io.json.serializers.TownSerializer;
import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.TownyWorld;
import com.palmergames.util.FileMgmt;

import java.io.File;
import java.util.List;

/**
 * TownyDatabase-implementing class that deals with storing towny objects,
 * as json files.
 * @author Lukas Mansour (ArticDive)
 * @author Suneet Tipirneni (Siris)
 * @see Saveable
 * @see TownyDatabase
 */
public class JSONDatabase extends TownyDatabase {
	private Gson gson;
	private String rootFilePath;
	
	public JSONDatabase() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		
		// Make sure file format is readable.
		gsonBuilder.setPrettyPrinting();
		
		// Register custom serializers.
		gsonBuilder.registerTypeAdapter(Town.class, new TownSerializer());
		gsonBuilder.registerTypeAdapter(Town.class, new TownDeserializer());
		
		// Create.
		gson = gsonBuilder.create();
		
		// Make sure directories are in place.
		rootFilePath = Towny.getPlugin().getDataFolder() + File.separator + "data" + File.separator + "json" + File.separator;
		FileMgmt.checkOrCreateFolders(rootFilePath, rootFilePath + File.separator + "worlds");
	}
	
	@Override
	public boolean backup() {
		return false;
	}
	
	@Override
	public List<String> loadResidents() {
		return null;
	}
	
	@Override
	public boolean loadResident(String identifier) {
		return false;
	}
	
	@Override
	public boolean renameResident(Resident resident, String newName) {
		return false;
	}
	
	@Override
	public boolean deleteResident(Resident resident) {
		return false;
	}
	
	@Override
	public List<String> loadTowns() {
		return null;
	}
	
	@Override
	public boolean loadTown(String name) {
		return false;
	}
	
	@Override
	public boolean renameTown(Town town, String newName) {
		return false;
	}
	
	@Override
	public boolean deleteTown(Town town) {
		return false;
	}
	
	@Override
	public List<String> loadNations() {
		return null;
	}
	
	@Override
	public boolean loadNation(String name) {
		return false;
	}
	
	@Override
	public boolean renameNation(Nation nation, String newName) {
		return false;
	}
	
	@Override
	public boolean deleteNation(Nation nation) {
		return false;
	}
	
	@Override
	public List<String> loadWorlds() {
		return null;
	}
	
	@Override
	public boolean loadTownyWorld(String name) {
		return false;
	}
	
	@Override
	public boolean deleteWorld(TownyWorld world) {
		return false;
	}
	
	@Override
	public List<String> loadTownBlocks() {
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
			String filePath = rootFilePath + obj.getStorableRootFilePath() + File.separator + fileName;
			TownyMessaging.sendDebugMsg("Contents = " + contents); // TODO: Debug Message.
			File file = new File(filePath);

			// Save file...
			FileManager.saveFile(file, contents);
		}
		
		return true;
	}

	@Override
	public boolean deleteWorld(TownBlock townBlock) {
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
