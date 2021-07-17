package com.example.TestPlugin;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventListener implements Listener {

    public EventListener(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        StringBuilder sb = new StringBuilder();
        sb
                .append(ChatColor.GREEN)
                .append("[+] ")
                .append(ChatColor.WHITE)
                .append(e.getPlayer().getDisplayName());

        e.setJoinMessage(sb.toString());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        StringBuilder sb = new StringBuilder();
        sb
                .append(ChatColor.RED)
                .append("[-] ")
                .append(ChatColor.WHITE)
                .append(e.getPlayer().getDisplayName());

        e.setQuitMessage(sb.toString());
    }
}
