package com.palmergames.bukkit.towny;

import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.TownyWorld;
import org.bukkit.World;
import org.bukkit.entity.Player;

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
	
	public static Resident wrapBukkitPlayer(Player player) {
		Resident wrappedPlayer = new Resident(player.getUniqueId());
		wrappedPlayer.setName(player.getName());
		
		return wrappedPlayer;
	}
}
