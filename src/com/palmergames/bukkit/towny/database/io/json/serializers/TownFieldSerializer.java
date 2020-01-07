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
import com.palmergames.bukkit.towny.object.TownObject;

import java.lang.reflect.Type;
import java.util.UUID;

/**
 * A class which serialize towns to only an ID, to remove database complexity.
 *
 * @author Suneet Tipirneni (Siris)
 * @author Lukas Mansour (ArcticDive)
 */
public class TownFieldSerializer implements JsonSerializer<TownObject>, JsonDeserializer<TownObject> {

	@Override
	public JsonElement serialize(TownObject src, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(src.getIdentifier().toString());
	}

	@Override
	public TownObject deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		Gson gson = new Gson();

		// Convert String into UUID object
		UUID ID = UUID.fromString(json.getAsString());

		// Get Town from ID
		TownObject town = TownyUniverse.getInstance().getTown(ID);
		JsonElement jObj = gson.toJsonTree(town);

		return context.deserialize(jObj, typeOfT);
	}

	
}
