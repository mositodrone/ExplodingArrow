package me.dev.Main.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
//import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
//import org.bukkit.event.entity.ProjectileHitEvent;
//import org.bukkit.projectiles.ProjectileSource;

import me.dev.Main.Main;

public class ArrowListeners implements Listener{
  
	@SuppressWarnings("unused")
	private Main plugin;
	
	public ArrowListeners (Main plugin) {
		this.plugin = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	
	@EventHandler
	public void ExplodeOnContact(EntityDamageByEntityEvent e) {
	    Entity projectile = e.getDamager();
	    
	    if ((projectile instanceof Arrow)) {
	    	Arrow arrow = (Arrow)projectile;
	    	Entity shooter = (Entity) arrow.getShooter();
	    	if (shooter instanceof Player) {
	    		Entity shot = e.getEntity();
	    		
	    		shot.getWorld().createExplosion(shot.getLocation(), 25.0f);
	    	}
	    	
	    }
	    
	}
	
	
}
