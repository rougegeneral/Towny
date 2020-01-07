package com.palmergames.bukkit.towny.object.metadata;
import com.palmergames.bukkit.towny.exceptions.InvalidMetadataTypeException;

import javax.annotation.Nonnull;

public abstract class CustomDataField<T> implements Cloneable {
	
    private String name;
    private String label;
    
    public CustomDataField(@Nonnull String name) {
    	this.name = name;
	}

    public String getName() {
        return name;
    }
    
    @Deprecated
	public String getKey() { return name; }
    
    public String getLabel() {
    	if (hasLabel())
    		return label;
    	else
    		return "nil";
	}
	
	public boolean hasLabel() {
    	return label != null;
	}

	public void setLabel(String label) {
		this.label = label;
	}
    
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	// Used when user inputs data into field.
    public abstract T parseInput(String input);
    
    // Used to convert map values to defined objects. i.e `ConcurrentMap<CustomDataField<?>, Object> metadata`;
    public abstract T degenerify(Object obj);
}
