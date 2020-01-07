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
import com.palmergames.bukkit.towny.object.resident.Resident;

import java.lang.reflect.Type;
import java.util.UUID;

/**
 * A class which serialize towns to only an ID, to remove database complexity.
 *
 * @author Suneet Tipirneni (Siris)
 * @author Lukas Mansour (ArcticDive)
 */
public class ResidentFieldSerializer implements JsonSerializer<Resident>, JsonDeserializer<Resident> {

	@Override
	public JsonElement serialize(Resident src, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(src.getIdentifier().toString());
	}

	@Override
	public Resident deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		Gson gson = new Gson();

		// Convert String into UUID object
		UUID ID = UUID.fromString(json.getAsString());

		// Get Resident from ID
		Resident resident = TownyUniverse.getInstance().getResident(ID);
		JsonElement jObj = gson.toJsonTree(resident);

		return context.deserialize(jObj, typeOfT);
	}
}
