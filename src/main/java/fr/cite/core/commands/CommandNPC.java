package fr.cite.core.commands;

import fr.cite.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

public class CommandNPC implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player) {
      Player p = (Player)sender;
      Location playerLoc = p.getLocation();
      if (args.length == 0) {
        p.sendMessage(Main.getInstance().getPrefix() + ChatColor.DARK_RED + " Vous devez précisé un type de villageois/info");
      }
      if (args.length >= 1) {
        if (args[0].equalsIgnoreCase("Banque")) {
          Villager npc = (Villager)playerLoc.getWorld().spawnEntity(playerLoc, EntityType.VILLAGER);
          npc.setVillagerType(Villager.Type.PLAINS);
          npc.setProfession(Villager.Profession.ARMORER);
          npc.setInvulnerable(true);
          npc.setAI(false);
          npc.setVillagerLevel(4);
          npc.setCustomNameVisible(true);
          npc.setCustomName(ChatColor.DARK_GREEN + "Banque");
          npc.setCanPickupItems(false);
          p.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " L'id de l'entity est " + ChatColor.AQUA + "" + npc.getEntityId());
          Bukkit.getWorld("world").spawnParticle(Particle.VILLAGER_HAPPY, npc.getLocation(), 50);
        } 
        if (args[0].equalsIgnoreCase("Blocks")) {
          Villager npc = (Villager)playerLoc.getWorld().spawnEntity(playerLoc, EntityType.VILLAGER);
          npc.setVillagerType(Villager.Type.PLAINS);
          npc.setProfession(Villager.Profession.FARMER);
          npc.setInvulnerable(true);
          npc.setAI(false);
          npc.setVillagerLevel(4);
          npc.setCustomName(ChatColor.DARK_AQUA + "Block");
          npc.setCustomNameVisible(true);
          npc.setCanPickupItems(false);
          p.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " L'id de l'entity est " + ChatColor.AQUA + "" + npc.getEntityId());
          Bukkit.getWorld("world").spawnParticle(Particle.VILLAGER_HAPPY, npc.getLocation(), 50);
        } 
        if (args[0].equalsIgnoreCase("Food")) {
          Villager npc = (Villager)playerLoc.getWorld().spawnEntity(playerLoc, EntityType.VILLAGER);
          npc.setVillagerType(Villager.Type.PLAINS);
          npc.setProfession(Villager.Profession.FARMER);
          npc.setInvulnerable(true);
          npc.setAI(false);
          npc.setVillagerLevel(4);
          npc.setCustomName(ChatColor.DARK_AQUA + "Nourriture");
          npc.setCustomNameVisible(true);
          npc.setCanPickupItems(false);
          p.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " L'id de l'entity est " + ChatColor.AQUA + "" + npc.getEntityId());
          Bukkit.getWorld("world").spawnParticle(Particle.VILLAGER_HAPPY, npc.getLocation(), 50);
        } 
        if (args[0].equalsIgnoreCase("Divers")) {
          Villager npc = (Villager)playerLoc.getWorld().spawnEntity(playerLoc, EntityType.VILLAGER);
          npc.setVillagerType(Villager.Type.PLAINS);
          npc.setProfession(Villager.Profession.FARMER);
          npc.setInvulnerable(true);
          npc.setAI(false);
          npc.setVillagerLevel(4);
          npc.setCustomName(ChatColor.DARK_AQUA + "Divers");
          npc.setCustomNameVisible(true);
          npc.setCanPickupItems(false);
          p.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " L'id de l'entity est " + ChatColor.AQUA + "" + npc.getEntityId());
          Bukkit.getWorld("world").spawnParticle(Particle.VILLAGER_HAPPY, npc.getLocation(), 50);
        } 
        if (args[0].equalsIgnoreCase("Ressources")) {
          Villager npc = (Villager)playerLoc.getWorld().spawnEntity(playerLoc, EntityType.VILLAGER);
          npc.setVillagerType(Villager.Type.PLAINS);
          npc.setProfession(Villager.Profession.FARMER);
          npc.setInvulnerable(true);
          npc.setAI(false);
          npc.setVillagerLevel(4);
          npc.setCustomName(ChatColor.DARK_AQUA + "Ressources");
          npc.setCustomNameVisible(true);
          npc.setCanPickupItems(false);
          p.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " L'id de l'entity est " + ChatColor.AQUA + "" + npc.getEntityId());
          Bukkit.getWorld("world").spawnParticle(Particle.VILLAGER_HAPPY, npc.getLocation(), 50);
        } 
        if (args[0].equalsIgnoreCase("Item")) {
          Villager npc = (Villager)playerLoc.getWorld().spawnEntity(playerLoc, EntityType.VILLAGER);
          npc.setVillagerType(Villager.Type.PLAINS);
          npc.setProfession(Villager.Profession.FARMER);
          npc.setInvulnerable(true);
          npc.setAI(false);
          npc.setVillagerLevel(4);
          npc.setCustomName(ChatColor.DARK_AQUA + "Item");
          npc.setCustomNameVisible(true);
          npc.setCanPickupItems(false);
          p.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " L'id de l'entity est " + ChatColor.AQUA + "" + npc.getEntityId());
          Bukkit.getWorld("world").spawnParticle(Particle.VILLAGER_HAPPY, npc.getLocation(), 50);
        } 
        if (args[0].equalsIgnoreCase("mario")) {
          Villager npc = (Villager)playerLoc.getWorld().spawnEntity(playerLoc, EntityType.VILLAGER);
          npc.setVillagerType(Villager.Type.SAVANNA);
          npc.setProfession(Villager.Profession.LIBRARIAN);
          npc.setInvulnerable(true);
          npc.setAI(false);
          npc.setVillagerLevel(4);
          npc.setCustomName(ChatColor.GOLD + "Mario");
          npc.setCustomNameVisible(true);
          npc.setCanPickupItems(false);
          p.sendMessage(Main.getInstance().getPrefix() + ChatColor.GREEN + " L'id de l'entity est " + ChatColor.AQUA + "" + npc.getEntityId());
          Bukkit.getWorld("world").spawnParticle(Particle.VILLAGER_HAPPY, npc.getLocation(), 50);
        } 

        if (args[0].equalsIgnoreCase("info")) {
          p.sendMessage(ChatColor.AQUA + "===========||" + ChatColor.GREEN + "NPC INFO" + ChatColor.AQUA + "||===========");
          p.sendMessage(ChatColor.AQUA + "Banque : " + ChatColor.GREEN + " Permet de faire spawn le pnj " + ChatColor.AQUA + "Banquier");
          p.sendMessage(ChatColor.AQUA + "Blocks : " + ChatColor.GREEN + " Permet de faire spawn le pnj " + ChatColor.AQUA + "Blocks");
          p.sendMessage(ChatColor.AQUA + "Food : " + ChatColor.GREEN + " Permet de faire spawn le pnj " + ChatColor.AQUA + "Nourriture");
          p.sendMessage(ChatColor.AQUA + "Divers : " + ChatColor.GREEN + " Permet de faire spawn le pnj " + ChatColor.AQUA + "Divers");
          p.sendMessage(ChatColor.AQUA + "Ressources : " + ChatColor.GREEN + " Permet de faire spawn le pnj " + ChatColor.AQUA + "Ressources");
          p.sendMessage(ChatColor.AQUA + "Item : " + ChatColor.GREEN + " Permet de faire spawn le pnj " + ChatColor.AQUA + "Items");
          p.sendMessage(ChatColor.AQUA + "Quete : " + ChatColor.GREEN + " Permet de faire spawn le pnj " + ChatColor.AQUA + " Quetes");
          p.sendMessage(ChatColor.AQUA + "Mario : " + ChatColor.GREEN + " Permet de faire spawn le pnj " + ChatColor.AQUA + " Mario");
          p.sendMessage(ChatColor.AQUA + "===========||" + ChatColor.GREEN + "NPC INFO" + ChatColor.AQUA + "||===========");
        } 
        if (args[0].equalsIgnoreCase("remove")) {
          Main.getInstance().getServer().dispatchCommand(sender, "kill @e[type=minecraft:villager,distance=..10]");
        }
      } 
    } 
    return false;
  }
}
