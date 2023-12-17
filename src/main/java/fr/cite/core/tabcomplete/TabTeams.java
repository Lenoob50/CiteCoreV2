package fr.cite.core.tabcomplete;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class TabTeams implements TabCompleter {
  public List<String> arguments = new ArrayList<>();
  
  public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
    if (this.arguments.isEmpty()) {
      this.arguments.add("Apollon");
      this.arguments.add("Arès");
      this.arguments.add("Dionysos");
      this.arguments.add("Poséidon");
      this.arguments.add("Zeus");
    } 
    List<String> result = new ArrayList<>();
    if (args.length == 1) {
      for (String a : this.arguments) {
        if (a.toLowerCase().startsWith(args[0].toLowerCase()))
          result.add(a); 
      } 
      return result;
    } 
    return null;
  }
}
