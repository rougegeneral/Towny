package com.palmergames.bukkit.towny.database.io.json.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.palmergames.bukkit.towny.object.TownyWorld;

import java.lang.reflect.Type;
import java.util.UUID;

public class TownyWorldSerializer implements JsonSerializer<TownyWorld> {

	@Override
	public JsonElement serialize(TownyWorld townyWorld, Type type, JsonSerializationContext jsonSerializationContext) {
		// Used for testing purposes.
		townyWorld.setId(UUID.randomUUID());
		
		// Create json object.
		JsonObject object = new JsonObject();
		object.addProperty("world", townyWorld.getId().toString());
		
		return object;
	}
}
