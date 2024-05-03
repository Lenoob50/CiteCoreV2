package fr.cite.core.listeners;

import fr.cite.core.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Map;

public class OnLbUse implements Listener {

    @EventHandler
    public void onLBUse(InventoryClickEvent event){
        Player p = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        int ems = 0;
        int gold = 0;
        if (clickedItem == null) {
            return;
        }
        if (p.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.GOLD + "Here we go")) {
            event.setCancelled(true);
            if (clickedItem.getType().equals(Material.PLAYER_HEAD) &&
                    clickedItem.getItemMeta().getDisplayName().equalsIgnoreCase("1xLucky blocks")) {
                for (Map.Entry<Integer, ? extends ItemStack> mapentry : p.getInventory().all(Material.GOLD_BLOCK).entrySet()) {
                    gold += mapentry.getValue().getAmount();
                    if (gold >= 8) {
                        int reste = gold % 8;
                        p.getInventory().remove(Material.GOLD_INGOT);
                        p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, reste));
                        ItemStack lb = new ItemStack(Material.PLAYER_HEAD, gold / 8);
                        SkullMeta meta = (SkullMeta) lb.getItemMeta();
                        meta.setOwner("luck");
                        meta.setDisplayName("blocks");
                        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        lb.setItemMeta(meta);
                        p.getInventory().addItem(lb);
                    } else {
                        p.sendMessage(Main.getInstance().getPrefix() + "Tu n'as pas assez d'or pour acheter ceci");
                    }
                }
            }
        }
    }

}
