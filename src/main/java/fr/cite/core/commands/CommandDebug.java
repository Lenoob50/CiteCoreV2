package fr.cite.core.commands;

import fr.cite.core.inventory.InventoryManager;
import fr.cite.core.utils.SQLMethods;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CommandDebug implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            player.sendMessage(SQLMethods.doPlayerClassement().toString());
        }
        return false;
    }
}
