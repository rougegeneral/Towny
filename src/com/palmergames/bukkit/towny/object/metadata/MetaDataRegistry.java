package com.palmergames.bukkit.towny.object.metadata;

import com.palmergames.bukkit.towny.exceptions.AlreadyRegisteredException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A class that Stores the metadata in a centralized area.
 * @author Suneet Tipirneni (Siris)
 */
public class MetaDataRegistry {
	
	private ConcurrentHashMap<String, CustomDataField<?>> dataFields = new ConcurrentHashMap<>();
	
	public void register(CustomDataField<?> dataField) throws AlreadyRegisteredException {
		if (getDataFields().containsKey(dataField.getName())) {
			throw new AlreadyRegisteredException("The data field with the name \"" + dataField.getName() + "\" already exists.");
		}
		getDataFields().put(dataField.getName(), dataField);
	}


	public ConcurrentHashMap<String, CustomDataField<?>> getDataFields() {
		return dataFields;
	}
	
	public Map<CustomDataField<?>, Object> degenerify(Map<String, Object> rawValues) {
		
		Map<CustomDataField<?>, Object> values = new ConcurrentHashMap<>();
		
		for (Map.Entry<String, Object> entry : rawValues.entrySet()) {
			
			// Get data field
			CustomDataField<?> dataField = dataFields.get(entry.getKey());
			
			if (dataField != null) {
				Object defined = dataField.degenerify(entry.getValue());
				
				values.put(dataField, defined);
			}
		}
		
		return values;
	}
}
