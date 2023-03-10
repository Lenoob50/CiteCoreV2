package fr.cite.core.commands;

import fr.cite.core.Main;
import fr.cite.core.utils.SQLMethods;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTeams implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            Player target = Bukkit.getPlayer(args[1]);
            if(args.length == 0){
                player.sendMessage(Main.getInstance().getPrefix()+" Il vous faut au moins un argument");
            }else{
                if(args[0].equalsIgnoreCase("Apollon")){
                    Main.getInstance().Apolon.addEntry(target.getDisplayName());
                    player.sendMessage(Main.getInstance().getPrefix()+""+target.getName()+" ? ?t? ajout? ? la team "+Main.getInstance().scoreboard.getEntryTeam(target.getName()).getName());
                    SQLMethods.setTeams(target);
                }
                if(args[0].equalsIgnoreCase("Ar?s")){
                    Main.getInstance().Ares.addEntry(target.getDisplayName());
                    player.sendMessage(Main.getInstance().getPrefix()+""+target.getName()+" ? ?t? ajout? ? la team "+Main.getInstance().scoreboard.getEntryTeam(target.getName()).getName());
                    SQLMethods.setTeams(target);
                }
                if(args[0].equalsIgnoreCase("Dionysos")){
                    Main.getInstance().Dionysos.addEntry(target.getDisplayName());
                    player.sendMessage(Main.getInstance().getPrefix()+""+target.getName()+" ? ?t? ajout? ? la team "+Main.getInstance().scoreboard.getEntryTeam(target.getName()).getName());
                    SQLMethods.setTeams(target);
                }
                if(args[0].equalsIgnoreCase("Pos?idon")){
                    Main.getInstance().Poseidon.addEntry(target.getDisplayName());
                    player.sendMessage(Main.getInstance().getPrefix()+""+target.getName()+" ? ?t? ajout? ? la team "+Main.getInstance().scoreboard.getEntryTeam(target.getName()).getName());
                    SQLMethods.setTeams(target);
                }
                if(args[0].equalsIgnoreCase("Zeus")){
                    Main.getInstance().Zeus.addEntry(target.getDisplayName());
                    player.sendMessage(Main.getInstance().getPrefix()+""+target.getName()+" ? ?t? ajout? ? la team "+Main.getInstance().scoreboard.getEntryTeam(target.getName()).getName());
                    SQLMethods.setTeams(target);
                }
            }
        }
        return false;
    }
}
