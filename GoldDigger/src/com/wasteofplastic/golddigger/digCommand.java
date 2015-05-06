package com.wasteofplastic.golddigger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class digCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	// Commands can come from the console or players
	// command - the registered command
	// label - what the user typed, which may be the same as command or an alias
	// args - text after the command
	
	// digdig is only for players
	if (!(sender instanceof Player)) {
	    // Tell the console that this command is just for players
	    sender.sendMessage("This command is just for players!");
	    // If you return false, the command usage will be shown from plugin.yml
	    return true;
	}
	
	// Cast sender as player so we can do player things with it
	Player player = (Player)sender;
	// Get this world so we can do things to it
	World world = player.getWorld();
	
	// Get the player's location
	Location playerLoc = player.getLocation();
	
	// make blocks around the player stone
	int length = 2;
	for (int x = playerLoc.getBlockX() - length; x <= playerLoc.getBlockX() + length; x++) {
	    for (int z = playerLoc.getBlockZ() - length; z <= playerLoc.getBlockZ() + length; z++) {
		// y is the height axis - we want it to only change blocks under our feet
		for (int y = playerLoc.getBlockY() - length; y < playerLoc.getBlockY(); y++) {
		    Block blockToChange = world.getBlockAt(x, y, z);
		    blockToChange.setType(Material.STONE);
		}
	    }
	}
	
	// Tell the player that we made stone!
	player.sendMessage(ChatColor.GREEN + "You made stone!");
	
	// Return true so that the help text is not shown
	return true;
    }
}
