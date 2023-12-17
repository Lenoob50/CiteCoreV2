package fr.cite.core.commands;

import fr.cite.core.Main;
import fr.cite.core.utils.SQLMethods;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandLeader implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player) {
      Player player = (Player)sender;
      player.sendMessage(Main.getInstance().getPrefix() + SQLMethods.sortByValue(SQLMethods.doTeamClassement()));
    } 
    return false;
  }
}
