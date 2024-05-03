package fr.cite.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandEnder implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            Player target = Bukkit.getPlayer(strings[0]);
            if(strings.length ==0){
                player.sendMessage(ChatColor.RED+"Merci de préciser un joueur");
            }else {
                player.openInventory(target.getEnderChest());
            }
        }
        return false;
    }
}
