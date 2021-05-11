package me.dev.Arrow;

import org.bukkit.plugin.java.JavaPlugin;

import me.dev.Arrow.Listeners.ArrowListeners;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		new ArrowListeners(this);
	}

}
