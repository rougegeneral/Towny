package com.palmergames.bukkit.towny.war.eventwar;

import com.palmergames.bukkit.towny.object.Econable;
import org.bukkit.Bukkit;
import org.bukkit.World;

public class WarSpoils implements Econable {
	
	@Override
	public World getBukkitWorld() {
		return Bukkit.getWorlds().get(0);
	}
	
	@Override
	public String getEconomyName() {
		//TODO: Make configurable.
		return "towny-war-chest";
	}
}