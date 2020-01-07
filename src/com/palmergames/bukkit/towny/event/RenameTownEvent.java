package com.palmergames.bukkit.towny.event;

import com.palmergames.bukkit.towny.object.TownObject;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class RenameTownEvent extends Event  {

    private static final HandlerList handlers = new HandlerList();
    
    private String oldName;
    private TownObject town;

    @Override
    public HandlerList getHandlers() {
    	
        return handlers;
    }
    
    public static HandlerList getHandlerList() {

		return handlers;
	}

    public RenameTownEvent(String oldName, TownObject town) {
        super(!Bukkit.getServer().isPrimaryThread());
        this.oldName = oldName;
        this.town = town;
    }

    /**
     *
     * @return the old town name.
     */
    public String getOldName() {
        return oldName;
    }
    
    /**
    *
    * @return the town with it's changed name
    */
   public TownObject getTown() {
       return this.town;
   }
    
}