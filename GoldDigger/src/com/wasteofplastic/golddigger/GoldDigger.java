package com.wasteofplastic.golddigger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Creates gold when a player mines stone!
 * @author tastybento
 *
 */
public class GoldDigger extends JavaPlugin {

    @Override
    public void onEnable() {
	// Enable the plugin
	
	// Load the config.yml file - not needed
	
	// Register commands
	getCommand("digdig").setExecutor(new digCommand());
	
	// Register event listeners
	// Get the manager that handles plugins
	PluginManager manager = getServer().getPluginManager();
	
	// Register the listener to blocks being broken by players
	manager.registerEvents(new BlockBreakListener(), this);
    }

    @Override
    public void onDisable() {
	// Disable the plugin
    }
}
