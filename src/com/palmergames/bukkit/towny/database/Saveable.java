package com.palmergames.bukkit.towny.database;

import com.google.gson.Gson;

import java.util.Map;

/**
 * An interface used to generify the saving of towny objects.
 *
 * @author Suneet Tipirneni (Siris)
 * @author Lukas Mansour (ArcticDive)
 */
public interface Saveable {
	
	/**
	 * Gets the hashmap of keyed values corresponding to fields within
	 * the towny object implementing the interface.
	 *
	 * @return A {@link Map} keyed by field names and containing,
	 * field values as the values in the map.
	 */
	Map<String, Object> getKeyedValues();
	
	/**
	 * Used for flatfile storage (excluding json, because it uses {@link Gson#toJson(Object)} to reflect fields)
	 * to determine the path which, the data file for this object will be stored.
	 * <strong>This should not include the actual name for the file, refer to {@link #getStorableName()}</strong>
	 *
	 * @return A String that represents the path of where the object data should be stored.
	 */
	String getStorableRootFilePath();
	
	/**
	 * Used for storage to determine the table name to store the object's
	 * properties in, or file to update/create.
	 * <strong>This should not include the file type (ending), this will be done automatically.</strong>
	 *
	 * @return A String detailing the storable name.
	 */
	String getStorableName();
}
