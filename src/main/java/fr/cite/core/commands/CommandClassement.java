package fr.cite.core.commands;

import eu.decentsoftware.holograms.api.DHAPI;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import fr.cite.core.Main;
import fr.cite.core.utils.SQLMethods;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandClassement implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player) {
      Player player = (Player)sender;
      Location location = player.getLocation();
      int x = location.getBlockX();
      int y = location.getBlockY() + 3;
      int z = location.getBlockZ();
      if (args.length == 0) {
        player.sendMessage(Main.getInstance().getPrefix() + "Vous devez prun argument");
      } else if (args.length >= 1) {
        if (args[0].equalsIgnoreCase("remove")) {
          Hologram hologram = DHAPI.getHologram(args[1]);
          DHAPI.removeHologram(hologram.getName());
        } 
        if (args[0].equalsIgnoreCase("move")) {
          Hologram hologram = DHAPI.getHologram(args[1]);
          DHAPI.moveHologram(hologram, new Location(location.getWorld(), x, y, z));
        } 
        if (args[0].equalsIgnoreCase("team")) {
          ArrayList<String> lines = new ArrayList<>();
          HashMap<String, Integer> classment = SQLMethods.sortByValue(SQLMethods.doTeamClassement());
          lines.add(ChatColor.GREEN + "Classement des équipes" );
          for (Map.Entry<String, Integer> mapentry : classment.entrySet()) {
            lines.add(ChatColor.AQUA + "" + (String) mapentry.getKey() + " : " + mapentry.getValue() + "\n");
          }
          Hologram hologram = DHAPI.createHologram("Teams", new Location(location.getWorld(), x, y, z), true, lines);
        } 
        if (args[0].equalsIgnoreCase("players")) {
          ArrayList<String> lines = new ArrayList<>();
          HashMap<String, Integer> classment = SQLMethods.sortByValue(SQLMethods.doPlayerClassement());
          lines.add(ChatColor.GREEN + "Classement des joueurs");
          for (Map.Entry<String, Integer> mapentry : classment.entrySet()) {
            lines.add(ChatColor.AQUA + "" + (String) mapentry.getKey() + " : " + mapentry.getValue() + "\n");
          }
          Hologram hologram = DHAPI.createHologram("Players", new Location(location.getWorld(), x, y, z), true, lines);
        } 
        if (args[0].equalsIgnoreCase("Apollon")) {
          ArrayList<String> lines = new ArrayList<>();
          HashMap<String, Integer> classement = SQLMethods.sortByValue(SQLMethods.teamLeader("Apollon"));
          lines.add(ChatColor.GREEN + "Apollon");
          for (Map.Entry<String, Integer> mapentry : classement.entrySet()) {
            lines.add(ChatColor.AQUA + "" + (String) mapentry.getKey() + " : " + mapentry.getValue() + "\n");
          }
          Hologram hologram = DHAPI.createHologram("Apollon", new Location(location.getWorld(), x, y, z), true, lines);
        } 
        if (args[0].equalsIgnoreCase("Ares")) {
          ArrayList<String> lines = new ArrayList<>();
          HashMap<String, Integer> classement = SQLMethods.sortByValue(SQLMethods.teamLeader("Ares"));
          lines.add(ChatColor.RED + "Arès");
          for (Map.Entry<String, Integer> mapentry : classement.entrySet()) {
            lines.add(ChatColor.AQUA + "" + (String) mapentry.getKey() + " : " + mapentry.getValue() + "\n");
          }
          Hologram hologram = DHAPI.createHologram("Ares", new Location(location.getWorld(), x, y, z), true, lines);
        } 
        if (args[0].equalsIgnoreCase("Dionysos")) {
          ArrayList<String> lines = new ArrayList<>();
          HashMap<String, Integer> classement = SQLMethods.sortByValue(SQLMethods.teamLeader("Dionysos"));
          lines.add(ChatColor.DARK_PURPLE + "Dionysos");
          for (Map.Entry<String, Integer> mapentry : classement.entrySet()) {
            lines.add(ChatColor.AQUA + "" + (String) mapentry.getKey() + " : " + mapentry.getValue() + "\n");
          }
          Hologram hologram = DHAPI.createHologram("Dionysos", new Location(location.getWorld(), x, y, z), true, lines);
        } 
        if (args[0].equalsIgnoreCase("Poseidon")) {
          ArrayList<String> lines = new ArrayList<>();
          HashMap<String, Integer> classement = SQLMethods.sortByValue(SQLMethods.teamLeader("Poseidon"));
          lines.add(ChatColor.AQUA + "Poséidon");
          for (Map.Entry<String, Integer> mapentry : classement.entrySet()) {
            lines.add(ChatColor.AQUA + "" + (String) mapentry.getKey() + " : " + mapentry.getValue() + "\n");
          }
          Hologram hologram = DHAPI.createHologram("Poseidon", new Location(location.getWorld(), x, y, z), true, lines);
        } 
        if (args[0].equalsIgnoreCase("Zeus")) {
          ArrayList<String> lines = new ArrayList<>();
          HashMap<String, Integer> classement = SQLMethods.sortByValue(SQLMethods.teamLeader("Zeus"));
          lines.add(ChatColor.GOLD + "Zeus");
          for (Map.Entry<String, Integer> mapentry : classement.entrySet()) {
            lines.add(ChatColor.AQUA + "" + (String) mapentry.getKey() + " : " + mapentry.getValue() + "\n");
          }
          Hologram hologram = DHAPI.createHologram("Zeus", new Location(location.getWorld(), x, y, z), true, lines);
        } 
      } 
    } 
    return false;
  }
}
