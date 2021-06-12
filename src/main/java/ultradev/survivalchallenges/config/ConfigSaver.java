package ultradev.survivalchallenges.config;

import ultradev.survivalchallenges.Main;
import ultradev.survivalchallenges.SurvivalChallenge;

public class ConfigSaver {

    public static void saveToConfig() {

        ConfigManager.get().set("challenges", "");

        for(int i = 0; i < Main.getChallenges().size(); i++) {

            SurvivalChallenge element = Main.getChallenges().get(i);

            ConfigManager.get().set("challenges." + element.getId() + ".active", element.getActive());

        }

        ConfigManager.save();

    }

}
