package com.palmergames.bukkit.towny.database;

import java.util.Map;

/**
 * An interface used to generify the saving of towny objects.
 *
 * @author Suneet Tipirneni (Siris)
 * @author Lukas Mansour (ArcticDive)
 */
public interface Saveable {
	
	/**
	 * Gets the {@link Map} of keyed values corresponding to fields within
	 * the towny object implementing the interface.
	 *
	 * @return A {@link Map} keyed by field names and containing,
	 * field values as the values in the map.
	 */
	Map<String, Object> getKeyedValues();
	
	/**
	 * Used for flatfile storage (excluding json, because it uses {@link com.google.gson.Gson#toJson(Object)} to reflect fields)
	 * to determine the path which, the data file for this object will be stored.<br><br>
	 * <strong>This should not include the actual name for the file, refer to {@link #getStorableName()}</strong>
	 * <br><br>
	 * <strong>Note:</strong> Usually this is implemented via {@link com.palmergames.bukkit.towny.object.TownyObject}
	 * which is the UUID of the subclass of {@link com.palmergames.bukkit.towny.object.TownyObject}
	 *
	 * @return A String that represents the path of where the object data should be stored.
	 * 
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
