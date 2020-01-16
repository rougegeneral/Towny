package com.palmergames.bukkit.towny.database.results;

/**
 * @author Lukas Mansour (Articdive)
 * @author Suneet Tipirneni (Siris)
 */
public enum CreateResult {
	UNEXPECTED("Unexpected Error Occurred, while creating."),
	ALREADY_EXISTS("The specified data already exists."),
	SUCCESSFUL("The operation completed successfully."),
	INVALID_NAME("The name given for the data is not valid.");
	
	// A description for logging purposes mainly.
	String description;
	
	CreateResult(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
