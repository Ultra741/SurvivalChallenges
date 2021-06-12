package ultradev.survivalchallenges.challenges;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import ultradev.survivalchallenges.util.Utilities;

public class UltraHardcore implements Listener {

    @EventHandler
    public void onPlayerTakeDamage(EntityDamageEvent e) {

        if(!(e.getEntity() instanceof Player)) {
            return;
        }

        Player p = (Player) e.getEntity();

        if(!(Utilities.getChallengeActive("ULTRA_HARDCORE"))) {
            return;
        }

        if(e.getCause().equals(EntityDamageEvent.DamageCause.CUSTOM)) {
            return;
        }

        p.damage(p.getHealth());

    }

}
