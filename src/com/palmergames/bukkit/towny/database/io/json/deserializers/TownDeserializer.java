package com.palmergames.bukkit.towny.database.io.json.deserializers;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.palmergames.bukkit.towny.TownyMessaging;
import com.palmergames.bukkit.towny.TownyUniverse;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownyWorld;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.UUID;

public class TownDeserializer implements JsonDeserializer<Town> {

	@Override
	public Town deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		// Get the json as an object.
		JsonObject jsonObject = json.getAsJsonObject();
		
		// Get the world ID from the object.
		String idStr = jsonObject.get("world").getAsString();
		
		// From the UUID get the world.
		TownyWorld world = getWorldFromUUID(UUID.fromString(idStr));
		
		// Edit the json to show the complete world object, to completely load the object.
		Gson gson = new Gson();
		json.getAsJsonObject().add("world", gson.toJsonTree(world));
		
		// Return the deserialized object.
		return gson.fromJson(json, typeOfT);
	}
	
	// Note a lot of this methods' contents will change in the future.
	public static TownyWorld getWorldFromUUID(UUID ID) {
		ArrayList<TownyWorld> worlds = new ArrayList<>(TownyUniverse.getInstance().getWorldMap().values());
		
		for (TownyWorld world : worlds) {
			if (world.getId().equals(ID)) {
				return world;
			}
		}
		
		return null;
	}
}
