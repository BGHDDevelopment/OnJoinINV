package net.noodles.join.main;

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


    }
    public void registerCommands() {

    }

    public static Main getInstance() {
        return instance;
    }


}
