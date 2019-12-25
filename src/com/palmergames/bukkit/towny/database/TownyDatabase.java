package com.palmergames.bukkit.towny.database;

import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.TownyWorld;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Lukas Mansour (Articdive)
 * @author Suneet Tipirneni (Siris)
 * @see Saveable
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
	 * @return {@link List} dataset identifiers.
	 */
	
	public abstract Map<UUID, Resident> loadResidents();
	
	/**
	 * Loads a {@link Resident} dataset with its identifier.
	 *
	 * @param identifier {@link Resident} name
	 * @return true, if the {@link Resident} was successfully loaded, false if otherwise.
	 */
	public abstract boolean loadResident(String identifier);
	
	// Towns
	
	/**
	 * Finds all {@link Town} datasets identifiers.
	 *
	 * @return {@link List} dataset identifiers.
	 */
	@NotNull
	public abstract Map<UUID, Town> loadTowns();
	
	/**
	 * Loads a {@link Town} dataset with its identifier.
	 *
	 * @param name {@link Town} name
	 * @return true, if the {@link Town} was successfully loaded, false if otherwise.
	 */
	public abstract boolean loadTown(String name);
	
	// Nations
	
	/**
	 * Finds all {@link Nation} dataset identifiers.
	 *
	 * @return {@link List} dataset identifiers.
	 */
	public abstract Map<UUID, Nation> loadNations();
	
	/**
	 * Loads a {@link Nation} dataset with its identifier.
	 *
	 * @param name {@link Nation} name
	 * @return true, if the {@link Nation} was successfully loaded, false if otherwise.
	 */
	public abstract boolean loadNation(String name);
	
	// Worlds
	
	/**
	 * Finds all {@link TownyWorld} dataset identifiers.
	 *
	 * @return {@link List} of Strings that correspond to dataset identifiers.
	 */
	@NotNull
	public abstract Map<UUID, TownyWorld> loadWorlds();
	
	/**
	 * Loads a {@link TownyWorld} dataset with its identifier.
	 *
	 * @param name {@link TownyWorld} name
	 * @return true, if the {@link TownyWorld} was successfully loaded, false if otherwise.
	 */
	public abstract boolean loadTownyWorld(String name);
	
	// Townblocks
	
	/**
	 * Finds all {@link TownBlock} dataset identifiers.
	 *
	 * @return {@link List} dataset identifiers.
	 */
	@NotNull
	public abstract Map<UUID, TownBlock> loadTownBlocks();
	
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
	 * Saves any object conforming to the {@link Saveable} interface.
	 *
	 * @param objs The {@link Saveable} object(s) to be saved.
	 * @return A boolean indicating if the save was successful.
	 */
	public abstract boolean save(Saveable... objs);
	
	/**
	 * Deletes any object conforming to the {@link Saveable} interface.
	 * 
	 * @param objs The {@link Saveable} object(s) to be deleted.
	 * @return A boolean indicating if the deletion was successful.
	 */
	public abstract boolean delete(Saveable... objs);
	
	// Regen
	public abstract void loadRegenQueue();
	
	public abstract void saveRegenQueue();
	
	public abstract void saveRegenData();
	
	public abstract void loadRegenData();
}
