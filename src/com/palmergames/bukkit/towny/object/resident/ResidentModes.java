package com.palmergames.bukkit.towny.object.resident;

import java.util.List;

/**
 * 
 * @author ElgarL
 *
 */
public interface ResidentModes {

	List<String> getModes();
	
	boolean hasMode(String mode);
	
	void toggleMode(String newModes[], boolean notify);
	
	void setModes(String modes[], boolean notify);
	
	void clearModes();
	

}
