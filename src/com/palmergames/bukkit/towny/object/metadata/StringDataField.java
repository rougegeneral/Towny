package com.palmergames.bukkit.towny.object.metadata;

import javax.annotation.Nonnull;

public class StringDataField extends CustomDataField<String> {

	public StringDataField(@Nonnull String name) {
		super(name);
	}

	@Override
	public String parseInput(String input) {
		// A string is a string...
		return input;
	}

	@Override
	public String degenerify(Object obj) {
		return (String)obj;
	}
}
