package com.example.TestPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.example.TestPlugin.commands.RandomTeleportCommand;

public class Main extends JavaPlugin {

    ConsoleCommandSender console = Bukkit.getConsoleSender();

    @Override
    public void onEnable() {
        console.sendMessage(ChatColor.AQUA + "[플러그인 활성화 중 입니다.]");

        new EventListener(this);
        this.getCommand("rtp").setExecutor(new RandomTeleportCommand());
    }

    @Override
    public void onDisable() {
        console.sendMessage(ChatColor.AQUA + "[플러그인 비활성화 중 입니다.]");
    }
}
