package ultradev.survivalchallenges.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private static File file;
    private static FileConfiguration configFile;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("SurvivalChallenges").getDataFolder(), "data.yml");

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch(IOException ioe) {
            }
        }

        configFile = YamlConfiguration.loadConfiguration(file);

    }

    public static FileConfiguration get() {
        return configFile;
    }

    public static void save() {
        try {
            configFile.save(file);
        } catch(IOException ioe) {
        }

    }

}
