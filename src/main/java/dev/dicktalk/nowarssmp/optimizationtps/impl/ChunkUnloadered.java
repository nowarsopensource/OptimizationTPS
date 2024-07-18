package dev.dicktalk.nowarssmp.optimizationtps.impl;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface ChunkUnloadered {


    boolean onCommand(CommandSender sender, Command command, String label, String[] args);
}
