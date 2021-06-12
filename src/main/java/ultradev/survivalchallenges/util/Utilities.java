package ultradev.survivalchallenges.util;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import ultradev.survivalchallenges.Main;
import ultradev.survivalchallenges.SurvivalChallenge;
import ultradev.survivalchallenges.config.ConfigManager;

public class Utilities {

    private static final Main main = Main.getInstance();

    public static boolean getChallengeActive(String id) {
        return ConfigManager.get().getBoolean("challenges." + id + ".active");
    }

    public static String getInventoryTitleFromConfig(String inventoryId) {
        return main.getConfig().getString("inventories." + inventoryId + ".title");
    }

    public static ItemUtil getItemFromConfig(String inventoryId, String itemId, boolean isButton) {

        String path = "inventories." + inventoryId + ".items." + itemId;

        ItemUtil returnItem = new ItemUtil(Material.valueOf(main.getConfig().getString(path + ".material")));

        returnItem.setName(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString(path + ".name")));

        if(isButton) {
            returnItem = returnItem.setButtonID(itemId.toUpperCase());
        }

        return returnItem;

    }

    public static int getInventoryItemIndexFromConfig(String inventoryId, String itemId) {
        return main.getConfig().getInt("inventories." + inventoryId + ".items." + itemId + ".index");
    }

    public static SurvivalChallenge getChallengeFromConfig(String challengeId) {

        String path = "challenges." + challengeId;

        return new SurvivalChallenge(
                challengeId,
                ChatColor.translateAlternateColorCodes('&', main.getConfig().getString(path + ".name")),
                ChatColor.translateAlternateColorCodes('&', main.getConfig().getString(path + ".description")),
                Material.valueOf(main.getConfig().getString(path + ".material")),
                Utilities.getChallengeActive(challengeId));

    }

    public static int getChallengeIndex(String id) {

        for(int i = 0; i < Main.getChallenges().size(); i++) {

            SurvivalChallenge element = Main.getChallenges().get(i);

            if(element.getId().equals(id)) {
                return i;
            }

        }

        return -1;

    }

    public static String getConfigMessage(String message) {
        return ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("messages." + message));
    }

    public static boolean enforcePermission(Player player, String permission) {

        if(player.hasPermission("survivalchallenges." + permission)) {
            return true;
        } else {
            player.sendMessage(Utilities.getConfigMessage("no-permission"));
            return false;
        }

    }

}
