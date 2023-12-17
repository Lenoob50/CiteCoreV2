package fr.cite.core.commands;

import fr.cite.core.Main;
import fr.cite.core.utils.SQLMethods;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTeams implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player) {
      Player player = (Player)sender;
      Player target = Bukkit.getPlayer(args[1]);
      if (args.length == 0) {
        player.sendMessage(Main.getInstance().getPrefix() + " Il vous faut au moins un argument");
      } else {
        if (args[0].equalsIgnoreCase("Arès")) {
          SQLMethods.addToTeam(args[0].replace("Arès", "Ares"), target);
        } else if (args[0].equalsIgnoreCase("Poséidon")) {
          SQLMethods.addToTeam(args[0].replace("Poséidon", "Poseidon"), target);
        } else {
          SQLMethods.addToTeam(args[0], target);
        } 
        if ((Main.getInstance()).Apolon.getEntries().contains(target.getDisplayName())) {
          SQLMethods.removeToTeam("Apollon", target);
        }
        if ((Main.getInstance()).Ares.getEntries().contains(target.getDisplayName())) {
          SQLMethods.removeToTeam("Ares", target);
        }
        if ((Main.getInstance()).Dionysos.getEntries().contains(target.getDisplayName())) {
          SQLMethods.removeToTeam("Dionysos", target);
        }
        if ((Main.getInstance()).Poseidon.getEntries().contains(target.getDisplayName())) {
          SQLMethods.removeToTeam("Poseidon", target);
        }
        if ((Main.getInstance()).Zeus.getEntries().contains(target.getDisplayName())){
          SQLMethods.removeToTeam("Zeus", target);
        }
        if (args[0].equalsIgnoreCase("Apollon")) {
          (Main.getInstance()).Apolon.addEntry(target.getDisplayName());
          System.out.println((Main.getInstance()).scoreboard);
          System.out.println(args[1]);
          System.out.println((Main.getInstance()).Apolon.getEntries());
          player.sendMessage(Main.getInstance().getPrefix() + "" + target.getName() + " ajouté à la team " + (Main.getInstance()).scoreboard.getPlayerTeam((OfflinePlayer)target).getName());
          SQLMethods.setTeams(target);
        } 
        if (args[0].equalsIgnoreCase("Arès")) {
          (Main.getInstance()).Ares.addEntry(target.getDisplayName());
          player.sendMessage(Main.getInstance().getPrefix() + "" + target.getName() + " ajouté à la team " + (Main.getInstance()).scoreboard.getEntryTeam(target.getName()).getName());
          SQLMethods.setTeams(target);
        } 
        if (args[0].equalsIgnoreCase("Dionysos")) {
          (Main.getInstance()).Dionysos.addEntry(target.getDisplayName());
          player.sendMessage(Main.getInstance().getPrefix() + "" + target.getName() + " ajouté à la team " + (Main.getInstance()).scoreboard.getEntryTeam(target.getName()).getName());
          SQLMethods.setTeams(target);
        } 
        if (args[0].equalsIgnoreCase("Poséidon")) {
          (Main.getInstance()).Poseidon.addEntry(target.getDisplayName());
          player.sendMessage(Main.getInstance().getPrefix() + "" + target.getName() + " ajouté à la team " + (Main.getInstance()).scoreboard.getEntryTeam(target.getName()).getName());
          SQLMethods.setTeams(target);
        } 
        if (args[0].equalsIgnoreCase("Zeus")) {
          (Main.getInstance()).Zeus.addEntry(target.getDisplayName());
          player.sendMessage(Main.getInstance().getPrefix() + "" + target.getName() + " ajouté à la team " + (Main.getInstance()).scoreboard.getEntryTeam(target.getName()).getName());
          SQLMethods.setTeams(target);
        } 
      } 
    } 
    return false;
  }
}
