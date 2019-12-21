package com.palmergames.bukkit.towny.database;

import com.palmergames.util.FileMgmt;

import java.io.File;

/**
 * Used to save a towny file in a separate thread, to avoid
 * blocking main thread.
 * @author Suneet Tipirneni (Siris)
 */
public class FileSaveTask extends Thread {
	private File file;
	private String contents;
	
	public FileSaveTask(File file, String contents) {
		this.file = file;
		this.contents = contents;
	}
	
	@Override
	public void run() {
		// Save the given file.
		FileMgmt.stringToFile(contents, file);
	}
}
