package net.noodles.join.main;

import net.noodles.join.main.inv.InvCreator;
import net.noodles.join.main.inv.InvNames;
import net.noodles.join.main.inv.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import sun.security.jca.GetInstance;

import java.util.ArrayList;

public class InvOpen implements Listener {

    public static ArrayList<String> Join;


    public InvOpen() {
      this.Join = new ArrayList<>();

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        InvCreator.Main.setItem(3, Items.Yes(p));
        InvCreator.Main.setItem(5, Items.No(p));
        this.Join.add(p.getName());
/*        for (int i = 0; i < 9; ++i) {
            if (InvCreator.Main.getItem(i) == null) {
                InvCreator.Main.setItem(i, Items.Glass(p));
            }*/
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> p.openInventory(InvCreator.Main), 1);
    //  }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (this.Join.contains(p.getName())) {
            p.teleport(e.getFrom());
            p.openInventory(InvCreator.Main);
        } else {
            return;
        }
    }


    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equals(null)) {
            return;
        }
        if (e.getCurrentItem() == null) {
            return;
        }
        if (e.getView().getTitle().equals(InvNames.Main)) {
            e.setCancelled(true);
            if (e.getCurrentItem().equals(Items.Yes(p))) {
                this.Join.remove(p.getName());
                p.closeInventory();
                p.sendMessage(ChatColor.GREEN + "Successfully joined the server.");
            }
            if (e.getCurrentItem().equals(Items.No(p))) {
                this.Join.remove(p.getName());
                p.kickPlayer("You requested to quit the server.");
            }
        }
    }

    @EventHandler
    public void onCommand(final PlayerCommandPreprocessEvent e) {
        if (Main.plugin.getConfig().getBoolean("StopCommandUsage.Enabled")) {
            final Player p = e.getPlayer();
            if (this.Join.contains(p.getName())) {
                final String message = e.getMessage();
                final String[] array = message.split(" ");
                if (!array[0].equalsIgnoreCase("/msg") && !array[0].equalsIgnoreCase("/tell") && !array[0].equalsIgnoreCase("/r") && !array[0].equalsIgnoreCase("/whisper") && !array[0].equalsIgnoreCase("/t") && !array[0].equalsIgnoreCase("/w")) {
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onTalk(final AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();
        if (this.Join.contains(p.getName())) {
            e.setCancelled(true);
        }
    }

}

