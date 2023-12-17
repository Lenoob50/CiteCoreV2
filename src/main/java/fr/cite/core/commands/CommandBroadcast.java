package fr.cite.core.commands;

import fr.cite.core.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBroadcast implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player) {
      Player p = (Player)sender;
      if (args.length == 0)
        p.sendMessage(Main.getInstance().getPrefix() + "&4Veuillez prun argument"); 
      if (args.length >= 1) {
        for (Player ps : Bukkit.getOnlinePlayers())
          ps.sendTitle(ChatColor.DARK_AQUA + "Annonce de ", ChatColor.DARK_AQUA + "" + p.getName().toString()); 
        StringBuilder bc = new StringBuilder();
        for (String part : args)
          bc.append(part + " "); 
        Bukkit.broadcastMessage(ChatColor.GRAY + " ");
        Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "" + p.getName() + ">> " + ChatColor.RED + "" + bc.toString());
        Bukkit.broadcastMessage(ChatColor.GRAY + " ");
      } 
    } 
    return false;
  }
}
