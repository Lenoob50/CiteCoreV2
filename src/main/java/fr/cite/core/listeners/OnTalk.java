package fr.cite.core.listeners;

import fr.cite.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class OnTalk implements Listener {
  @EventHandler
  public void onTalk(AsyncPlayerChatEvent event) {
    Player player = event.getPlayer();
    String newmsg = event.getMessage().substring(1);
    event.setCancelled(true);
    if ((Main.getInstance()).Apolon.getEntries().contains(player.getDisplayName())) {
      if (!event.getMessage().startsWith("!")) {
        for (String pt : (Main.getInstance()).Apolon.getEntries()) {
          Player pr = Bukkit.getPlayer(pt);
          pr.sendMessage(ChatColor.WHITE + "[" + ChatColor.YELLOW + "Team" + ChatColor.RESET + "] " + ChatColor.GREEN + "" + player.getName() + ChatColor.GOLD + " >> " + ChatColor.RESET + "" + event
              .getMessage());
        } 
      } else {
        for (Player op : Bukkit.getOnlinePlayers()) {
          op.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "Global" + ChatColor.RESET + "] " + ChatColor.GREEN + "" + (Main.getInstance()).Apolon.getPrefix() + ChatColor.RESET + "" + player
                  .getDisplayName() + ChatColor.GOLD + " >> " + ChatColor.RESET + "" + newmsg);
        }
      } 
    } else if ((Main.getInstance()).Ares.getEntries().contains(player.getDisplayName())) {
      if (!event.getMessage().startsWith("!")) {
        for (String pt : (Main.getInstance()).Ares.getEntries()) {
          Player pr = Bukkit.getPlayer(pt);
          pr.sendMessage(ChatColor.WHITE + "[" + ChatColor.YELLOW + "Team" + ChatColor.RESET + "] " + ChatColor.RED + "" + player.getName() + ChatColor.GOLD + " >> " + ChatColor.RESET + "" + event
              .getMessage());
        } 
      } else {
        for (Player op : Bukkit.getOnlinePlayers()) {
          op.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "Global" + ChatColor.RESET + "] " + ChatColor.RED + "" + (Main.getInstance()).Ares.getPrefix() + ChatColor.RESET + "" + player
                  .getDisplayName() + ChatColor.GOLD + " >> " + ChatColor.RESET + "" + newmsg);
        }
      } 
    } else if ((Main.getInstance()).Dionysos.getEntries().contains(player.getDisplayName())) {
      if (!event.getMessage().startsWith("!")) {
        for (String pt : (Main.getInstance()).Dionysos.getEntries()) {
          Player pr = Bukkit.getPlayer(pt);
          pr.sendMessage(ChatColor.WHITE + "[" + ChatColor.YELLOW + "Team" + ChatColor.RESET + "] " + ChatColor.DARK_PURPLE + "" + player.getName() + ChatColor.GOLD + " >> " + ChatColor.RESET + "" + event
              .getMessage());
        } 
      } else {
        for (Player op : Bukkit.getOnlinePlayers()) {
          op.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "Global" + ChatColor.RESET + "] " + ChatColor.DARK_PURPLE + "" + (Main.getInstance()).Dionysos.getPrefix() + ChatColor.RESET + "" + player
                  .getDisplayName() + ChatColor.GOLD + " >> " + ChatColor.RESET + "" + newmsg);
        }
      } 
    } else if ((Main.getInstance()).Poseidon.getEntries().contains(player.getDisplayName())) {
      if (!event.getMessage().startsWith("!")) {
        for (String pt : (Main.getInstance()).Poseidon.getEntries()) {
          Player pr = Bukkit.getPlayer(pt);
          pr.sendMessage(ChatColor.WHITE + "[" + ChatColor.YELLOW + "Team" + ChatColor.RESET + "] " + ChatColor.AQUA + "" + player.getName() + ChatColor.GOLD + " >> " + ChatColor.RESET + "" + event
              .getMessage());
        } 
      } else {
        for (Player op : Bukkit.getOnlinePlayers()) {
          op.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "Global" + ChatColor.RESET + "] " + ChatColor.AQUA + "" + (Main.getInstance()).Poseidon.getPrefix() + ChatColor.RESET + "" + player
                  .getDisplayName() + ChatColor.GOLD + " >> " + ChatColor.RESET + "" + newmsg);
        }
      } 
    } else if ((Main.getInstance()).Zeus.getEntries().contains(player.getDisplayName())) {
      if (!event.getMessage().startsWith("!")) {
        for (String pt : (Main.getInstance()).Zeus.getEntries()) {
          Player pr = Bukkit.getPlayer(pt);
          pr.sendMessage(ChatColor.WHITE + "[" + ChatColor.YELLOW + "Team" + ChatColor.RESET + "] " + ChatColor.GOLD + "" + player.getName() + ChatColor.GOLD + " >> " + ChatColor.RESET + "" + event
              .getMessage());
        } 
      } else {
        for (Player op : Bukkit.getOnlinePlayers()) {
          op.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "Global" + ChatColor.RESET + "] " + ChatColor.GOLD + "" + (Main.getInstance()).Zeus.getPrefix() + ChatColor.RESET + "" + player
                  .getDisplayName() + ChatColor.GOLD + " >> " + ChatColor.RESET + "" + newmsg);
        }
      } 
    } else if (player.isOp()) {
      for (Player op : Bukkit.getOnlinePlayers()) {
        op.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "Global" + ChatColor.RESET + "] " + ChatColor.DARK_RED + "Admin " + player.getName() + ChatColor.GOLD + " >> " + ChatColor.RESET + "" + event
                .getMessage());
      }
    } else {
      for (Player op : Bukkit.getOnlinePlayers()) {
        op.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "Global" + ChatColor.RESET + "] " + player.getName() + ChatColor.GOLD + " >> " + ChatColor.RESET + "" + event
                .getMessage());
      }
    } 
  }
}
