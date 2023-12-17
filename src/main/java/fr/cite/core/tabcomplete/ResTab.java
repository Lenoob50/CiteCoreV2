package fr.cite.core.tabcomplete;

import java.util.ArrayList;
import java.util.List;


import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

public class ResTab implements TabCompleter {
  public List<String> arguments = new ArrayList<>();
  
  @Nullable
  public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
    Player player = (Player)commandSender;
    if (this.arguments.isEmpty()) {
      this.arguments.add("member-add");
      this.arguments.add("member-remove");
      if (player.isOp()) {
        this.arguments.add("add");
        this.arguments.add("remove");
      } 
    } 
    List<String> result = new ArrayList<>();
    if (strings.length == 1) {
      for (String a : this.arguments) {
        if (a.toLowerCase().startsWith(strings[0].toLowerCase()))
          result.add(a); 
      } 
      return result;
    } 
    return null;
  }
}
