package net.noodles.join.main;

import net.noodles.join.main.inv.ClickEvents;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main plugin;
    private static Main instance;


    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        instance = this;
        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public void registerEvents() {
        final PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new InvOpen(), this);
        pm.registerEvents(new ClickEvents(), this);


    }
    public void registerCommands() {

    }

    public static Main getInstance() {
        return instance;
    }


}
