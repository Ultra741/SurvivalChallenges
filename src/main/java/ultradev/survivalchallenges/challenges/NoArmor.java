package ultradev.survivalchallenges.challenges;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import ultradev.survivalchallenges.util.Utilities;

import java.util.ArrayList;
import java.util.List;

public class NoArmor implements Listener {

    private static void removeArmor(Player player) {

        List<Material> armorMaterials = new ArrayList<>();

        armorMaterials.add(Material.LEATHER_HELMET); armorMaterials.add(Material.LEATHER_CHESTPLATE);
        armorMaterials.add(Material.LEATHER_LEGGINGS); armorMaterials.add(Material.LEATHER_BOOTS);

        armorMaterials.add(Material.CHAINMAIL_HELMET); armorMaterials.add(Material.CHAINMAIL_CHESTPLATE);
        armorMaterials.add(Material.CHAINMAIL_LEGGINGS); armorMaterials.add(Material.CHAINMAIL_BOOTS);

        armorMaterials.add(Material.IRON_HELMET); armorMaterials.add(Material.IRON_CHESTPLATE);
        armorMaterials.add(Material.IRON_LEGGINGS); armorMaterials.add(Material.IRON_BOOTS);

        armorMaterials.add(Material.DIAMOND_HELMET); armorMaterials.add(Material.DIAMOND_CHESTPLATE);
        armorMaterials.add(Material.DIAMOND_LEGGINGS); armorMaterials.add(Material.DIAMOND_BOOTS);

        armorMaterials.add(Material.GOLDEN_HELMET); armorMaterials.add(Material.GOLDEN_CHESTPLATE);
        armorMaterials.add(Material.GOLDEN_LEGGINGS); armorMaterials.add(Material.GOLDEN_BOOTS);

        armorMaterials.add(Material.NETHERITE_HELMET); armorMaterials.add(Material.NETHERITE_CHESTPLATE);
        armorMaterials.add(Material.NETHERITE_LEGGINGS); armorMaterials.add(Material.NETHERITE_BOOTS);

        armorMaterials.add(Material.TURTLE_HELMET);

         for(Material armorMaterial : armorMaterials) {
             player.getInventory().remove(armorMaterial);
             player.getInventory().setHelmet(null);
             player.getInventory().setChestplate(null);
             player.getInventory().setLeggings(null);
             player.getInventory().setBoots(null);
         }

    }

    @EventHandler
    public void onPlayerInventoryClick(InventoryClickEvent e) {
        if(Utilities.getChallengeActive("NO_ARMOR")) {
           if(e.getWhoClicked() instanceof Player) {
               removeArmor((Player)e.getWhoClicked());
           }
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        if(Utilities.getChallengeActive("NO_ARMOR")) {
            removeArmor(e.getPlayer());
        }
    }

}
