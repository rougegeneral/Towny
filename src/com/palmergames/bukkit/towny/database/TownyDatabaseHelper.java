package com.palmergames.bukkit.towny.database;

import com.palmergames.bukkit.towny.database.results.CreateResult;
import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.TownyWorld;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Database helper class for Object Creation, Merging, Renaming and similiar processes.
 *
 * @author Lukas Mansour (ArticDive)
 * @author Suneet Tipirneni (Siris)
 */
public class TownyDatabaseHelper {
	/**
	 * Creates a new {@link TownyWorld} and adds it to the database.
	 *
	 * @param UUID {@link UUID} of the new world.
	 * @param name {@link String} containing the world name.
	 * @return {@link CreateResult}, enum containing the result of the world creation.
	 */
	@NotNull
	public static CreateResult newWorld(String UUID, String name) {
		return null;
	}
	
	/**
	 * Creates a new {@link Nation} and adds it to the database.
	 *
	 * @param UUID {@link UUID} of the new nation.
	 * @param name {@link String} containing the nation name.
	 * @param capital {@link Town} the capital of the nation.   
	 * @return {@link CreateResult}, enum containing the result of the nation creation.
	 */
	@NotNull
	public static CreateResult newNation(String UUID, String name, Town capital) {
		return null;
	}
	
	/**
	 * Creates a new {@link Town} and adds it to the database.
	 *
	 * @param UUID {@link UUID} of the new town.
	 * @param name {@link String} containing the town name.
	 * @param mayor {@link Resident} the mayor of the town.   
	 * @return {@link CreateResult}, enum containing the result of the town creation.
	 */
	@NotNull
	public static CreateResult newTown(String UUID, String name, Resident mayor) {
		return null;
	}
	
	/**
	 * Creates a new {@link Resident} and adds it to the database.
	 * Please note this is also used for NPCs.
	 *
	 * @param UUID - {@link UUID} of the Resident (Player's UUID or NPC's UUID)
	 * @param name - {@link String} containing the resident's name.
	 * @return {@link CreateResult}, enum containing the result of the resident creation.
	 */
	@NotNull
	public static CreateResult newResident(String UUID, String name) {
		return null;
	}
	
	/**
	 * Creates a new {@link TownBlock} and adds it to the database.
	 *
	 * @param UUID - {@link UUID} of the TownBlock
	 * @param x {@link Integer} of the townblock's x-coordinate 
	 * @param y {@link Integer} of the townblock's y-coordinate 
	 * @param world {@link TownyWorld} in which the townblock is located.   
	 * @return {@link CreateResult}, enum containing the result of the townblock creation.
	 */
	@NotNull
	public static CreateResult newTownBlock(String UUID, int x, int y, TownyWorld world) {
		return null;
	}
	
	
}
