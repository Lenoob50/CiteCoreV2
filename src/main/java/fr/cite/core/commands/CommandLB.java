package fr.cite.core.commands;

import fr.cite.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class CommandLB implements CommandExecutor {
  public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
    if (commandSender instanceof Player) {
      ItemStack lb = new ItemStack(Material.PLAYER_HEAD, Integer.valueOf(strings[0]).intValue());
      SkullMeta meta = (SkullMeta)lb.getItemMeta();
      meta.setOwner("luck");
      meta.setDisplayName("blocks");
      meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
      meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
      meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
      lb.setItemMeta((ItemMeta)meta);
      if (strings.length >= 2) {
        ((Player)commandSender).getInventory().addItem(new ItemStack[] { lb });
        commandSender.sendMessage(Main.getInstance().getPrefix() + " Vous avez reçu" + strings[0] + " lucky block");
      } else {
        Player to_give = Bukkit.getPlayer(strings[1]);
        to_give.getInventory().addItem(new ItemStack[] { lb });
        commandSender.sendMessage(Main.getInstance().getPrefix() + " Vous avez reçu" + strings[0] + " lucky block de la part de " + ((Player)commandSender).getName());
      } 
    } 
    return false;
  }
}
