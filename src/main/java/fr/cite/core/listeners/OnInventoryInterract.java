package fr.cite.core.listeners;

import fr.cite.core.Main;
import fr.cite.core.utils.SQLMethods;

import java.util.Arrays;
import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
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

    if(p.getOpenInventory().getTitle().equals(ChatColor.AQUA + "Choix des Teams")){
      event.setCancelled(true);
      if(clickedItem.getType().equals(Material.LIME_WOOL) && clickedItem.getItemMeta().hasDisplayName()){
        (Main.getInstance()).Apolon.addEntry(p.getDisplayName());
        p.sendMessage(Main.getInstance().getPrefix() + "" + p.getName() + " ajouté à la team " + (Main.getInstance()).scoreboard.getPlayerTeam((OfflinePlayer)p).getName());
        SQLMethods.setTeams(p);
        p.closeInventory();
      } else if (clickedItem.getType().equals(Material.RED_WOOL) && clickedItem.getItemMeta().hasDisplayName()) {
        (Main.getInstance()).Ares.addEntry(p.getDisplayName());
        p.sendMessage(Main.getInstance().getPrefix() + "" + p.getName() + " ajouté à la team " + (Main.getInstance()).scoreboard.getEntryTeam(p.getName()).getName());
        SQLMethods.setTeams(p);
        p.closeInventory();
      } else if (clickedItem.getType().equals(Material.CYAN_WOOL)&& clickedItem.getItemMeta().hasDisplayName()) {
        (Main.getInstance()).Poseidon.addEntry(p.getDisplayName());
        p.sendMessage(Main.getInstance().getPrefix() + "" + p.getName() + " ajouté à la team " + (Main.getInstance()).scoreboard.getEntryTeam(p.getName()).getName());
        SQLMethods.setTeams(p);
        p.closeInventory();

      } else if (clickedItem.getType().equals(Material.YELLOW_WOOL)&&clickedItem.getItemMeta().hasDisplayName()) {
        (Main.getInstance()).Zeus.addEntry(p.getDisplayName());
        p.sendMessage(Main.getInstance().getPrefix() + "" + p.getName() + " ajouté à la team " + (Main.getInstance()).scoreboard.getEntryTeam(p.getName()).getName());
        SQLMethods.setTeams(p);
        p.closeInventory();

      } else if (clickedItem.getType().equals(Material.PURPLE_WOOL)&&clickedItem.getItemMeta().hasDisplayName()) {
        (Main.getInstance()).Dionysos.addEntry(p.getDisplayName());
        p.sendMessage(Main.getInstance().getPrefix() + "" + p.getName() + " ajouté à la team " + (Main.getInstance()).scoreboard.getEntryTeam(p.getName()).getName());
        SQLMethods.setTeams(p);
        p.closeInventory();
      } else if (clickedItem.getType() == null) {
        return;
      }
    }
    if (p.getOpenInventory().getTitle().equals("inventory")) {
      event.setCancelled(true);
      Material[] materials = {Material.ENCHANTED_GOLDEN_APPLE, Material.COOKED_BEEF, Material.EXPERIENCE_BOTTLE, Material.GRAY_STAINED_GLASS_PANE};
      if (clickedItem != null) {
        if (Arrays.asList(materials).contains(clickedItem.getType())) {
          event.setCancelled(true);
        }
      }
    }
    if (p.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.AQUA + "Banque")) {
      event.setCancelled(true);
      if (clickedItem.getType().equals(Material.EMERALD)) {
        if (clickedItem.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Déposer des Emeraudes") &&
                p.getInventory().contains(Material.EMERALD)) {
          for (Map.Entry<Integer, ? extends ItemStack> mapentry : p.getInventory().all(Material.EMERALD).entrySet()) {
            ems += mapentry.getValue().getAmount();
          }
          SQLMethods.addCoins(p, ems);
          p.sendMessage(Main.getInstance().getPrefix() + "Votre compte à été crédité de " + ChatColor.AQUA + ems + ChatColor.RESET + " drachmes");
          p.getInventory().remove(Material.EMERALD);
          SQLMethods.addTeamCoins(ems, p);


        } else if (clickedItem.getType().equals(Material.EMERALD_BLOCK) &&
                clickedItem.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Déposer des blocks d'emeraude") &&
                p.getInventory().contains(Material.EMERALD_BLOCK)) {
          for (Map.Entry<Integer, ? extends ItemStack> mapentry : p.getInventory().all(Material.EMERALD_BLOCK).entrySet()) {
            ems += mapentry.getValue().getAmount();
          }

          p.sendMessage(Main.getInstance().getPrefix() + "Votre compte à été crédité de " + ChatColor.AQUA + (ems * 9) + ChatColor.RESET + " drachmes");
          SQLMethods.addCoins(p, ems * 9);
          p.getInventory().remove(Material.EMERALD_BLOCK);
          SQLMethods.addTeamCoins(ems * 9, p);


        } else if (clickedItem.getType() == null) {
          return;
        }
      }
    }
  }
}