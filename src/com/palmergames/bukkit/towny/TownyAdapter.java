package com.palmergames.bukkit.towny;

import com.palmergames.bukkit.towny.object.TownyWorld;
import org.bukkit.World;

/**
 * A class with convenience methods that deal with translating
 * bukkit objects into the towny-compatible objects.
 * 
 * @author Suneet Tipirneni (Siris)
 * @author Lukas Mansour (Articdive)
 */
public class TownyAdapter {
	public static TownyWorld wrapBukkitWorld(World world) {
		// Move properties over to wrapped world.
		TownyWorld wrappedWorld = new TownyWorld(world.getUID());
		wrappedWorld.setName(world.getName());
		
		return wrappedWorld;
	}
}
