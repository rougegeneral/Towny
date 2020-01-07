package com.palmergames.bukkit.towny.event;

import com.palmergames.bukkit.towny.object.TownObject;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class NewTownEvent extends Event  {

    private static final HandlerList handlers = new HandlerList();
    
    private TownObject town;

    @Override
    public HandlerList getHandlers() {
    	
        return handlers;
    }
    
    public static HandlerList getHandlerList() {

		return handlers;
	}

    public NewTownEvent(TownObject town) {
        super(!Bukkit.getServer().isPrimaryThread());
        this.town = town;
    }

    /**
     *
     * @return the new town.
     */
    public TownObject getTown() {
        return town;
    }
    
}