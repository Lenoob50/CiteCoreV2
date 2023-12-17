package fr.cite.core.listeners;

import fr.cite.core.Main;
import fr.cite.core.scoreboard.Scoreboard;
import fr.cite.core.utils.SQLMethods;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String team = SQLMethods.getPlayerTeam(player);
        String welcome_msg = Main.getInstance().getConfig().getString("msg.welcome");
        welcome_msg = welcome_msg.replaceAll("%player_name%", player.getName());
        event.setJoinMessage("");
        System.out.println(team);
        player.setPlayerListHeaderFooter(ChatColor.DARK_AQUA + "Cite Divine", ChatColor.GREEN + "\nDev : TitouLeVrai et Lenoob_\n" + ChatColor.YELLOW + "Build : lorddowie\n" + ChatColor.AQUA + "Orga : Dori_Ki");
        if (!player.hasPlayedBefore()) {
            SQLMethods.registerPlayer(player);
            SQLMethods.registerSite(player);
            player.sendMessage(Main.getInstance().getPrefix() + "Vous avez inscrit sur le site faites " + ChatColor.GOLD + " /site " + ChatColor.RESET + "<pseudo> pour connaitre votre mot de passe");
            player.sendMessage(Main.getInstance().getPrefix() + "Faites la commande /join pour obtenir votre team");
            if (Main.getInstance().getConfig().getBoolean("options.welcome")) {
                Bukkit.broadcastMessage(Main.getInstance().getPrefix().replaceAll("&", "§") + welcome_msg);
            } else {
                Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + ChatColor.RESET + player.getName());
            }
        } else if (player.isOp()) {
            Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + ChatColor.RED + "Admin " + ChatColor.RESET + player.getName());
        } else {
            Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + ChatColor.RESET + player.getName());
        }
        (new Scoreboard((Main.getInstance()).sm)).game(player);
        player.setScoreboard((Main.getInstance()).scoreboard);
        if (team.equalsIgnoreCase("Apollon")) {
            (Main.getInstance()).Apolon.addEntry(player.getName());
        } else if (team.equalsIgnoreCase("Arès")) {
            (Main.getInstance()).Ares.addEntry(player.getName());
        } else if (team.equalsIgnoreCase("Poséidon")) {
            (Main.getInstance()).Poseidon.addEntry(player.getName());
        } else if (team.equalsIgnoreCase("Zeus")) {
            (Main.getInstance()).Zeus.addEntry(player.getName());
        }
        else if (team.equalsIgnoreCase("Dionysos")) {
            (Main.getInstance()).Dionysos.addEntry(player.getName());
        } else {
            return;
        }
    }
}
