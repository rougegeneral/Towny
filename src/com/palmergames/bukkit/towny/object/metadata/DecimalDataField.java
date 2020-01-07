package com.palmergames.bukkit.towny.object.metadata;

import javax.annotation.Nonnull;

public class DecimalDataField extends CustomDataField<Double> {
	
	public DecimalDataField(@Nonnull String name) {
		super(name);
	}

	@Override
	public Double parseInput(String input) {
		return Double.parseDouble(input);
	}

	@Override
	public Double degenerify(Object obj) {
		if (obj instanceof Double) {
			return (Double) obj;
		}
		
		return null;
	}
}
