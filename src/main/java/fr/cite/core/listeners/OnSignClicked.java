package fr.cite.core.listeners;

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
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.jetbrains.annotations.Nullable;

public class OnSignClicked implements Listener {
  @EventHandler
  public void onSignInterract(PlayerInteractEvent event) {
    Player player = event.getPlayer();
    Block block = event.getClickedBlock();
    Action action = event.getAction();
    org.bukkit.@Nullable World worldbukkit = Bukkit.getWorld("world");
    World world = (World) BukkitAdapter.adapt(worldbukkit);
    RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
    RegionManager regionManager = container.get(world);
    if (block == null) {
      return;
    }
    if (action == Action.RIGHT_CLICK_BLOCK) {
      BlockState blockState = block.getState();
      if (blockState instanceof Sign) {
        Sign sign = (Sign)blockState;
        ProtectedRegion region = regionManager.getRegion(sign.getLine(2));
        if (sign.getLine(0).equalsIgnoreCase("[CiteCore]")) {
          if (sign.getLine(3).equalsIgnoreCase("Appart")) {
            if (SQLMethods.getMoney(player) >= Integer.valueOf(sign.getLine(1)).intValue()) {
              sign.setEditable(true);
              SQLMethods.addCoins(player, -Integer.valueOf(sign.getLine(1)).intValue());
              SQLMethods.addTeamCoins(-Integer.valueOf(sign.getLine(1)).intValue(), player);
              player.sendMessage(Main.instance.getPrefix() + " Tu as acheter un " + sign.getLine(3) + " pour " + sign.getLine(1) + " Coins");
              sign.setLine(0, ChatColor.RED + "[CiteCore]");
              sign.setLine(1, player.getName());
              sign.setLine(3, "ID : " + sign.getLine(2));
              sign.setLine(2, "Appart");
              sign.setGlowingText(true);
              sign.update();
              region.getOwners().addPlayer(player.getName());
              SQLMethods.setRes(player, Integer.valueOf(sign.getLine(2)).intValue());
            } else {
              player.sendMessage(Main.instance.getPrefix() + " Tu n'as pas les sous pour acheter ceci");
            }
          }
          if (sign.getLine(3).equalsIgnoreCase("Maison")) {
            if (SQLMethods.getMoney(player) >= Integer.valueOf(sign.getLine(1)).intValue()) {
              sign.setEditable(true);
              SQLMethods.addCoins(player, -Integer.valueOf(sign.getLine(1)).intValue());
              SQLMethods.addTeamCoins(-Integer.valueOf(sign.getLine(1)).intValue(), player);
              player.sendMessage(Main.instance.getPrefix() + " Tu as acheter un " + sign.getLine(3) + " pour " + sign.getLine(1) + " Coins");
              sign.setLine(0, ChatColor.RED + "[CiteCore]");
              sign.setLine(1, player.getName());
              sign.setLine(3, "ID : " + sign.getLine(2));
              sign.setLine(2, "Maison");
              sign.setGlowingText(true);
              sign.update();
              region.getOwners().addPlayer(player.getName());
              SQLMethods.setRes(player, Integer.valueOf(sign.getLine(2)).intValue());
            } else {
              player.sendMessage(Main.instance.getPrefix() + " Tu n'as pas les sous pour acheter ceci");
            }
          }
        } else {
          return;
        } 
      } 
    } 
  }
}
