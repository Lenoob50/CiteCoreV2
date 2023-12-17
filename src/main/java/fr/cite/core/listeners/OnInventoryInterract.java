package fr.cite.core.listeners;

import fr.cite.core.Main;
import fr.cite.core.utils.SQLMethods;
import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class OnInventoryInterract implements Listener {
  @EventHandler
  public void onInvInterract(InventoryClickEvent event) {
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
      if (p.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Banque")) {
        event.setCancelled(true);
        if (clickedItem.getType().equals(Material.EMERALD)) {
          if (clickedItem.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Ddes Emeraudes") &&
                  p.getInventory().contains(Material.EMERALD)) {
            for (Map.Entry<Integer, ? extends ItemStack> mapentry : p.getInventory().all(Material.EMERALD).entrySet()) {
              ems += mapentry.getValue().getAmount();
              SQLMethods.addCoins(p, ems);
              p.sendMessage(Main.getInstance().getPrefix() + "Votre compte crde " + ChatColor.AQUA + ems + ChatColor.RESET + " drachmes");
              p.getInventory().remove(Material.EMERALD);
              SQLMethods.addTeamCoins(ems, p);
              if ((Main.getInstance()).scoreboard.getEntryTeam(p.getDisplayName()).getName().equalsIgnoreCase("Arès")) {
                SQLMethods.addCoinsPerTeam((Main.getInstance()).scoreboard.getEntryTeam(p.getDisplayName()).getName().replace("Arès", "Ares"), p);
              }
              if ((Main.getInstance()).scoreboard.getEntryTeam(p.getDisplayName()).getName().equalsIgnoreCase("Poséidon")) {
                SQLMethods.addCoinsPerTeam((Main.getInstance()).scoreboard.getEntryTeam(p.getDisplayName()).getName().replace("Poséidon", "Poseidon"), p);
              } else {
                SQLMethods.addCoinsPerTeam((Main.getInstance()).scoreboard.getEntryTeam(p.getDisplayName()).getName(), p);
              }
            }
          } else if (clickedItem.getType().equals(Material.EMERALD_BLOCK) &&
                  clickedItem.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Ddes blocks d'emeraude") &&
                  p.getInventory().contains(Material.EMERALD_BLOCK)) {
            for (Map.Entry<Integer, ? extends ItemStack> mapentry : p.getInventory().all(Material.EMERALD_BLOCK).entrySet()) {
              ems += mapentry.getValue().getAmount();
              p.sendMessage(Main.getInstance().getPrefix() + "Votre compte crde " + ChatColor.AQUA + (ems * 9) + ChatColor.RESET + " drachmes");
              SQLMethods.addCoins(p, ems * 9);
              p.getInventory().remove(Material.EMERALD_BLOCK);
              SQLMethods.addTeamCoins(ems * 9, p);
              if ((Main.getInstance()).scoreboard.getEntryTeam(p.getDisplayName()).getName().equalsIgnoreCase("Arès")) {
                SQLMethods.addCoinsPerTeam((Main.getInstance()).scoreboard.getEntryTeam(p.getDisplayName()).getName().replace("Arès", "Ares"), p);
              }
              if ((Main.getInstance()).scoreboard.getEntryTeam(p.getDisplayName()).getName().equalsIgnoreCase("Poséidon")) {
                SQLMethods.addCoinsPerTeam((Main.getInstance()).scoreboard.getEntryTeam(p.getDisplayName()).getName().replace("Poséidon", "Poseidon"), p);
              } else {
                SQLMethods.addCoinsPerTeam((Main.getInstance()).scoreboard.getEntryTeam(p.getDisplayName()).getName(), p);
              }
            }
          } else if (clickedItem.getType() == null) {
            return;
          }
        }
      }
    }
  }
}