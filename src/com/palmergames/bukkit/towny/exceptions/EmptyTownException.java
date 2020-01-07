package com.palmergames.bukkit.towny.exceptions;

import com.palmergames.bukkit.towny.object.TownObject;

public class EmptyTownException extends Exception {

	private static final long serialVersionUID = 5058583908170407803L;
	private EmptyNationException emptyNationException;
	private TownObject town;

	public EmptyTownException(TownObject town) {

		setTown(town);
	}

	public EmptyTownException(TownObject town, EmptyNationException emptyNationException) {

		setTown(town);
		setEmptyNationException(emptyNationException);
	}

	public boolean hasEmptyNationException() {

		return emptyNationException != null;
	}

	public EmptyNationException getEmptyNationException() {

		return emptyNationException;
	}

	public void setEmptyNationException(EmptyNationException emptyNationException) {

		this.emptyNationException = emptyNationException;
	}

	public void setTown(TownObject town) {

		this.town = town;
	}

	public TownObject getTown() {

		return town;
	}
}
