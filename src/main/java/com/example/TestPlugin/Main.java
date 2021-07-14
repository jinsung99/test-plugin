package com.example.TestPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.example.TestPlugin.commands.RandomTeleportCommand;

public class Main extends JavaPlugin implements Listener {

    ConsoleCommandSender console = Bukkit.getConsoleSender();

    @Override
    public void onEnable()
    {
        console.sendMessage(ChatColor.AQUA + "[플러그인 활성화 중 입니다.]");

        this.getServer().getPluginManager().registerEvents(this, this);
        this.getCommand("rtp").setExecutor(new RandomTeleportCommand());
    }

    @Override
    public void onDisable()
    {
        console.sendMessage(ChatColor.AQUA + "[플러그인 비활성화 중 입니다.]");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e)
    {
        StringBuilder sb = new StringBuilder();
        sb
                .append(ChatColor.GREEN)
                .append("[+] ")
                .append(ChatColor.WHITE)
                .append(e.getPlayer().getDisplayName());

        e.setJoinMessage(sb.toString());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e)
    {
        StringBuilder sb = new StringBuilder();
        sb
                .append(ChatColor.RED)
                .append("[-] ")
                .append(ChatColor.WHITE)
                .append(e.getPlayer().getDisplayName());

        e.setQuitMessage(sb.toString());
    }
}
