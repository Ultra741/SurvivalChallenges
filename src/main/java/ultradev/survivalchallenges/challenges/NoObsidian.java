package ultradev.survivalchallenges.challenges;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import ultradev.survivalchallenges.util.Utilities;

public class NoObsidian implements Listener {

    @EventHandler
    public void onPlayerPlaceBlock(BlockPlaceEvent e) {
        if(Utilities.getChallengeActive("NO_OBSIDIAN")) {
            if(e.getBlockPlaced().getType().equals(Material.OBSIDIAN)) {
                e.getBlockPlaced().setType(Material.AIR);
            }
        }
    }
}
