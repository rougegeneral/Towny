package com.palmergames.bukkit.towny.database;

import com.palmergames.bukkit.towny.object.nation.Nation;
import com.palmergames.bukkit.towny.object.resident.Resident;
import com.palmergames.bukkit.towny.object.town.Town;
import com.palmergames.bukkit.towny.object.townblock.TownBlock;
import com.palmergames.bukkit.towny.object.world.TownyWorld;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.UUID;

/**
 * TownyDatabase-implementing class that deals with storing towny objects in SQL Databases
 *
 * @author Lukas Mansour (ArticDive)
 * @author Suneet Tipirneni (Siris)
 * @see Saveable
 * @see TownyDatabase
 */
public final class TownySQLDatabase extends TownyDatabase {
	@Override
	public boolean backup() {
		return false;
	}
	
	@Nonnull
	@Override
	public Map<UUID, Resident> loadResidents() {
		return null;
	}
	
	@Override
	public boolean loadResident(String identifier) {
		return false;
	}
	
	@Nonnull
	@Override
	public Map<UUID, Town> loadTowns() {
		return null;
	}
	
	@Override
	public boolean loadTown(String name) {
		return false;
	}
	
	@Nonnull
	@Override
	public Map<UUID, Nation> loadNations() {
		return null;
	}
	
	@Override
	public boolean loadNation(String name) {
		return false;
	}
	
	@Nonnull
    @Override
	public Map<UUID, TownyWorld> loadWorlds() {
		return null;
	}
	
	@Override
	public boolean loadTownyWorld(String name) {
		return false;
	}
	
	@Nonnull
	@Override
	public Map<UUID, TownBlock> loadTownBlocks() {
		return null;
	}
	
	@Override
	public boolean loadTownBlock(int x, int z, TownyWorld world) {
		return false;
	}
	
	@Override
	public boolean save(Saveable... objs) {
		return false;
	}
	
	@Override
	public boolean delete(Saveable... objs) {
		return false;
	}
	
	@Override
	public void loadRegenQueue() {
		
	}
	
	@Override
	public void saveRegenQueue() {
		
	}
	
	@Override
	public void saveRegenData() {
		
	}
	
	@Override
	public void loadRegenData() {
		
	}
}
