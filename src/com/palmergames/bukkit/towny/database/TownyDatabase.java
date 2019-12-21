package com.palmergames.bukkit.towny.database;

import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.TownyWorld;

import java.util.List;

/**
 * @author Lukas Mansour (Articdive) & Suneet Tipirneni (Siris)
 */
public abstract class TownyDatabase {
	protected TownyDatabase() {
		
	}
	
	/**
	 * Backup the database
	 *
	 * @return true, if the backup was successfully carried out, false if otherwise.
	 */
	public abstract boolean backup();
	
	// Residents
	
	/**
	 * Finds all {@link Resident} dataset identifiers.
	 *
	 * @return {@link List<String>} dataset identifiers.
	 */
	public abstract List<String> loadResidents();
	
	/**
	 * Loads a {@link Resident} dataset with its identifier.
	 *
	 * @param identifier {@link Resident} name
	 * @return true, if the {@link Resident} was successfully loaded, false if otherwise.
	 */
	public abstract boolean loadResident(String identifier);
	
	/**
	 * Renames a {@link Resident} to its new name.
	 *
	 * @param resident {@link Resident} to rename.
	 * @param newName  {@link String} new name.
	 * @return true, if the {@link Resident} was successfully renamed, false if otherwise.
	 */
	public abstract boolean renameResident(Resident resident, String newName);
	
	/**
	 * Saves all {@link Resident} from memory to the database.
	 */
	public abstract void saveResidents();
	
	/**
	 * Saves a {@link Resident} from memory to the database.
	 *
	 * @param resident {@link Resident} to save.
	 * @return true, if the {@link Resident} was successfully saved, false if otherwise.
	 */
	public abstract boolean saveResident(Resident resident);
	
	/**
	 * Deletes a {@link Resident} from the database.
	 *
	 * @param resident {@link Resident} to delete.
	 * @return true, if the {@link Resident} was successfully deleted, false if otherwise.
	 */
	public abstract boolean deleteResident(Resident resident);
	
	// Towns
	
	/**
	 * Finds all {@link Town} datasets identifiers.
	 *
	 * @return {@link List<String>} dataset identifiers.
	 */
	public abstract List<String> loadTowns();
	
	/**
	 * Loads a {@link Town} dataset with its identifier.
	 *
	 * @param name {@link Town} name
	 * @return true, if the {@link Town} was successfully loaded, false if otherwise.
	 */
	public abstract boolean loadTown(String name);
	
	/**
	 * Renames a {@link Town} to its new name.
	 *
	 * @param town    {@link Town} to rename.
	 * @param newName {@link String} new name.
	 * @return true, if the {@link Town} was successfully renamed, false if otherwise.
	 */
	public abstract boolean renameTown(Town town, String newName);
	
	/**
	 * Saves all {@link Town} from memory to the database.
	 */
	public abstract void saveTowns();
	
	/**
	 * Saves a {@link Town} from memory to the database.
	 *
	 * @param town {@link Town} to save.
	 * @return true, if the {@link Town} was successfully saved, false if otherwise.
	 */
	public abstract boolean saveTown(Town town);
	
	/**
	 * Deletes a {@link Town} from the database.
	 *
	 * @param town {@link Town} to delete.
	 * @return true, if the {@link Town} was successfully deleted, false if otherwise.
	 */
	public abstract boolean deleteTown(Town town);
	
	// Nations
	
	/**
	 * Finds all {@link Nation} dataset identifiers.
	 *
	 * @return {@link List<String>} dataset identifiers.
	 */
	public abstract List<String> loadNations();
	
	/**
	 * Loads a {@link Nation} dataset with its identifier.
	 *
	 * @param name {@link Nation} name
	 * @return true, if the {@link Nation} was successfully loaded, false if otherwise.
	 */
	public abstract boolean loadNation(String name);
	
	/**
	 * Renames a {@link Nation} to its new name.
	 *
	 * @param nation  {@link Nation} to rename.
	 * @param newName {@link String} new name.
	 * @return true, if the {@link Nation} was successfully renamed, false if otherwise.
	 */
	public abstract boolean renameNation(Nation nation, String newName);
	
	/**
	 * Saves all {@link Nation} from memory to the database.
	 */
	public abstract void saveNations();
	
	/**
	 * Saves a {@link Nation} from memory to the database.
	 *
	 * @param nation {@link Nation} to save.
	 * @return true, if the {@link Nation} was successfully saved, false if otherwise.
	 */
	public abstract boolean saveNation(Nation nation);
	
	/**
	 * Deletes a {@link Nation} from the database.
	 *
	 * @param nation {@link Nation} to delete.
	 * @return true, if the {@link Nation} was successfully deleted, false if otherwise.
	 */
	public abstract boolean deleteNation(Nation nation);
	
	// Worlds
	
	/**
	 * Finds all {@link TownyWorld} dataset identifiers.
	 *
	 * @return {@link List<String>} dataset identifiers.
	 */
	public abstract List<String> loadWorlds();
	
	/**
	 * Loads a {@link TownyWorld} dataset with its identifier.
	 *
	 * @param name {@link TownyWorld} name
	 * @return true, if the {@link TownyWorld} was successfully loaded, false if otherwise.
	 */
	public abstract boolean loadTownyWorld(String name);
	
	/**
	 * Saves all {@link TownyWorld} from memory to the database.
	 */
	public abstract void saveWorlds();
	
	/**
	 * Saves a {@link TownyWorld} from memory to the database.
	 *
	 * @param world {@link TownyWorld} to save.
	 * @return true, if the {@link TownyWorld} was successfully saved, false if otherwise.
	 */
	public abstract boolean saveWorld(TownyWorld world);
	
	/**
	 * Deletes a {@link TownyWorld} from the database.
	 *
	 * @param world {@link TownyWorld} to delete.
	 * @return true, if the {@link TownyWorld} was successfully deleted, false if otherwise.
	 */
	public abstract boolean deleteWorld(TownyWorld world);
	
	// Townblocks
	
	/**
	 * Finds all {@link TownBlock} dataset identifiers.
	 *
	 * @return {@link List<String>} dataset identifiers.
	 */
	public abstract List<String> loadTownBlocks();
	
	/**
	 * Loads a {@link TownBlock} dataset with its identifier.
	 *
	 * @param x     {@link Integer} x-coordinate of the {@link TownBlock}
	 * @param z     {@link Integer} z-coordinate of the {@link TownBlock}
	 * @param world {@link TownyWorld} of the {@link TownBlock}
	 * @return true, if the {@link TownBlock} was successfully loaded, false if otherwise.
	 */
	public abstract boolean loadTownBlock(int x, int z, TownyWorld world);
	
	/**
	 * Saves all {@link TownBlock} from memory to the database.
	 */
	public abstract void saveTownBlocks();
	
	/**
	 * Saves a {@link TownBlock} from memory to the database.
	 *
	 * @param townBlock {@link TownBlock} to save.
	 * @return true, if the {@link TownBlock} was successfully saved, false if otherwise.
	 */
	public abstract boolean saveTownBlock(TownBlock townBlock);
	
	/**
	 * Deletes a {@link TownBlock} from the database.
	 *
	 * @param townBlock {@link TownBlock} to delete.
	 * @return true, if the {@link TownBlock} was successfully deleted, false if otherwise.
	 */
	public abstract boolean deleteWorld(TownBlock townBlock);
	
	// Regen
	public abstract void loadRegenQueue();
	
	public abstract void saveRegenQueue();
	
	public abstract void saveRegenData();
	
	public abstract void loadRegenData();
}
