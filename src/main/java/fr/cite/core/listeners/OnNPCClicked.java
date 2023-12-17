package fr.cite.core.listeners;

import fr.cite.core.Main;
import fr.cite.core.inventory.InventoryManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;

public class OnNPCClicked implements Listener {
  @EventHandler
  public void onNPCClicked(PlayerInteractEntityEvent event) {
    Player player = event.getPlayer();
    Entity entity = event.getRightClicked();
    Inventory banque = (new InventoryManager()).Banque;
    Inventory mario = (new InventoryManager()).mario;
    Inventory block_j1 = new InventoryManager().block_j1;
    if (isCustomNPC(entity)) {
      if (entity.getCustomName().equalsIgnoreCase(ChatColor.DARK_GREEN + "Banque")) {
        if (player.isOp()) {
          event.setCancelled(true);
          player.openInventory(banque);
          player.updateInventory();
          player.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " L'id de l'entity est " + ChatColor.AQUA + "" + entity.getEntityId());
        } else {
          event.setCancelled(true);
          player.openInventory(banque);
          player.updateInventory();
        }
      }
      if (entity.getCustomName().equalsIgnoreCase(ChatColor.GOLD + "Mario")) {
        if (player.isOp()) {
          event.setCancelled(true);
          player.openInventory(mario);
          player.updateInventory();
          player.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " L'id de l'entity est " + ChatColor.AQUA + "" + entity.getEntityId());
        } else {
          event.setCancelled(true);
          player.openInventory(mario);
          player.updateInventory();
        }
      }
      if(entity.getCustomName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Block")){
        if (player.isOp()) {
          event.setCancelled(true);
          if(Main.getInstance().getConfig().getInt("options.jour")<=1){
            player.openInventory(block_j1);
            player.updateInventory();
          }
          player.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " L'id de l'entity est " + ChatColor.AQUA + "" + entity.getEntityId());
        } else {
          event.setCancelled(true);

        }
      }
    }

  }
  
  private boolean isCustomNPC(Entity entity) {
    if (entity instanceof Villager) {
      Villager npc = (Villager)entity;
      if (npc.isCustomNameVisible() && npc.getCustomName() != null)
        return true; 
    } 
    return false;
  }
}
