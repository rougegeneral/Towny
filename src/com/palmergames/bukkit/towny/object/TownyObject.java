package com.palmergames.bukkit.towny.object;

import com.palmergames.bukkit.towny.TownyFormatter;
import com.palmergames.bukkit.towny.database.Changed;
import com.palmergames.bukkit.towny.database.Saveable;
import com.palmergames.bukkit.towny.object.metadata.CustomDataField;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

public abstract class TownyObject implements Saveable, Changed {
	private final UUID identifier;
	private String name;
	private boolean changed = false;
	
	private HashSet<CustomDataField> metadata = null;
	
	protected TownyObject(HashMap<String, Object> loadMap) {
		this.name = (String)loadMap.get("name");
		this.identifier = UUID.fromString((String)loadMap.get("identifier"));
	}
	
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
			//metadata.add(CustomDataField.load(objects[i]));
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
	
	// Because we're storing the file as the the UUID, we will,
	// just grab the UUID from the base Object so implementation
	// isn't needed in inheriting classes.
	@Override
	public String getStorableName() {
		return this.getIdentifier().toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TownyObject that = (TownyObject) o;
		return identifier.equals(that.identifier);
	}

	@Override
	public int hashCode() {
		return Objects.hash(identifier);
	}
	
	@Override
	public void setChanged(boolean changed) {
		this.changed = changed;
	}

	@Override
	public boolean isChanged() {
		return changed;
	}
}
