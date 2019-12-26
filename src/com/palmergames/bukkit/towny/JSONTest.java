package com.palmergames.bukkit.towny;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.palmergames.bukkit.towny.object.Town;

public class JSONTest extends TownyTest {
	
	Gson gson;
	
	public JSONTest() {
		// We want the json to be readable.
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		
		gson = builder.create();
	}
	
	public void testTownJSON() {
		Towny.getPlugin().getLogger().info(String.format(getBeginTestMessage(), "JSON TOWN TEST"));
		
		// Get the saved json contents.
		String savedString = gson.toJson(getMockTown());
		Towny.getPlugin().getLogger().info("Sample Test Json:\n" + savedString);
		
		// Get the contents from a json file (simulated).
		Town loadedTown = gson.fromJson(savedString, Town.class);
		
		// Make sure ID's are equal.
		boolean test = getMockTown().getWorld().getId().equals(loadedTown.getWorld().getId());
		checkOff("TOWN ID's ARE IDENTICAL", test);

		Towny.getPlugin().getLogger().info(String.format(getBeginTestMessage(), "TEST FINISHED!"));
	}
}
