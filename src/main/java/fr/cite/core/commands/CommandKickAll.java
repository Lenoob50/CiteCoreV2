package fr.cite.core.commands;

import fr.cite.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandKickAll implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            for(Player op : Bukkit.getOnlinePlayers()){
                if(!op.isOp()){
                    player.kickPlayer(op.getName());
                }
            }
            Bukkit.getServer().setWhitelist(true);
            player.sendMessage(Main.getInstance().getPrefix()+" Vous avez expulsé tout les joueurs");
        }
        return false;
    }
}
