package com.palmergames.bukkit.towny.object.metadata;

import javax.annotation.Nonnull;

public class BooleanDataField extends CustomDataField<Boolean> {
	
	public BooleanDataField(@Nonnull String name) {
		super(name);
	}

	@Override
	public Boolean parseInput(String input) {
		return input.equalsIgnoreCase("true");
	}

	@Override
	public Boolean degenerify(Object obj) {
		return (Boolean)obj;
	}
}
