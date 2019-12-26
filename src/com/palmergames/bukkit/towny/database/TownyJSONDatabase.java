package com.palmergames.bukkit.towny.database;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.palmergames.bukkit.towny.Towny;
import com.palmergames.bukkit.towny.TownyMessaging;
import com.palmergames.bukkit.towny.database.io.FileManager;
import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.TownyWorld;
import com.palmergames.util.FileMgmt;
import org.jetbrains.annotations.NotNull;

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
	private String rootFilePath;
	
	public TownyJSONDatabase() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		
		// Make sure file format is readable.
		gsonBuilder.setPrettyPrinting();
		
		// Create.
		gson = gsonBuilder.create();
		
		// Make sure directories are in place.
		rootFilePath = Towny.getPlugin().getDataFolder() + File.separator + "data" + File.separator + "json" + File.separator;
		FileMgmt.checkOrCreateFolders(rootFilePath, rootFilePath + File.separator + "worlds");
	}
	
	@Override
	public boolean backup() {
		// TODO: - Implement
		return true;
	}
	
	@Override
	public Map<UUID, Resident> loadResidents() {
		// TODO: - Implement
		return new HashMap<>();
	}
	
	@Override
	public boolean loadResident(String identifier) {
		return false;
	}
	
	@NotNull
    @Override
	public Map<UUID, Town> loadTowns() {
		// TODO: - Implement
		return new HashMap<>();
	}
	
	@Override
	public boolean loadTown(String name) {
		return false;
	}
	
	@Override
	public Map<UUID, Nation> loadNations() {
		// TODO: - Implement
		return new HashMap<>();
	}
	
	@Override
	public boolean loadNation(String name) {
		return false;
	}
	
	@NotNull
	@Override
	public Map<UUID, TownyWorld> loadWorlds() {
		// TODO: - Implement
		return new HashMap<>();
	}
	
	@Override
	public boolean loadTownyWorld(String name) {
		return false;
	}
	
	@NotNull
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
			String filePath = rootFilePath + obj.getStorableRootFilePath() + File.separator + fileName;
			TownyMessaging.sendDebugMsg("Contents = " + contents); // TODO: Debug Message.
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
