package com.bghddevelopment.join.utilities;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public class Color {
    public static String translate(final String value) {
        return ChatColor.translateAlternateColorCodes('&', value);
    }

}
