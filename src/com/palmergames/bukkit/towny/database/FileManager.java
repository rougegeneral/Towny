package com.palmergames.bukkit.towny.database;

import com.palmergames.bukkit.towny.Towny;
import org.bukkit.Bukkit;

import java.io.File;

public class FileManager {
	public static void saveFile(File file, String contents) {
		// Create task thread.
		FileSaveTask task = new FileSaveTask(file, contents);
		
		// Save the file async? even though its using another thread? lol Bukkit you make me laugh.
		Bukkit.getScheduler().runTaskAsynchronously(Towny.getPlugin(), task);
	}
}
