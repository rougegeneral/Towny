package com.palmergames.bukkit.towny.database.io.json.serializers;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.palmergames.bukkit.towny.TownyUniverse;
import com.palmergames.bukkit.towny.object.world.TownyWorld;

import java.lang.reflect.Type;
import java.util.UUID;

/**
 * A class which serialize worlds to only an ID, to remove database complexity.
 * 
 * @author Suneet Tipirneni (Siris)
 * @author Lukas Mansour (ArcticDive)
 */
public class WorldFieldSerializer implements JsonSerializer<TownyWorld>, JsonDeserializer<TownyWorld> {

	@Override
	public JsonElement serialize(TownyWorld src, Type typeOfSrc, JsonSerializationContext context) {
		// Store the parent ID as a singular primitive json String.
		return new JsonPrimitive(src.getIdentifier().toString());
	}
	
	@Override
	public TownyWorld deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		
		Gson gson = new Gson();
		
		// Convert String into UUID object
		UUID ID = UUID.fromString(json.getAsString());
		
		// Get World from ID
		TownyWorld world = TownyUniverse.getInstance().getWorld(ID);
		JsonElement jObj = gson.toJsonTree(world);
		
		return context.deserialize(jObj, typeOfT);
	}
}
