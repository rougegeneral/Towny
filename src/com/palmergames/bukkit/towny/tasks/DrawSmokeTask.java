package com.palmergames.bukkit.towny.tasks;

import com.palmergames.bukkit.towny.Towny;
import com.palmergames.bukkit.towny.object.coordinate.CellBorder;
import com.palmergames.bukkit.towny.object.coordinate.Coord;
import com.palmergames.bukkit.towny.object.world.WorldCoord;
import com.palmergames.bukkit.towny.utils.BorderUtil;
import com.palmergames.bukkit.util.BukkitTools;
import com.palmergames.bukkit.util.DrawSmokeTaskFactory;
import org.bukkit.entity.Player;

public class DrawSmokeTask extends TownyTimerTask{

	public DrawSmokeTask(Towny plugin) {

		super(plugin);
	}

	@Override
	public void run() {
		for (Player player: BukkitTools.getOnlinePlayers()) {
			if (plugin.hasPlayerMode(player, "constantplotborder")) {
				WorldCoord wc = new WorldCoord(player.getWorld().getName(), Coord.parseCoord(player.getLocation()));
				CellBorder cellBorder = BorderUtil.getPlotBorder(wc);
				cellBorder.runBorderedOnSurface(1, 2, DrawSmokeTaskFactory.sendToPlayer(player));
			}
		}
	}	
}
