/*
 * Copyright 2015 CrystalCraftMC
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.crystalcraftmc.ghastwhisperer;

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
