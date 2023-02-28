package fr.cite.core.tabcomplete;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TabNpc implements TabCompleter {
    public List<String> arguments = new ArrayList<String>();

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if(arguments.isEmpty()) {
            arguments.add("Banque");
            arguments.add("Blocks");
            arguments.add("Food");
            arguments.add("Divers");
            arguments.add("Ressources");
            arguments.add("Item");
            arguments.add("info");
            arguments.add("remove");
        }

        List<String> result = new ArrayList<String>();
        if(args.length == 1) {
            for(String a : arguments) {
                if(a.toLowerCase().startsWith(args[0].toLowerCase())) {
                    result.add(a);
                }
            }
            return result;
        }
        return null;
    }
}
