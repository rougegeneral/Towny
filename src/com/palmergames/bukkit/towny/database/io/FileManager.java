package com.palmergames.bukkit.towny.database.io;

import com.palmergames.bukkit.towny.Towny;
import com.palmergames.bukkit.towny.TownyMessaging;
import org.bukkit.Bukkit;

import java.io.File;

/**
 * A simple class that provides convenience methods for saving, loading... etc.
 * @author Suneet Tipirneni (Siris)
 * @author Lukas Mansour (ArticDive)
 */
public class FileManager {

	/**
	 * Saves a file in the given directory with the contents specified.
	 * @param file The filepath of the file to store.
	 * @param contents The string representation of the file contents.
	 */
	public static void saveFile(File file, String contents) {
		// Create task thread.
		FileSaveTask task = new FileSaveTask(file, contents);

		TownyMessaging.sendDebugMsg("Saving file: " + file.getPath());
		
		// Save the file async? even though its using another thread? lol Bukkit you make me laugh.
		Bukkit.getScheduler().runTaskAsynchronously(Towny.getPlugin(), task);
	}
}
