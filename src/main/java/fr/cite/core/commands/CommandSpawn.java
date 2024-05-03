package fr.cite.core.commands;

import fr.cite.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

public class CommandSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            Location spawn = new Location(Bukkit.getWorld("world"),91,225,-102);
            new BukkitRunnable() {
                int timer = 5;
                @Override
                public void run() {
                    if (timer > 0) {
                        player.sendMessage(Main.getInstance().getPrefix()+ChatColor.AQUA+" Téléportation dans " + ChatColor.GREEN+""+timer+ChatColor.AQUA+" secondes");
                        timer--;
                    } else {
                        player.teleport(spawn);
                        this.cancel();
                    }
                }
            }.runTaskTimer(Main.getInstance(), 0L, 20L);

        }

        return false;
    }
}
