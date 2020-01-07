package com.palmergames.bukkit.towny.war.eventwar;

import com.palmergames.bukkit.towny.object.TownObject;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class TownScoredEvent extends Event {

	private static final HandlerList handlers = new HandlerList();
	
	@Override
	public HandlerList getHandlers() {

		return handlers;
	}

	public static HandlerList getHandlerList() {

		return handlers;
	}
	
	private TownObject town;
	private int score;
	
	public TownScoredEvent (TownObject town, int score)
	{
		super(!Bukkit.getServer().isPrimaryThread());
		this.town = town;
		this.score = score;
	}
	
	public TownObject getTown()
	{
		return town;
	}
	
	public int getScore()
	{
		return score;
	}

}
