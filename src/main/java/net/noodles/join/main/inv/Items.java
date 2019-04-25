package net.noodles.join.main.inv;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
public class Items {

    public static ItemStack Glass(Player p) {
        ItemStack stone = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
        ItemMeta stonem = stone.getItemMeta();
        stonem.setDisplayName(" ");
        stone.setItemMeta(stonem);
        return stone;
    }
	
    
    private static String getColor(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    
    public static ItemStack Yes(Player p) {
        ItemStack stone = new ItemStack(Material.EMERALD);
        ItemMeta stonem = stone.getItemMeta();
        stonem.setDisplayName(ChatColor.GREEN + "Join");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Click to join!");
        stonem.setLore(lore);
        stone.setItemMeta(stonem);
        return stone;
    }

    public static ItemStack No (Player p) {
        ItemStack stone = new ItemStack(Material.TNT);
        ItemMeta stonem = stone.getItemMeta();
        stonem.setDisplayName(ChatColor.GREEN + "Quit");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Click to leave!");
        stonem.setLore(lore);
        stone.setItemMeta(stonem);
        return stone;
    }

    
}
