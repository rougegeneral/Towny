package com.palmergames.bukkit.towny.object;

import com.palmergames.bukkit.towny.TownyFormatter;
import com.palmergames.bukkit.towny.object.metadata.CustomDataField;

import java.util.HashSet;
import java.util.UUID;

public abstract class TownyObject {
	private final UUID identifier;
	private String name;
	
	private HashSet<CustomDataField> metadata = null;
	
	
	protected TownyObject(UUID identifier) {
		this.identifier = identifier;
	}

	public String getFormattedName() {

		return TownyFormatter.getFormattedName(this);
	}

	public void addMetaData(CustomDataField md) {
		if (getMetadata() == null)
			metadata = new HashSet<>();

		getMetadata().add(md);
	}

	public void removeMetaData(CustomDataField md) {
		if (!hasMeta())
			return;

		getMetadata().remove(md);

		if (getMetadata().size() == 0)
			this.metadata = null;
	}

	public HashSet<CustomDataField> getMetadata() {
		return metadata;
	}

	public boolean hasMeta() {
		return getMetadata() != null;
	}

	public void setMetadata(String str) {
		if (metadata == null)
			metadata = new HashSet<>();

		String[] objects = str.split(";");
		for (int i = 0; i < objects.length; i++) {
			metadata.add(CustomDataField.load(objects[i]));
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public UUID getIdentifier() {
		return identifier;
	}
}
