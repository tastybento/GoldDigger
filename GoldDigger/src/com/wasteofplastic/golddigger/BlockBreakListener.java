package com.wasteofplastic.golddigger;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;


public class BlockBreakListener implements Listener {

    /**
     * Listen for any blocks that get broken
     * @param event
     */
    @EventHandler()
    public void onBlockBreak(final BlockBreakEvent event) {
	Player player = event.getPlayer();
	Block block = event.getBlock();
	
	// Turn stone into gold!
	if (block.getType() == Material.STONE) {
	    // Make the stone air
	    block.setType(Material.AIR);
	    
	    // Make an item stack to drop. An item stack is a number of items of the same type
	    ItemStack goldStack = new ItemStack(Material.GOLD_INGOT, 3);
	    
	    // Now drop it naturally, i.e., throw it around randomly where the block was
	    player.getWorld().dropItemNaturally(block.getLocation(), goldStack);
	    
	    // Now, let's play a sound!
	    player.getWorld().playSound(player.getLocation(), Sound.ORB_PICKUP, 1F, 0.5F);
	    
	    // We are done!
	}
    }
    
    
}
