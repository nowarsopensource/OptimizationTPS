package dev.dicktalk.nowarssmp.optimizationtps.impl;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ChunkUnloaderCommand implements CommandExecutor {
    private ChunkUnloader chunkUnloader;

    public ChunkUnloaderCommand(ChunkUnloader chunkUnloader) {
        this.chunkUnloader = chunkUnloader;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("unloadchunks")) {
            chunkUnloader.unloadInactiveChunks();
            sender.sendMessage("Inactive chunks unloaded.");
            return true;
        }
        return false;
    }
}
