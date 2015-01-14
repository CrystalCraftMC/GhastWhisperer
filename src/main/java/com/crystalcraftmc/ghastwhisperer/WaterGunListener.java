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

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class WaterGunListener implements Listener {
	MobString ms;
	ConfigureData cd;
	public WaterGunListener(PvpStorm plugin) {
		plugin.getLogger().info("water_gun_listener plugin enabled");
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		ms = new MobString(this);
		cd = new ConfigureData(this, ms);
	}
	
	public void display(Player p) {
		p.sendMessage(ChatColor.BOLD + "JFrame opening on your computer.");
		cd.display();
	}
	
	@EventHandler
	public void pdi(PlayerDropItemEvent e) {
		if(e instanceof Player) {
			String thrower = e.getPlayer().getName();
			if(thrower.equals("Jwood9198") || thrower.equals("Jacc734") || thrower.equals("jflory7")) {
				if(e.getItemDrop().getItemStack().isSimilar(new ItemStack(Material.CARROT_ITEM))) {
					this.cowboy(e.getPlayer());
				
				}
			}
		}
	}
	public void cowboy(Player p) {
		Location loc = p.getLocation();
		EntityType et = EntityType.GHAST;
		Ghast g = (Ghast)p.getWorld().spawnEntity(loc, et);
		ms.cowboy(p, g, loc);
		
		
	}
}
