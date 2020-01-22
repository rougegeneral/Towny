package com.palmergames.bukkit.towny.database;

/**
 * An interface which facilitates the process of marking objects
 * as changed or not, which is useful for saving large batches
 * of objects.
 */
public interface Changed {
	/**
	 * Returns if the specified object has unsaved changes.
	 *
	 * @return <code>true</code> if the object has been modified after being loaded in
	 * <code>false</code> otherwise.
	 */
	boolean isChanged();

	/**
	 * Sets the state of changes, specifically
	 * if this object has been modified after 
	 * loading it from the database.
	 *
	 * @param changed the boolean indicating if the state changed or not.
	 */
	void setChanged(boolean changed);
}
