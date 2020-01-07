package com.palmergames.bukkit.towny.event;

import com.palmergames.bukkit.towny.object.TownObject;
import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.TownyWorld;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class TownBlockSettingsChangedEvent extends Event {

	private static final HandlerList handlers = new HandlerList();

	@Override
	public HandlerList getHandlers() {

		return handlers;
	}

	public static HandlerList getHandlerList() {

		return handlers;
	}

	private TownyWorld w;
	private TownObject t;
	private TownBlock tb;
	private TownBlockSettingsChangedEvent() {
		super(!Bukkit.getServer().isPrimaryThread());
	}
	
	
	public TownBlockSettingsChangedEvent (TownyWorld w) {
		this();
		this.w = w;
	}

	public TownBlockSettingsChangedEvent (TownObject t) {
		this();
		this.t = t;
	}

	public TownBlockSettingsChangedEvent (TownBlock tb) {
		this();
		this.tb = tb;
	}
	
	public TownyWorld getTownyWorld() {
		return w;
	}
	
	public TownObject getTown() {
		return t;
	}
	
	public TownBlock getTownBlock() {
		return tb;
	}

}
