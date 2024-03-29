package fr.cite.core.tabcomplete;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TabTeams implements TabCompleter {
    public List<String> arguments = new ArrayList<String>();

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if(arguments.isEmpty()) {
            arguments.add("Apollon");
            arguments.add("Arès");
            arguments.add("Dionysos");
            arguments.add("Poséidon");
            arguments.add("Zeus");
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
