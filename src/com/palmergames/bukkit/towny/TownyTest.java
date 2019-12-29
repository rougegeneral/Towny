package com.palmergames.bukkit.towny;

import com.palmergames.bukkit.towny.object.Resident;
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
	private Resident mockResident;
	private TownyUniverse townyUniverse = TownyUniverse.getInstance();

	/**
	 * Initialize a mock version of a town and and world, and uses the current universe object.
	 * The town is added to the world and the world is added to the universe through this constructor.
	 */
	public TownyTest() {
		// Instantiate objects.
		mockTown = new Town(UUID.randomUUID());
		mockTown.setName("HuntsVille");
		mockWorld = new TownyWorld(UUID.randomUUID());
		mockWorld.setName("Europa");
		mockResident = new Resident(UUID.randomUUID());
		mockResident.setName("Jason");
		
		// Add necessary properties.
		try {
			mockWorld.addTown(mockTown);
			mockTown.addResident(getMockResident());
			mockTown.setMayor(getMockResident());
		} catch (Exception ignored) {}
		
		getTownyUniverse().addWorld(mockWorld);
		getTownyUniverse().addTown(mockTown);
		getTownyUniverse().addResident(getMockResident());
		
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
	
	public abstract void runTests();
	
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

	public Resident getMockResident() {
		return mockResident;
	}
}
