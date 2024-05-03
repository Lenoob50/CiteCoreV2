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
    if (isCustomNPC(entity)) {
      if (entity.getCustomName().equalsIgnoreCase(ChatColor.DARK_GREEN + "Banque")) {
        Inventory banque = (new InventoryManager()).Banque;
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
        Inventory mario = (new InventoryManager()).mario;
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
            Inventory block_j1 = new InventoryManager().block_j1;
            player.openInventory(block_j1);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==2){
            Inventory block_j2 = new InventoryManager().block_j2;
            player.openInventory(block_j2);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==3){
            Inventory block_j3 = new InventoryManager().block_j3;
            player.openInventory(block_j3);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==4){
            Inventory block_j4 = new InventoryManager().block_j4;
            player.openInventory(block_j4);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==5){
            Inventory block_j5 = new InventoryManager().block_j5;
            player.openInventory(block_j5);
            player.updateInventory();
          }
          player.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " L'id de l'entity est " + ChatColor.AQUA + "" + entity.getEntityId());
        } else {
          event.setCancelled(true);
          if(Main.getInstance().getConfig().getInt("options.jour")<=1){
            Inventory block_j1 = new InventoryManager().block_j1;
            player.openInventory(block_j1);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==2){
            Inventory block_j2 = new InventoryManager().block_j2;
            player.openInventory(block_j2);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==3){
            Inventory block_j3 = new InventoryManager().block_j3;
            player.openInventory(block_j3);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==4){
            Inventory block_j4 = new InventoryManager().block_j4;
            player.openInventory(block_j4);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==5){
            Inventory block_j5 = new InventoryManager().block_j5;
            player.openInventory(block_j5);
            player.updateInventory();
          }
        }

      }
      if(entity.getCustomName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Item")) {
        //Item Menu
        if (player.isOp()) {
          event.setCancelled(true);
          if(Main.getInstance().getConfig().getInt("options.jour")<=1){
            Inventory item_j1 = new InventoryManager().ItemJ1;
            player.openInventory(item_j1);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==2){
            Inventory item_j2 = new InventoryManager().ItemJ2;
            player.openInventory(item_j2);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==3){
            Inventory item_j3 = new InventoryManager().ItemJ3;
            player.openInventory(item_j3);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==4){
            Inventory item_j4 = new InventoryManager().ItemJ4;
            player.openInventory(item_j4);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==5){
            Inventory item_j5 = new InventoryManager().ItemJ5;
            player.openInventory(item_j5);
            player.updateInventory();
          }
          player.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " L'id de l'entity est " + ChatColor.AQUA + "" + entity.getEntityId());
        } else {
          event.setCancelled(true);
          if(Main.getInstance().getConfig().getInt("options.jour")<=1){
            Inventory item_j1 = new InventoryManager().ItemJ1;
            player.openInventory(item_j1);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==2){
            Inventory item_j2 = new InventoryManager().ItemJ2;
            player.openInventory(item_j2);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==3){
            Inventory item_j3 = new InventoryManager().ItemJ3;
            player.openInventory(item_j3);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==4){
            Inventory item_j4 = new InventoryManager().ItemJ4;
            player.openInventory(item_j4);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==5){
            Inventory item_j5 = new InventoryManager().ItemJ5;
            player.openInventory(item_j5);
            player.updateInventory();
          }
        }
      }
      if(entity.getCustomName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Divers")) {
        //Divers Menu
        if (player.isOp()) {
          event.setCancelled(true);
          if(Main.getInstance().getConfig().getInt("options.jour")<=1){
            Inventory divers_1 = new InventoryManager().divers_j1;
            player.openInventory(divers_1);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==2){
            Inventory divers_2 = new InventoryManager().divers_j2;
            player.openInventory(divers_2);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==3){
            Inventory divers_3 = new InventoryManager().divers_j3;
            player.openInventory(divers_3);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==4){
            Inventory divers_4 = new InventoryManager().divers_j4;
            player.openInventory(divers_4);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==5){
            Inventory divers_5 = new InventoryManager().divers_j5;
            player.openInventory(divers_5);
            player.updateInventory();
          }
          player.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " L'id de l'entity est " + ChatColor.AQUA + "" + entity.getEntityId());
        } else {
          event.setCancelled(true);
          if(Main.getInstance().getConfig().getInt("options.jour")<=1){
            Inventory divers_1 = new InventoryManager().divers_j1;
            player.openInventory(divers_1);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==2){
            Inventory divers_2 = new InventoryManager().divers_j2;
            player.openInventory(divers_2);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==3){
            Inventory divers_3 = new InventoryManager().divers_j3;
            player.openInventory(divers_3);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==4){
            Inventory divers_4 = new InventoryManager().divers_j4;
            player.openInventory(divers_4);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==5){
            Inventory divers_5 = new InventoryManager().divers_j5;
            player.openInventory(divers_5);
            player.updateInventory();
          }
        }
      }
      if(entity.getCustomName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Nourriture")) {
        if (player.isOp()) {
          event.setCancelled(true);
          if(Main.getInstance().getConfig().getInt("options.jour")<=1){
            Inventory food_j1 = new InventoryManager().food_j1;
            player.openInventory(food_j1);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==2){
            Inventory food_j2 = new InventoryManager().food_j2;
            player.openInventory(food_j2);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==3){
            Inventory food_j3 = new InventoryManager().food_j3;
            player.openInventory(food_j3);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==4){
            Inventory food_j4 = new InventoryManager().food_j4;
            player.openInventory(food_j4);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==5){
            Inventory food_j5 = new InventoryManager().food_j5;
            player.openInventory(food_j5);
            player.updateInventory();
          }
          player.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " L'id de l'entity est " + ChatColor.AQUA + "" + entity.getEntityId());
        } else {
          event.setCancelled(true);
          if(Main.getInstance().getConfig().getInt("options.jour")<=1){
            Inventory food_j1 = new InventoryManager().food_j1;
            player.openInventory(food_j1);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==2){
            Inventory food_j2 = new InventoryManager().food_j2;
            player.openInventory(food_j2);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==3){
            Inventory food_j3 = new InventoryManager().food_j3;
            player.openInventory(food_j3);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==4){
            Inventory food_j4 = new InventoryManager().food_j4;
            player.openInventory(food_j4);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==5){
            Inventory food_j5 = new InventoryManager().food_j5;
            player.openInventory(food_j5);
            player.updateInventory();
          }
        }
      }
      if(entity.getCustomName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Ressources")) {
        //Ressources Menu
        if (player.isOp()) {
          event.setCancelled(true);
          if(Main.getInstance().getConfig().getInt("options.jour")<=1){
            Inventory ressource_j1 = new InventoryManager().ressource_j1;
            player.openInventory(ressource_j1);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==2){
            Inventory ressource_j2 = new InventoryManager().ressource_j2;
            player.openInventory(ressource_j2);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==3){
            Inventory ressource_j3 = new InventoryManager().ressource_j3;
            player.openInventory(ressource_j3);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==4){
            Inventory ressource_j4 = new InventoryManager().ressource_j4;
            player.openInventory(ressource_j4);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==5){
            Inventory ressource_j5 = new InventoryManager().ressource_j5;
            player.openInventory(ressource_j5);
            player.updateInventory();
          }
          player.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " L'id de l'entity est " + ChatColor.AQUA + "" + entity.getEntityId());
        } else {
          event.setCancelled(true);
          if(Main.getInstance().getConfig().getInt("options.jour")<=1){
            Inventory ressource_j1 = new InventoryManager().ressource_j1;
            player.openInventory(ressource_j1);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==2){
            Inventory ressource_j2 = new InventoryManager().ressource_j2;
            player.openInventory(ressource_j2);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==3){
            Inventory ressource_j3 = new InventoryManager().ressource_j3;
            player.openInventory(ressource_j3);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==4){
            Inventory ressource_j4 = new InventoryManager().ressource_j4;
            player.openInventory(ressource_j4);
            player.updateInventory();
          }
          if(Main.getInstance().getConfig().getInt("options.jour")==5){
            Inventory ressource_j5 = new InventoryManager().ressource_j5;
            player.openInventory(ressource_j5);
            player.updateInventory();
          }
        }
      }
      if(entity.getCustomName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Black Market")) {
        if(player.isOp()){
          event.setCancelled(true);
          Inventory bm = new InventoryManager().Black_Market;
          player.openInventory(bm);
          player.updateInventory();
          player.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " L'id de l'entity est " + ChatColor.AQUA + "" + entity.getEntityId());
        }else {
          event.setCancelled(true);
          Inventory bm = new InventoryManager().Black_Market;
          player.openInventory(bm);
          player.updateInventory();
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
