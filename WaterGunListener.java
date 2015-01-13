package com.gmail.www.woodrow73.pvpstorm;




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
