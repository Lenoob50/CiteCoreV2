package fr.cite.core.commands;

import fr.cite.core.Main;
import fr.cite.core.utils.SQLMethods;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTeamMoney implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player) {
      Player player = (Player)sender;
      if (args.length == 0) {
        int coins = SQLMethods.getMoney(player);
        player.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " Votre compte contient " + coins + " Drachmes");
      } 
      if (args.length >= 1) {
        if (args[1].equalsIgnoreCase("get")) {
          int coins = SQLMethods.getTeamMoneyByName(args[0]);
          player.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " Le compte de " + args[0] + " contient " + coins + " Drachmes");
        } 
        if (args[1].equalsIgnoreCase("add")) {
          SQLMethods.addTeamMoney(args[0], Integer.parseInt(args[2]));
          int coins = SQLMethods.getTeamMoneyByName(args[0]);
          player.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " Le compte de " + args[0] + " contient " + coins + " Drachmes");
        } 
        if (args[1].equalsIgnoreCase("remove")) {
          int to_rem = Integer.parseInt(args[2]);
          SQLMethods.addTeamMoney(args[0], -to_rem);
          int coins = SQLMethods.getTeamMoneyByName(args[0]);
          player.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " Le compte de " + args[0] + " contient " + coins + " Drachmes");
        } 
      } 
    } 
    return false;
  }
}
