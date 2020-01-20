package com.palmergames.bukkit.towny.object;

/**
 * A simple interface which allows classes to use the "dirty"
 * marking system to indicate that they've been changed or not.
 * 
 * @author Suneet Tipirneni (Siris)
 */
public interface Dirty {
	/**
	 * Returns if the class has been modified since it was loaded from 
	 * the database.
	 * 
	 * @return true for it being modified, false for it staying the same.
	 */
	boolean isDirty();
	
	void setDirty(boolean dirty);
}
