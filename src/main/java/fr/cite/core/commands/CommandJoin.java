package fr.cite.core.commands;

import fr.cite.core.Main;
import fr.cite.core.inventory.InventoryManager;
import fr.cite.core.utils.SQLMethods;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class CommandJoin implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            Inventory teams = new InventoryManager().Team;
            if(SQLMethods.getPlayerTeam(player).equalsIgnoreCase("No Team")){
                player.openInventory(teams);
                player.updateInventory();
            }else {
                player.sendMessage(Main.getInstance().getPrefix()+ChatColor.RED+" Tu possède déjà une team");

            }
        }
        return false;
    }
}
