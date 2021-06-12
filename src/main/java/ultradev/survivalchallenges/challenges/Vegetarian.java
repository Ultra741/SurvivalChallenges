package ultradev.survivalchallenges.challenges;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import ultradev.survivalchallenges.util.Utilities;

import java.util.ArrayList;
import java.util.List;

public class Vegetarian implements Listener {

    @EventHandler
    public void onPlayerItemConsume(PlayerItemConsumeEvent e) {
        if(Utilities.getChallengeActive("VEGETARIAN")) {

            List<Material> foodMaterials = new ArrayList<>();

            foodMaterials.add(Material.PORKCHOP); foodMaterials.add(Material.COOKED_PORKCHOP);
            foodMaterials.add(Material.BEEF); foodMaterials.add(Material.COOKED_BEEF);
            foodMaterials.add(Material.CHICKEN); foodMaterials.add(Material.COOKED_CHICKEN);
            foodMaterials.add(Material.RABBIT); foodMaterials.add(Material.COOKED_RABBIT);
            foodMaterials.add(Material.MUTTON); foodMaterials.add(Material.COOKED_MUTTON);

            for(Material material : foodMaterials) {
                if(e.getItem().getType().equals(material)) {
                    e.setCancelled(true);
                }
            }

        }
    }

}
