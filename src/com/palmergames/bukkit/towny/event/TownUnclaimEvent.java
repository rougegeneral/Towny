package com.palmergames.bukkit.towny.event;

import com.palmergames.bukkit.towny.object.TownObject;
import com.palmergames.bukkit.towny.object.WorldCoord;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class TownUnclaimEvent extends Event  {

    private static final HandlerList handlers = new HandlerList();
    
    private TownObject town;
    private WorldCoord worldCoord;

    @Override
    public HandlerList getHandlers() {
    	
        return handlers;
    }
    
    public static HandlerList getHandlerList() {

		return handlers;
	}

    public TownUnclaimEvent(TownObject _town, WorldCoord _worldcoord) {
        super(!Bukkit.getServer().isPrimaryThread());
        this.town = _town;
        this.worldCoord = _worldcoord;
    }

    /**
     *
     * @return the Town.
     */
    public TownObject getTown() {
        return town;
    }
    
    /**
    *
    * @return the Unclaimed WorldCoord.
    *
    */
   public WorldCoord getWorldCoord() {
       return worldCoord;
   }
    
}