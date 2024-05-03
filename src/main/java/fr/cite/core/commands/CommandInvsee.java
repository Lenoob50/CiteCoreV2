package fr.cite.core.commands;

import fr.cite.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CommandInvsee implements CommandExecutor {
    Inventory inventory;
    Player target;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("invsee")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("core.invsee.use")) {
                    if (args.length == 0) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cMerci de spécifier un joueur!"));
                    } else if (args.length == 1) {
                        target = Bukkit.getPlayer(args[0]);
                        inventory = Bukkit.createInventory(null, 54, "inventory");

                        ItemStack health = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
                        ItemMeta healthMeta = health.getItemMeta();
                        healthMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&lVie"));
                        ArrayList<String> healthLore = new ArrayList<String>();
                        healthLore.add(ChatColor.translateAlternateColorCodes('&', "&c" + Math.round(target.getHealth()) + " &rvie"));
                        healthLore.add(ChatColor.translateAlternateColorCodes('&', "&c" + Math.round(target.getHealth()) / 2 + " &rpoints de vie"));
                        healthMeta.setLore(healthLore);
                        health.setItemMeta(healthMeta);
                        inventory.setItem(51, health);

                        ItemStack hunger = new ItemStack(Material.COOKED_BEEF);
                        ItemMeta hungerMeta = hunger.getItemMeta();
                        hungerMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&lNourriture"));
                        ArrayList<String> hungerLore = new ArrayList<String>();
                        hungerLore.add(ChatColor.translateAlternateColorCodes('&', "&e" + target.getFoodLevel() + " &rpoint de nourriture"));
                        hungerMeta.setLore(hungerLore);
                        hunger.setItemMeta(hungerMeta);
                        inventory.setItem(52, hunger);

                        ItemStack xp = new ItemStack(Material.EXPERIENCE_BOTTLE);
                        ItemMeta xpMeta = xp.getItemMeta();
                        xpMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lExperience"));
                        ArrayList<String> xpLore = new ArrayList<String>();
                        xpLore.add(ChatColor.translateAlternateColorCodes('&', "&a" + target.getTotalExperience() + " &rexperience (&a" + target.getLevel() + "&r)"));
                        xpMeta.setLore(xpLore);
                        xp.setItemMeta(xpMeta);
                        inventory.setItem(53, xp);

                        ItemStack stainedGlass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                        ItemMeta stainedGlassMeta = stainedGlass.getItemMeta();
                        stainedGlassMeta.setDisplayName(" ");
                        stainedGlass.setItemMeta(stainedGlassMeta);

                        for (int i = 0; i < 9; i++) {
                            inventory.setItem(36 + i, stainedGlass);
                        }
                        inventory.setItem(50, stainedGlass);

                        for (int i = 0; i < 9; i++) {
                            inventory.setItem(27 + i, target.getInventory().getItem(i));
                        }

                        ItemStack[] armorContent = target.getInventory().getArmorContents();
                        for (int i = 0; i < 4; i++) {
                            inventory.setItem(45 + i, armorContent[3 - i]);
                        }
                        inventory.setItem(49, target.getInventory().getItemInOffHand());

                        for (int i = 0; i < 27; i++) {
                            inventory.setItem(i, target.getInventory().getItem(i + 9));
                        }

                        player.openInventory(inventory);
                    } else if (args.length == 2) {
                        if (player != null && target != null) {
                            player.openInventory(inventory);
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6" + player.getName() + " &anow sees&6 " + target.getName() + "'s &ainventory"));
                        } else {
                            player.sendMessage(Main.getInstance().getPrefix()+ChatColor.RED + "Joueur hors-ligne!");
                        }
                    }
                }
            } else {
                if (args.length == 0 || args.length == 1) {
                    sender.sendMessage(Main.getInstance().getPrefix()+"Merci de spécifier un joueur!");
                }
                if (args.length == 2) {
                    Player player = Bukkit.getPlayer(args[1]);
                    Player target = Bukkit.getPlayer(args[0]);
                    if (player != null && target != null) {
                        player.openInventory(inventory);
                        sender.sendMessage(Main.getInstance().getPrefix()+player.getName() + " now sees " + target.getName() + "'s inventory");
                    } else {
                        sender.sendMessage(Main.getInstance().getPrefix()+"Ce joueur est hors ligne!");
                    }

                }
            }
        }
        return true;
    }
}
