package com.palmergames.bukkit.towny.database;

import java.util.HashMap;

/**
 * An interface used to generify the saving of towny objects.
 * @author Suneet Tipirneni (Siris)
 * @author Lukas Mansour (ArcticDive)
 */
public interface Saveable {

	/**
	 * Gets the hashmap of keyed values corresponding to fields within
	 * the towny object implementing the interface.
	 * @return A {@link HashMap} keyed by field names and containing,
	 * field values as the values in the map.
	 */
	public HashMap<String, Object> getKeyedValues();

	/**
	 * Used for flatfile storage (including json) to determine the path which,
	 * the data file for this object will be stored. 
	 * @return A String that represents the path of where the object data should be stored.
	 */
	public String getStorableFilePath();

	/**
	 * Used for SQL storage (excluding json and standard flatfile) to determine
	 * the table name to store the object's properties in.
	 * @return A String detailing the table name.
	 */
	public String getTableName();
}
