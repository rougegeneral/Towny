package com.palmergames.bukkit.towny.event;

import java.util.ArrayList;
import java.util.List;

import com.palmergames.bukkit.towny.object.TownObject;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.palmergames.bukkit.towny.object.Nation;

public class EventWarStartEvent extends Event{
	private static final HandlerList handlers = new HandlerList();
	private List<TownObject> warringTowns = new ArrayList<>();
	private List<Nation> warringNations = new ArrayList<>();
	private double warSpoils;

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	public EventWarStartEvent(List<TownObject> warringTowns, List<Nation> warringNations, double warSpoils) {
		super(!Bukkit.getServer().isPrimaryThread());
		this.warringNations = warringNations;
		this.warringTowns = warringTowns;
		this.warSpoils = warSpoils;
		
	}

	/**
	 * The towns who have gone to war.
	 * 
	 * @return List&lt;Town&gt; - Towns at war at beginning.
	 */
	public List<TownObject> getWarringTowns() {
		return this.warringTowns;
	}
	
	/**
	 * The nations who have gone to war.
	 * 
	 * @return List&lt;Nation&gt; - Nations at war at beginning.
	 */
	public List<Nation> getWarringNations() {
		return this.warringNations;
	}

	/**
	 * To modify this amount use the EventWarPreStartEvent.
	 * 
	 * 
	 * @return double - Amount at play in war at beginning. 
	 */
	public double getWarSpoils() {
		return this.warSpoils;
	}
}
