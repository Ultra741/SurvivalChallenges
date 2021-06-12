package ultradev.survivalchallenges.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import ultradev.survivalchallenges.Main;
import ultradev.survivalchallenges.SurvivalChallenge;
import ultradev.survivalchallenges.config.ConfigSaver;
import ultradev.survivalchallenges.util.NBTEditor;
import ultradev.survivalchallenges.util.Utilities;

public class InventoryClick implements Listener {

    @EventHandler
    public void onPlayerInventoryClickEvent(InventoryClickEvent e) {

        if(!(e.getWhoClicked() instanceof Player)) {
            return;
        }

        Player p = (Player) e.getWhoClicked();

        String invName = e.getView().getTitle();

        if(invName.equalsIgnoreCase("Challenges")) {
            e.setCancelled(true);
        }

        ItemStack item = e.getCurrentItem();

        if(!(item == null)) {

            String buttonID = NBTEditor.getString(item, "button_id");

            switch (buttonID) {

                case "CLOSE":

                    p.closeInventory();
                    p.updateInventory();

                    break;

                case "CHALLENGE":

                    String challengeID = NBTEditor.getString(item, "challenge_id");
                    SurvivalChallenge challenge = Main.getChallenges().get(Utilities.getChallengeIndex(challengeID));

                    if(challenge.getActive()) {

                        challenge.setActive(false);
                        ConfigSaver.saveToConfig();

                        p.sendMessage(Utilities.getConfigMessage("challenge-disabled")
                        .replaceAll("%%name%%", challenge.getName()));

                    } else {

                        challenge.setActive(true);
                        ConfigSaver.saveToConfig();

                        p.sendMessage(Utilities.getConfigMessage("challenge-enabled")
                                .replaceAll("%%name%%", challenge.getName()));

                    }

                    p.closeInventory();
                    p.updateInventory();

                    break;

            }

        }

    }

}
