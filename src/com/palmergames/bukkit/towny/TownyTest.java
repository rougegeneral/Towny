package com.palmergames.bukkit.towny;

import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownyWorld;

import java.util.UUID;

/**
 * A test class used to simplify mock testing for towny object interactions.
 * @author Suneet Tipirneni (Siris)
 */
public abstract class TownyTest {
	
	private Town mockTown;
	private TownyWorld mockWorld;
	private TownyUniverse townyUniverse = TownyUniverse.getInstance();

	/**
	 * Initialize a mock version of a town and and world, and uses the current universe object.
	 * The town is added to the world and the world is added to the universe through this constructor.
	 */
	public TownyTest() {
		// Instantiate objects.
		mockTown = new Town("HuntsVille");
		mockWorld = new TownyWorld("Europa");
		
		// Add necessary properties.
		mockWorld.setId(UUID.randomUUID());
		mockTown.setUuid(UUID.randomUUID());
		
		try {
			mockWorld.addTown(mockTown);
		} catch (Exception ignored) {}
		
		townyUniverse.addWorld(mockWorld);
		
	}

	/**
	 * Used to perform a crude test and get back a result.
	 * @param testName The name of the test, used to show what test was successful or not.
	 * @param test A boolean test to determine success or not.
	 */
	public void checkOff(String testName, boolean test) {
		Character symbol = (test) ? '✓' : 'X';
		Towny.getPlugin().getLogger().info(  symbol + " - " + testName);
	}
	
	public Town getMockTown() {
		return mockTown;
	}

	public TownyWorld getMockWorld() {
		return mockWorld;
	}

	public TownyUniverse getTownyUniverse() {
		return townyUniverse;
	}

	public String getBeginTestMessage() {
		return "---------- %s ----------";
	}
}
