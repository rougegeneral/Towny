package com.palmergames.bukkit.towny.database.io.json.serializers;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.internal.bind.JsonTreeReader;
import com.palmergames.bukkit.towny.object.Town;
import org.json.simple.JSONObject;

import java.lang.reflect.Type;

public class TownSerializer implements JsonSerializer<Town> {
	@Override
	public JsonElement serialize(Town town, Type type, JsonSerializationContext jsonSerializationContext) {
		
		// Get the normal json that would be used.
		JsonElement object = new Gson().toJsonTree(town);
		
		// Remove the unnecessary parts.
		object.getAsJsonObject().addProperty("world", town.getWorld().getId().toString());
		
		return object;
	}
}
