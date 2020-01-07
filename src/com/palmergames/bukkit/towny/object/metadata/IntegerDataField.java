package com.palmergames.bukkit.towny.object.metadata;

import javax.annotation.Nonnull;

public class IntegerDataField extends CustomDataField<Integer> {
	
	public IntegerDataField(@Nonnull String name) {
		super(name);
	}

	@Override
	public Integer parseInput(String input) {
		return Integer.parseInt(input);
	}

	@Override
	public Integer degenerify(Object obj) {
		return (Integer)obj;
	}

}
