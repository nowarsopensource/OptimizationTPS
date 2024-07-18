package dev.dicktalk.nowarssmp.optimizationtps;

import java.util.Locale;
import dev.dicktalk.nowarssmp.optimizationtps.impl.ChunkUnloader;
import dev.dicktalk.nowarssmp.optimizationtps.impl.ChunkUnloaderCommand;
import dev.dicktalk.nowarssmp.optimizationtps.impl.FireballBomb;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class OptimizationTPS extends JavaPlugin {
    public static OptimizationTPS ins;

    @Override
    public void onEnable() {
        // 初始化静态实例引用
        ins = this;
        Bukkit.getServer().getPluginManager().registerEvents(new FireballBomb(), this);
        getServer().getPluginManager().registerEvents(new ChunkUnloader(), this);
        getCommand("unloadchunks").setExecutor(new ChunkUnloaderCommand(new ChunkUnloader()));
    }

    @Override
    public void onDisable() {
    }
}
