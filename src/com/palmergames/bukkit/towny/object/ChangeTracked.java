package com.palmergames.bukkit.towny.object;

/**
 * Source code used from WorldGuard (team and contributors)
 * 
 * An object that keeps track of a dirty flag that is set to true when changes
 *  * are made to this object.
 */
public interface ChangeTracked {
	/**
	 * Tests whether changes have been made.
	 *
	 * @return true if changes have been made
	 */
	boolean isDirty();

	/**
	 * Set whether changes have been made.
	 *
	 * @param dirty a new dirty state
	 */
	void setDirty(boolean dirty);
}
