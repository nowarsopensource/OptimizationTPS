package dev.dicktalk.nowarssmp.optimizationtps.impl;

import dev.dicktalk.nowarssmp.optimizationtps.OptimizationTPS;
import net.kyori.adventure.identity.Identified;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;
import java.util.UUID;

public class ChunkUnloader implements Listener, ChunkUnloadered,CommandSender {
    private OptimizationTPS ins =OptimizationTPS.ins;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("unloadchunks")) {
            unloadInactiveChunks();
            sender.sendMessage("Inactive chunks unloaded.");
            return true;
        }
        return false;
    }

    @EventHandler
    public void onServerLoad(ServerLoadEvent event) {
        double tps = ins.getServer().getTPS()[0];
        if (tps < 17) {
            unloadInactiveChunks();
        }
    }

    void unloadInactiveChunks() {
        for (World world : ins.getServer().getWorlds()) {
            for (Chunk chunk : world.getLoadedChunks()) {
                if (!world.isChunkInUse(chunk.getX(), chunk.getZ())) {
                    world.unloadChunk(chunk);
                }
            }
        }
    }

    /**
     * Sends this sender a message
     *
     * @param message Message to be displayed
     * @see #sendMessage(Component)
     * @see #sendPlainMessage(String)
     * @see #sendRichMessage(String)
     */
    @Override
    public void sendMessage(@NotNull String message) {

    }

    /**
     * Sends this sender multiple messages
     *
     * @param messages An array of messages to be displayed
     * @see #sendMessage(Component)
     * @see #sendPlainMessage(String)
     * @see #sendRichMessage(String)
     */
    @Override
    public void sendMessage(@NotNull String... messages) {

    }

    /**
     * Sends this sender a message
     *
     * @param sender  The sender of this message
     * @param message Message to be displayed
     * @see #sendMessage(Identified, Component)
     * @deprecated sender UUID is ignored
     */
    @Override
    public void sendMessage(@Nullable UUID sender, @NotNull String message) {

    }

    /**
     * Sends this sender multiple messages
     *
     * @param sender   The sender of this message
     * @param messages An array of messages to be displayed
     * @see #sendMessage(Identified, Component)
     * @deprecated sender UUID is ignored
     */
    @Override
    public void sendMessage(@Nullable UUID sender, @NotNull String... messages) {

    }

    /**
     * Returns the server instance that this command is running on
     *
     * @return Server instance
     */
    @Override
    public @NotNull Server getServer() {
        return null;
    }

    /**
     * Gets the name of this command sender
     *
     * @return Name of the sender
     */
    @Override
    public @NotNull String getName() {
        return "";
    }

    /**
     * @return
     */
    @NotNull
    @Override
    public Spigot spigot() {
        return null;
    }

    /**
     * Gets the name of this command sender
     *
     * @return Name of the sender
     */
    @Override
    public @NotNull Component name() {
        return null;
    }

    /**
     * Checks if this object contains an override for the specified
     * permission, by fully qualified name
     *
     * @param name Name of the permission
     * @return true if the permission is set, otherwise false
     */
    @Override
    public boolean isPermissionSet(@NotNull String name) {
        return false;
    }

    /**
     * Checks if this object contains an override for the specified {@link
     * Permission}
     *
     * @param perm Permission to check
     * @return true if the permission is set, otherwise false
     */
    @Override
    public boolean isPermissionSet(@NotNull Permission perm) {
        return false;
    }

    /**
     * Gets the value of the specified permission, if set.
     * <p>
     * If a permission override is not set on this object, the default value
     * of the permission will be returned.
     *
     * @param name Name of the permission
     * @return Value of the permission
     */
    @Override
    public boolean hasPermission(@NotNull String name) {
        return false;
    }

    /**
     * Gets the value of the specified permission, if set.
     * <p>
     * If a permission override is not set on this object, the default value
     * of the permission will be returned
     *
     * @param perm Permission to get
     * @return Value of the permission
     */
    @Override
    public boolean hasPermission(@NotNull Permission perm) {
        return false;
    }

    /**
     * Adds a new {@link PermissionAttachment} with a single permission by
     * name and value
     *
     * @param plugin Plugin responsible for this attachment, may not be null
     *               or disabled
     * @param name   Name of the permission to attach
     * @param value  Value of the permission
     * @return The PermissionAttachment that was just created
     */
    @Override
    public @NotNull PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String name, boolean value) {
        return null;
    }

    /**
     * Adds a new empty {@link PermissionAttachment} to this object
     *
     * @param plugin Plugin responsible for this attachment, may not be null
     *               or disabled
     * @return The PermissionAttachment that was just created
     */
    @Override
    public @NotNull PermissionAttachment addAttachment(@NotNull Plugin plugin) {
        return null;
    }

    /**
     * Temporarily adds a new {@link PermissionAttachment} with a single
     * permission by name and value
     *
     * @param plugin Plugin responsible for this attachment, may not be null
     *               or disabled
     * @param name   Name of the permission to attach
     * @param value  Value of the permission
     * @param ticks  Amount of ticks to automatically remove this attachment
     *               after
     * @return The PermissionAttachment that was just created
     */
    @Override
    public @Nullable PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String name, boolean value, int ticks) {
        return null;
    }

    /**
     * Temporarily adds a new empty {@link PermissionAttachment} to this
     * object
     *
     * @param plugin Plugin responsible for this attachment, may not be null
     *               or disabled
     * @param ticks  Amount of ticks to automatically remove this attachment
     *               after
     * @return The PermissionAttachment that was just created
     */
    @Override
    public @Nullable PermissionAttachment addAttachment(@NotNull Plugin plugin, int ticks) {
        return null;
    }

    /**
     * Removes the given {@link PermissionAttachment} from this object
     *
     * @param attachment Attachment to remove
     * @throws IllegalArgumentException Thrown when the specified attachment
     *                                  isn't part of this object
     */
    @Override
    public void removeAttachment(@NotNull PermissionAttachment attachment) {

    }

    /**
     * Recalculates the permissions for this object, if the attachments have
     * changed values.
     * <p>
     * This should very rarely need to be called from a plugin.
     */
    @Override
    public void recalculatePermissions() {

    }

    /**
     * Gets a set containing all of the permissions currently in effect by
     * this object
     *
     * @return Set of currently effective permissions
     */
    @Override
    public @NotNull Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return Set.of();
    }

    /**
     * Checks if this object is a server operator
     *
     * @return true if this is an operator, otherwise false
     */
    @Override
    public boolean isOp() {
        return false;
    }

    /**
     * Sets the operator status of this object
     *
     * @param value New operator value
     */
    @Override
    public void setOp(boolean value) {

    }
}
