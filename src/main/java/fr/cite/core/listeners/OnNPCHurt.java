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
    if (entity.getCustomName() != null && entity.getCustomName().equalsIgnoreCase(ChatColor.DARK_GREEN + "Banque")
            && entity.getCustomName().equalsIgnoreCase(ChatColor.DARK_GREEN + "Mario")) {
      event.setCancelled(true);
    } else {
      return;
    } 
  }
}
