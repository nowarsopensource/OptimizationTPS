package dev.dicktalk.nowarssmp.optimizationtps.impl;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class FireballBomb implements Listener {


    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_AIR || event.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK) {
            if (player.getInventory().getItemInMainHand().getType() == Material.FIRE_CHARGE) {
                event.setCancelled(true);
                fireballLaunch(player);
            }
        }
    }

    private void fireballLaunch(Player player) {
        Location loc = player.getEyeLocation();
        Fireball fireball = player.launchProjectile(SmallFireball.class);
        fireball.setVelocity(loc.getDirection().multiply(1.5));
        loc.getWorld().createExplosion(loc, 2.0F, false, false);
    }
}