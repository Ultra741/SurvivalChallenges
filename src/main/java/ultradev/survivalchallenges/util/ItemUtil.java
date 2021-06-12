package ultradev.survivalchallenges.util;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemUtil {

    public ItemStack item;

    public ItemUtil(Material material) {
        item = new ItemStack(material);
    }

    public ItemUtil setName(String name) {

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        item.setItemMeta(meta);

        return this;

    }

    public ItemUtil addLore(String line) {

        ItemMeta meta = item.getItemMeta();

        List<String> lore = new ArrayList<>();

        try {
            lore.addAll(meta.getLore());
        } catch(NullPointerException npe) {
        }

        lore.add(ChatColor.translateAlternateColorCodes('&', line));

        meta.setLore(lore);

        item.setItemMeta(meta);

        return this;

    }

    public ItemUtil setTag(String key, String value) {

        item = NBTEditor.addString(item, key, value);

        return this;

    }

    public ItemUtil setButtonID(String id) {

        item = NBTEditor.addString(item, "button_id", id);

        return this;

    }

    public ItemUtil hideFlags() {

        ItemMeta meta = item.getItemMeta();

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        meta.addItemFlags(ItemFlag.HIDE_DYE);
        meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        item.setItemMeta(meta);

        return this;

    }

    public ItemStack buildItem() {
        return item;
    }

}
