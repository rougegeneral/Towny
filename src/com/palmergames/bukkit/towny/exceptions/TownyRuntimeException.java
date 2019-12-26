package com.palmergames.bukkit.towny.exceptions;

/**
 * A simple class that wraps a runtime exception used for towny specific interactions.
 * @author Lukas Mansour (ArticDive)
 * @author Suneet Tipirneni (Siris)
 */
public class TownyRuntimeException extends RuntimeException {
	
	public TownyRuntimeException() {
		super();
	}
	
    public TownyRuntimeException(String s) {
    	super(s);
    }
}
