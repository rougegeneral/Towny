package com.palmergames.bukkit.towny.database;

import com.palmergames.bukkit.towny.Towny;
import com.palmergames.bukkit.towny.database.io.FileManager;
import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.TownyWorld;
import com.palmergames.util.FileMgmt;
import org.apache.logging.log4j.Level;

import javax.annotation.Nonnull;
import java.io.File;
import java.util.HashMap;
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
	private final String databaseFilePath;
	
	public TownyFlatFileDatabase() {
		databaseFilePath = Towny.getPlugin().getDataFolder() + File.separator + "database" + File.separator + "flatfile" + File.separator;
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
		// TODO: - Implement
		return new HashMap<>();
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
			Map<String, Object> keyedValues = obj.getKeyedValues();
			for (Map.Entry<String, Object> keyedValue : keyedValues.entrySet()) {
				contents.append(keyedValue.getKey()).append("=").append(keyedValue.getValue()).append(System.getProperty("line.separator"));
			}
			// Get file properties
			String fileName = obj.getStorableName() + ".txt";
			String filePath = obj.getStorableRootFilePath() + File.separator + fileName;
			DATABASE_LOGGER.log(Level.DEBUG, "Contents = " + contents); //TODO: Improve debugging
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
