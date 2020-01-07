package com.palmergames.bukkit.towny;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.palmergames.bukkit.towny.object.town.Town;

public class JSONTest extends TownyTest {
	
	Gson gson;
	String contents;
	private boolean showContentsOnStart = false;
	
	public JSONTest() {
		// We want the json to be readable.
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		
		gson = builder.create();

		contents = gson.toJson(getMockTown());
		
		if (showContentsOnStart)
			Towny.getPlugin().getLogger().info("Sample Test Json:\n" + contents);
		
	}

	@Override
	public void runTests() {
		// Show that the tests are starting.
		Towny.getPlugin().getLogger().info(String.format(getBeginTestMessage(), "JSON TESTS STARTED!"));
		
		// Run through all relevant tests.
		testTownJSON();
		testTownWorldJSON();
		testTownMayorJSON();
		
		// Show that the tests are over.
		Towny.getPlugin().getLogger().info(String.format(getBeginTestMessage(), "JSON TESTS FINISHED!"));
	}

	public void testTownJSON() {
		Town loadedTown = loadTownFromJSON();
		
		// Make sure ID's are equal.
		boolean test = getMockTown().getWorld().getIdentifier().equals(loadedTown.getWorld().getIdentifier());
		checkOff("TOWN ID's ARE IDENTICAL", test);
	}
	
	public void testTownMayorJSON() {
		Town loadedTown = loadTownFromJSON();

		// Make sure ID's are equal.
		boolean test = getMockTown().getMayor().getIdentifier().equals(loadedTown.getMayor().getIdentifier());
		checkOff("TOWN MAYORS ARE IDENTICAL", test);
	}

	public void testTownWorldJSON() {
		// Get the contents from a json file (simulated).
		Town loadedTown = loadTownFromJSON();

		// Make sure ID's are equal.
		boolean test = getMockTown().getWorld().getIdentifier().equals(loadedTown.getWorld().getIdentifier());
		checkOff("TOWN WORLDS ARE IDENTICAL", test);
	}
	
	public Town loadTownFromJSON() {
		return gson.fromJson(contents, Town.class);
	}

	public void setShowContentsOnStart(boolean showContentsOnStart) {
		this.showContentsOnStart = showContentsOnStart;
	}
}

