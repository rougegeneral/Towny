package com.palmergames.bukkit.towny.object;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ResidentList {
	/**
	 * Get all the residents associated with this object.
	 * 
	 * @return A list of the Resident objects.
	 */
	List<Resident> getResidents();

	/**
	 * Tells whether the object has a given Resident.
	 * 
	 * @param name The name of the resident.
	 * @return true if they're part of the object false otherwise.
	 */
	boolean hasResident(@NotNull String name);

	/**
	 * Get's the outlaws associated with this object.
	 * 
	 * @return The outlaws.
	 */
	List<Resident> getOutlaws();
}
