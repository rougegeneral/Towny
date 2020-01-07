package com.palmergames.bukkit.towny.event;

import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.TownObject;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

 /**
 * @author Artuto
 *
 * Fired after a Resident has been removed from a Town rank.
 */
public class TownRemoveResidentRankEvent extends Event
{
	private static final HandlerList handlers = new HandlerList();

    private Resident resident;
    private String rank;
    private TownObject town;
    
    public TownRemoveResidentRankEvent(Resident resident, String rank, TownObject town) {
        super(!Bukkit.getServer().isPrimaryThread());
        this.resident = resident;
        this.rank = rank;
        this.town = town;
    }
    
     /**
     *
     * @return the resident that got removed the rank
     * */
    public Resident getResident()
    {
        return resident;
    }
    
     /**
     *
     * @return the removed rank
     * */
    public String getRank()
    {
        return rank;
    }
    
     /**
     *
     * @return the town this resident is part of
     * */
    public TownObject getTown()
    {
        return town;
    }

	@Override
	public HandlerList getHandlers() {

		return handlers;
	}
	
	public static HandlerList getHandlerList() {

		return handlers;
	}
}