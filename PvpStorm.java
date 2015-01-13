package com.gmail.www.woodrow73.pvpstorm;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PvpStorm extends JavaPlugin {
	
	public void onEnable() {
		getLogger().info("PvP Storm enabled");
		wgl = new WaterGunListener(this);
	}
	public void onDisable() {
		
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(p.getName().equals("Jwood9198") || p.getName().equals("Jacc734") ||
					p.getName().equals("jflory7")) {
				if(cmd.getName().equalsIgnoreCase("ghastRide")) {
					wgl.cowboy(p);
					return true;
				}
				else if(cmd.getName().equalsIgnoreCase("ghastDisplay")) {
					wgl.display(p);
					return true;
				}
				
			}
		}
			Player p = (Player)sender;
			p.sendMessage("Hello");
			return true;
	}
	private WaterGunListener wgl;
}
