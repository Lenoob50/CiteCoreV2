package fr.cite.core.tabcomplete;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class TabNpc implements TabCompleter {
  public List<String> arguments = new ArrayList<>();
  
  public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
    if (this.arguments.isEmpty()) {
      this.arguments.add("Banque");
      this.arguments.add("Blocks");
      this.arguments.add("Food");
      this.arguments.add("Divers");
      this.arguments.add("Ressources");
      this.arguments.add("Item");
      this.arguments.add("info");
      this.arguments.add("remove");
      this.arguments.add("Mario");
      this.arguments.add("BM");
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
