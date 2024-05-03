package fr.cite.core.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class OnNPCHurt implements Listener {
  @EventHandler
  public void onNPCHurt(EntityDamageEvent event) {
    Entity entity = event.getEntity();
    if(entity.getCustomName() == null)return;
    if (entity.getCustomName() != null && entity.getCustomName().equalsIgnoreCase(ChatColor.DARK_GREEN + "Banque")
            || entity.getCustomName().equalsIgnoreCase(ChatColor.GOLD + "Mario")
            || entity.getCustomName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Block")
            || entity.getCustomName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Nourriture")
            || entity.getCustomName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Divers")
            || entity.getCustomName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Ressources")
            || entity.getCustomName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Item")
            || entity.getCustomName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Black Market")){
      event.setCancelled(true);
    } else {
      return;
    } 
  }
}
