package fr.cite.core.commands;

import fr.cite.core.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandOffre implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            player.sendMessage("");
            player.sendMessage(Main.getInstance().getPrefix()+ ChatColor.AQUA+""+" Voici le lien de notre partenaire : ");
            player.sendMessage(Main.getInstance().getPrefix()+ChatColor.GREEN+""+" https://billing.kinetichosting.net/aff.php?aff=655");
            player.sendMessage(Main.getInstance().getPrefix()+ChatColor.AQUA+""+" Avec le code "+ChatColor.GREEN+"NOOBIS"+ChatColor.AQUA+" obtenez -15% sur votre premier mois");
            player.sendMessage("");
        }
        return false;
    }
}
