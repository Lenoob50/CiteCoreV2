package fr.cite.core.commands;

import fr.cite.core.Main;
import fr.cite.core.utils.SQLMethods;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMoney implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player) {
      Player player = (Player)sender;
      if (args.length == 0) {
        int coins = SQLMethods.getMoney(player);
        player.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " Votre compte contient " + coins + " Drachmes");
      } 
      if (args.length >= 1) {
        if (args[0].equalsIgnoreCase("get")) {
          Player target = Bukkit.getPlayer(args[1]);
          int coins = SQLMethods.getMoney(target);
          player.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " Le compte de " + target.getName() + " contient " + coins + " Drachmes");
        } 
        if (args[0].equalsIgnoreCase("add")) {
          Player target = Bukkit.getPlayer(args[1]);
          SQLMethods.addCoins(target, Integer.parseInt(args[2]));
          int coins = SQLMethods.getMoney(target);
          player.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " Le compte de " + target.getName() + " contient " + coins + " Drachmes");
          if ((Main.getInstance()).scoreboard.getEntryTeam(target.getDisplayName()).getName().equalsIgnoreCase("Arès")) {
            SQLMethods.addCoinsPerTeam((Main.getInstance()).scoreboard.getEntryTeam(target.getDisplayName()).getName().replace("Arès", "Ares"), target);
          } else if ((Main.getInstance()).scoreboard.getEntryTeam(target.getDisplayName()).getName().equalsIgnoreCase("Poséidon")) {
            SQLMethods.addCoinsPerTeam((Main.getInstance()).scoreboard.getEntryTeam(target.getDisplayName()).getName().replace("Poséidon", "Poseidon"), target);
          } else {
            SQLMethods.addCoinsPerTeam((Main.getInstance()).scoreboard.getEntryTeam(target.getDisplayName()).getName(), target);
          } 
          SQLMethods.addTeamCoins(Integer.parseInt(args[2]), target);
        } 
        if (args[0].equalsIgnoreCase("remove")) {
          Player target = Bukkit.getPlayer(args[1]);
          int to_rem = Integer.parseInt(args[2]);
          SQLMethods.addCoins(target, -to_rem);
          int coins = SQLMethods.getMoney(target);
          player.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " Le compte de " + target.getName() + " contient " + coins + " Drachmes");
          if ((Main.getInstance()).scoreboard.getEntryTeam(target.getDisplayName()).getName().equalsIgnoreCase("Arès")) {
            SQLMethods.addCoinsPerTeam((Main.getInstance()).scoreboard.getEntryTeam(target.getDisplayName()).getName().replace("Arès", "Ares"), target);
          } else if ((Main.getInstance()).scoreboard.getEntryTeam(target.getDisplayName()).getName().equalsIgnoreCase("Poséidon")) {
            SQLMethods.addCoinsPerTeam((Main.getInstance()).scoreboard.getEntryTeam(target.getDisplayName()).getName().replace("Poséidon", "Poseidon"), target);
          } else {
            SQLMethods.addCoinsPerTeam((Main.getInstance()).scoreboard.getEntryTeam(target.getDisplayName()).getName(), target);
          } 
          SQLMethods.addTeamCoins(-to_rem, target);
        } 
      } 
    } 
    return false;
  }
}
