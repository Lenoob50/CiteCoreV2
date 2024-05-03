package fr.cite.core.commands;

import eu.decentsoftware.holograms.api.DHAPI;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import fr.cite.core.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandeHide implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            if(player.isOp()){
                Hologram teams = DHAPI.getHologram("Teams");
                Hologram players = DHAPI.getHologram("Players");
                teams.disable();
                players.disable();
                player.sendMessage(Main.getInstance().getPrefix()+ ChatColor.GREEN+" Tout les hologram on été chaché");

            }
        }
        return false;
    }
}
