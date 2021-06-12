package ultradev.survivalchallenges;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ultradev.survivalchallenges.challenges.*;
import ultradev.survivalchallenges.commands.ChallengesCommand;
import ultradev.survivalchallenges.config.ConfigManager;
import ultradev.survivalchallenges.events.InventoryClick;
import ultradev.survivalchallenges.util.Utilities;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin {

    private static Main main;

    private static final List<SurvivalChallenge> challenges = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic

        main = this;

        log("Registering commands...");

        getCommand("challenges").setExecutor(new ChallengesCommand());

        log("Done registering commands.");
        log("Registering events...");

        Bukkit.getServer().getPluginManager().registerEvents(new InventoryClick(), this);

        Bukkit.getServer().getPluginManager().registerEvents(new UltraHardcore(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new NoArmor(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new NoSleeping(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new NoObsidian(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new Vegetarian(), this);

        log("Done registering events.");
        log("Loading config...");

        getConfig().options().copyDefaults(true);
        saveConfig();

        ConfigManager.setup();

        log("Done loading config.");
        log("Loading challenges...");

        getChallenges().add(Utilities.getChallengeFromConfig("ULTRA_HARDCORE"));
        getChallenges().add(Utilities.getChallengeFromConfig("NO_ARMOR"));
        getChallenges().add(Utilities.getChallengeFromConfig("NO_SLEEPING"));
        getChallenges().add(Utilities.getChallengeFromConfig("NO_OBSIDIAN"));
        getChallenges().add(Utilities.getChallengeFromConfig("VEGETARIAN"));

        log("Done loading challenges.");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return main;
    }

    public static void log(String text) {
        System.out.println("[SurvivalChallenges] " + text);
    }

    public static List<SurvivalChallenge> getChallenges() {
        return challenges;
    }

}
