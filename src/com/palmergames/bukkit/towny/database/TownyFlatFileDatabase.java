package com.palmergames.bukkit.towny.database;

import com.palmergames.bukkit.towny.TownyMessaging;
import com.palmergames.bukkit.towny.database.io.FileManager;
import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.TownyWorld;

import java.io.File;
import java.util.Map;
import java.util.UUID;

/**
 * TownyDatabase-implementing class that deals with storing towny objects,
 * as text files.
 *
 * @author Lukas Mansour (ArticDive)
 * @author Suneet Tipirneni (Siris)
 * @see Saveable
 * @see TownyDatabase
 */
public final class TownyFlatFileDatabase extends TownyDatabase {
	@Override
	public boolean backup() {
		return false;
	}
	
	@Override
	public Map<UUID, Resident> loadResidents() {
		return null;
	}
	
	@Override
	public boolean loadResident(String identifier) {
		return false;
	}
	
	@Override
	public Map<UUID, Town> loadTowns() {
		return null;
	}
	
	@Override
	public boolean loadTown(String name) {
		return false;
	}
	
	@Override
	public Map<UUID, Nation> loadNations() {
		return null;
	}
	
	@Override
	public boolean loadNation(String name) {
		return false;
	}
	
	@Override
	public Map<UUID, TownyWorld> loadWorlds() {
		return null;
	}
	
	@Override
	public boolean loadTownyWorld(String name) {
		return false;
	}
	
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
		
		StringBuilder contents = new StringBuilder();
		
		for (Saveable obj : objs) {
			// Convert the obj to string in format: key=value.
			Map<String, String> keyedValues = obj.getKeyedValues();
			for (Map.Entry<String, String> keyedValue : keyedValues.entrySet()) {
				contents.append(keyedValue.getKey()).append("=").append(keyedValue.getValue()).append(System.getProperty("line.separator"));
			}
			// Get file properties
			String fileName = obj.getStorableName() + ".txt";
			String filePath = obj.getStorableRootFilePath() + File.separator + fileName;
			TownyMessaging.sendDebugMsg("Contents = " + contents);
			File file = new File(filePath);
			
			// Save file...
			FileManager.saveFile(file, contents.toString());
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
