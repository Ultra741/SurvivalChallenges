package ultradev.survivalchallenges;

import org.bukkit.Material;

public class SurvivalChallenge {

    String id;
    String name;
    String description;
    Material material;
    boolean active;

    public SurvivalChallenge(String id, String name, String description, Material material, boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.material = material;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Material getMaterial() {
        return material;
    }

    public boolean getActive() {
        return active;
    }

    public String getActiveString() {
        if(active) {
            return "&aACTIVE";
        } else {
            return "&cINACTIVE";
        }
    }

    public void setActive(boolean value) {
        active = value;
    }

}
