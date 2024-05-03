package fr.cite.core.commands;

import fr.cite.core.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandBug implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            player.sendMessage(Main.getInstance().getPrefix()+" ");
            player.sendMessage(Main.getInstance().getPrefix()+" Vous pouvez soumettre un bug ici : ");
            player.sendMessage(Main.getInstance().getPrefix()+ ChatColor.GREEN+" https://forms.gle/az8bjNX7sd1KqFzL7");
            player.sendMessage(Main.getInstance().getPrefix()+" ");
        }
        return false;
    }
}
