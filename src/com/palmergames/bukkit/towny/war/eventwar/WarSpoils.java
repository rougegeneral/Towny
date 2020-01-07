package com.palmergames.bukkit.towny.war.eventwar;

import com.palmergames.bukkit.towny.object.economy.Economical;
import org.bukkit.Bukkit;
import org.bukkit.World;

public class WarSpoils implements Economical {
	
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