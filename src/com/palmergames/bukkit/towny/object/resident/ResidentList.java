package com.palmergames.bukkit.towny.object.resident;

import java.util.List;

public interface ResidentList {

	List<Resident> getResidents();
	
	boolean hasResident(String name);
	
	List<Resident> getOutlaws();
}
