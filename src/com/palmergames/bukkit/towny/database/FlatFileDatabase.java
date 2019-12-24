package com.palmergames.bukkit.towny.database;

import com.palmergames.bukkit.towny.TownyMessaging;
import com.palmergames.bukkit.towny.database.io.FileManager;
import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.TownyWorld;

import java.io.File;
import java.util.List;
import java.util.Map;

public class FlatFileDatabase extends TownyDatabase {
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
