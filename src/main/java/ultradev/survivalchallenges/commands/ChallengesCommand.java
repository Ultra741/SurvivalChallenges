package ultradev.survivalchallenges.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import ultradev.survivalchallenges.Main;
import ultradev.survivalchallenges.SurvivalChallenge;
import ultradev.survivalchallenges.util.ItemUtil;
import ultradev.survivalchallenges.util.Utilities;

public class ChallengesCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage(Utilities.getConfigMessage("not-a-player"));
            return false;
        }

        Player p = (Player) sender;

        if(!(Utilities.enforcePermission(p, "challenges"))) {
            return false;
        }

        Inventory challenges = Bukkit.createInventory(null, 54,
                Utilities.getInventoryTitleFromConfig("challenges"));

        challenges.setItem(Utilities.getInventoryItemIndexFromConfig("challenges", "CLOSE"),
                Utilities.getItemFromConfig("challenges", "CLOSE", true).buildItem());

        for(int i = 0; i < Main.getChallenges().size(); i++) {

            SurvivalChallenge element = Main.getChallenges().get(i);

            challenges.setItem(i, new ItemUtil(element.getMaterial())
            .setName(element.getName())
            .addLore("&7" + element.getDescription())
            .addLore("")
            .addLore("&7Status: " + element.getActiveString())
            .addLore("")
            .addLore("&eClick to toggle!")
            .setButtonID("CHALLENGE")
            .setTag("challenge_id", element.getId())
                    .hideFlags()
            .buildItem());

        }

        p.openInventory(challenges);

        return false;

    }

}
