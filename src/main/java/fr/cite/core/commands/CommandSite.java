package fr.cite.core.commands;

import fr.cite.core.Main;
import fr.cite.core.utils.SQLMethods;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSite implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player) {
      Player player = (Player)sender;

      player.sendMessage(" ");
      player.sendMessage(Main.getInstance().getPrefix() + "L'URL du site est : " + ChatColor.GOLD + "" + Main.getInstance().getConfig().getString("options.site.url"));
      player.sendMessage(" ");
      player.sendMessage(" ");
    } 
    return false;
  }
}
