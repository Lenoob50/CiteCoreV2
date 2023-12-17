package fr.cite.core.commands;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;

import fr.cite.core.Main;
import fr.cite.core.utils.SQLMethods;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;


public class CommandRes implements CommandExecutor {
  public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
    org.bukkit.World worldbukkit = Bukkit.getWorld("world");
    World world = BukkitAdapter.adapt(worldbukkit);
    RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
    RegionManager regionManager = container.get(world);
    if (commandSender instanceof Player) {
      Player player = (Player) commandSender;
      if (strings.length > 0) {
        if (player.isOp()) {
          if (strings[0].equalsIgnoreCase("add")) {
            Player target = Bukkit.getPlayer(strings[1]);
            ProtectedRegion region = regionManager.getRegion(strings[2]);
            region.getOwners().addPlayer(target.getName());
            SQLMethods.setRes(target, Integer.valueOf(strings[2]).intValue());
            player.sendMessage(Main.getInstance().getPrefix() + "" + target + " est devenu propriaitaire de la réssidence avec l'id " + strings[2]);
          }
          if (strings[0].equalsIgnoreCase("remove")) {
            Player target = Bukkit.getPlayer(strings[1]);
            ProtectedRegion region = regionManager.getRegion(strings[2]);
            region.getOwners().removePlayer(target.getName());
            SQLMethods.setRes(target, 0);
            player.sendMessage(Main.getInstance().getPrefix() + "" + target + " n'est plus le/la propriaitaire de la réssidence avec l'id " + strings[2]);
          }
        } else if (SQLMethods.getRes(player) > 0) {
          if (strings[0].equalsIgnoreCase("member-add")) {
            Player target = Bukkit.getPlayer(strings[1]);
            ProtectedRegion region = regionManager.getRegion(strings[2]);
            if (region.getMembers().size() < 2) {
              region.getMembers().addPlayer(target.getName());
              player.sendMessage(Main.getInstance().getPrefix() + "" + target + " ajouté à votre résidence");
            } else {
              player.sendMessage(Main.getInstance().getPrefix() + ChatColor.RED + "Vous ne pouvez pas ajouter plus de 2 personnes dans votre réssidence");
            }
          }
          if (strings[0].equalsIgnoreCase("member-remove")) {
            Player target = Bukkit.getPlayer(strings[1]);
            ProtectedRegion region = regionManager.getRegion(strings[2]);
            region.getMembers().removePlayer(target.getName());
            player.sendMessage(Main.getInstance().getPrefix() + "" + target + " retiré de votre réssidence");
          }
        }
      }
    }
    return false;
  }
}
