package ultradev.survivalchallenges.challenges;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import ultradev.survivalchallenges.util.Utilities;

import java.util.ArrayList;
import java.util.List;

public class NoSleeping implements Listener {

    @EventHandler
    public void onPlayerSleep(PlayerInteractEvent e) {
        if(Utilities.getChallengeActive("NO_SLEEPING")) {
            if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

                List<Material> bedMaterials = new ArrayList<>();

                bedMaterials.add(Material.BLACK_BED); bedMaterials.add(Material.BLUE_BED);
                bedMaterials.add(Material.BROWN_BED); bedMaterials.add(Material.CYAN_BED);
                bedMaterials.add(Material.GRAY_BED); bedMaterials.add(Material.GREEN_BED);
                bedMaterials.add(Material.LIGHT_BLUE_BED); bedMaterials.add(Material.LIGHT_GRAY_BED);
                bedMaterials.add(Material.WHITE_BED); bedMaterials.add(Material.ORANGE_BED);
                bedMaterials.add(Material.MAGENTA_BED); bedMaterials.add(Material.YELLOW_BED);
                bedMaterials.add(Material.LIME_BED); bedMaterials.add(Material.PINK_BED);
                bedMaterials.add(Material.PURPLE_BED); bedMaterials.add(Material.RED_BED);

                for(Material bedMaterial : bedMaterials) {
                    if (e.getClickedBlock().getType().equals(bedMaterial)) {
                        e.setCancelled(true);
                        e.getClickedBlock().getLocation().getBlock().setType(Material.AIR);
                    }
                }

            }
        }
    }

}
