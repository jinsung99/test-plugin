package com.example.TestPlugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RandomTeleportCommand implements CommandExecutor {
    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] args
    )
    {
        List<Player> playerList = this.getValidPlayerList();
        int size = playerList.size();
        if(size <= 1)
            return true;

        ArrayList<Location> originLocations = new ArrayList<Location>();
        int[] teleportSeed = shuffle(
                IntStream.range(0, size).toArray()
        );

        for(Player i : playerList)
            originLocations.add(i.getLocation());

        for(int i = 0; i < size; i++)
        {
            playerList
                    .get(i)
                    .teleport(originLocations.get(teleportSeed[i]));
        }

        return true;
    }

    private ArrayList<Player> getValidPlayerList()
    {
        Object[] playerList = Bukkit.getServer().getOnlinePlayers().toArray();
        ArrayList<Player> result = new ArrayList<Player>();

        for(Object o: playerList)
        {
            if(o instanceof Player)
                result.add((Player)o);
        }

        return result;
    }

    private int[] shuffle(int[] arr){

        for(int x = 0; x < arr.length; x++){
            int i = (int)(Math.random()*arr.length);
            int j = (int)(Math.random()*arr.length);

            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        return arr;
    }
}
