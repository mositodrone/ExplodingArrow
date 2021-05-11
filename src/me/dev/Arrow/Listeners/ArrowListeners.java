package me.dev.Arrow.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
//import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

import me.dev.Arrow.Main;
import net.minecraft.server.v1_16_R3.BlockSand;

public class ArrowListeners implements Listener{
  
	@SuppressWarnings("unused")
	private Main plugin;
	
	public ArrowListeners (Main plugin) {
		this.plugin = plugin;

		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	private ItemStack Glass(Material glass) {
		return null;
	}
	
	@EventHandler
	public void ExplodeOnContact(EntityDamageByEntityEvent e) {
	    Entity projectile = e.getDamager();
//		Environment nether = World.Environment.NETHER;
	    
	    if ((projectile instanceof Arrow)) {
	    	Arrow arrow = (Arrow)projectile; 
	    	Entity shooter = (Entity) arrow.getShooter();
	    	if (shooter instanceof Player) {
	    		Entity shot = e.getEntity();
	    		
	    		Location loc = shot.getLocation();
	    		
	    		shot.getWorld().spawnEntity(loc, EntityType.LIGHTNING);
	    		shot.getWorld().createExplosion(shot.getLocation(), 8.0f);
	    	    shot.setFireTicks(120);
	    	}
	    	
	    }
	    
	}
	@EventHandler
	public void ExplodeOnBlock(ProjectileHitEvent e) {
		Block block = e.getHitBlock();
		Location loc = block.getLocation();
		Entity projectile = e.getEntity();
		
		if ((projectile instanceof Arrow)) {
			Arrow arrow = (Arrow)projectile;
			Entity shooter = (Entity) arrow.getShooter();
			if (shooter instanceof Player) {
				block.getWorld().strikeLightningEffect(loc);
				block.getWorld().createExplosion(block.getLocation(), 9.0f);
			if (block instanceof BlockSand)	
				block.getWorld().spawnParticle(Particle.FALLING_LAVA, loc, 20);
			    block.getWorld().spawnEntity(loc, EntityType.AREA_EFFECT_CLOUD);
			    block.setType(Material.GLASS);
			    block.getWorld().dropItem(loc, Glass(Material.GLASS));
			}
		}
	}


}
