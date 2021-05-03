package me.dev.Main;

import org.bukkit.plugin.java.JavaPlugin;

import me.dev.Main.Listeners.ArrowListeners;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		new ArrowListeners(this);
	}

}
