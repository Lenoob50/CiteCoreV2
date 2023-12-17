package fr.cite.core.listeners;

import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class OnLBBreak implements Listener {
    @EventHandler
    public void onLBBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        BlockState bs = block.getState();
        Random r = new Random();
        int alea = r.nextInt(9);
        if (bs instanceof Skull) {
            Skull skull = (Skull)bs;
            if (skull.getOwner().equalsIgnoreCase("Luck")) {
                event.setCancelled(true);
                block.setType(Material.AIR);
                switch (alea) {
                    case 0:
                        player.sendMessage("§cKABOM");
                                block.getWorld().createExplosion(block.getLocation(), 4.0F);
                        return;
                    case 1:case 2:
                        player.sendMessage("Ruée vers l'or");
                        block.getWorld().dropItem(block.getLocation(), new ItemStack(Material.GOLD_INGOT, 5));
                        return;
                    case 3:case 4:
                        player.sendMessage("Sonic");
                                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 5, true, false));
                        return;
                    case 5:
                        player.sendMessage("Au petit bonheur la chance");
                        return;
                    case 6:case 7:
                        player.sendMessage("Aubout du bout");
                        if (player.getInventory().getItem(alea) != null) {
                            player.getInventory().clear(alea);
                        } else {
                            player.sendMessage("La prochaine fois peut-être");
                        }
                        return;
                    case 8:
                        player.sendMessage("Au bord du gouffre");
                        player.teleport(new Location(player.getWorld(), player.getLocation().getX(), 255.0D, player.getLocation().getZ()));
                        player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.WATER_BUCKET) });
                        return;
                    case 9:
                        player.sendMessage("Pas de bol");
                        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 10, 10, true, true));
                        return;
                    default:
                        player.sendMessage("On tient le bon bout");
                        block.getWorld().dropItem(block.getLocation(), new ItemStack(Material.EMERALD, 5));
                }

            }
        }
    }
}
