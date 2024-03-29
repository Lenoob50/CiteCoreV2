package fr.cite.core.listeners;

import fr.cite.core.Main;
import fr.cite.core.inventory.InventoryManager;
import fr.cite.core.scoreboard.Scoreboard;
import fr.cite.core.utils.SQLMethods;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;

import javax.swing.*;

import static org.bukkit.ChatColor.*;

public class OnJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        String team = SQLMethods.getPlayerTeam(player);
        String welcome_msg = Main.getInstance().getConfig().getString("msg.welcome");
        welcome_msg = welcome_msg.replaceAll("%player_name%",player.getName());
        event.setJoinMessage("");
        if(SQLMethods.getPlayerTeam(player)=="No Team"){
            Inventory inv = new InventoryManager().Team;
            player.openInventory(inv);
            player.updateInventory();
        }
        player.setPlayerListHeaderFooter(DARK_AQUA+"Cite",GREEN+"\nDev : TitouLeVrai et Lenoob_\n"+YELLOW+"Build : lorddowie\n"+AQUA+"Orga : Dori_Ki");
        if(!player.hasPlayedBefore()){
            SQLMethods.registerPlayer(player);
            SQLMethods.registerSite(player);
            player.sendMessage(Main.getInstance().getPrefix()+"Votre mot de passe pour le site est "+SQLMethods.getPassword(player));
            if(Main.getInstance().getConfig().getBoolean("options.welcome")){
                Bukkit.broadcastMessage(Main.getInstance().getPrefix().replaceAll("&","§")+welcome_msg);
            }else{
                Bukkit.broadcastMessage(GRAY+"["+GREEN+"+"+GRAY+"] "+RESET+""+player.getName());
            }
        }else{
            if (player.isOp()){
                Bukkit.broadcastMessage(GRAY+"["+GREEN+"+"+GRAY+"] "+RED+"Admin "+RESET+player.getName());
            }else{
                Bukkit.broadcastMessage(GRAY+"["+GREEN+"+"+GRAY+"] "+RESET+""+player.getName());
            }
        }
        new Scoreboard(Main.getInstance().sm).game(player);
        player.setScoreboard(Main.getInstance().scoreboard);
        if(team.equalsIgnoreCase("Apollon")){
            Main.getInstance().Apolon.addEntry(player.getName());
        }else if(team.equalsIgnoreCase("Arès")){
            Main.getInstance().Ares.addEntry(player.getName());
        }else if(team.equalsIgnoreCase("Poséidon")){
            Main.getInstance().Poseidon.addEntry(player.getName());
        }else if(team.equalsIgnoreCase("Zeus")){
            Main.getInstance().Zeus.addEntry(player.getName());
        }else if(team.equalsIgnoreCase("Dionysos")){
            Main.getInstance().Dionysos.addEntry(player.getName());
        }else {
            return;
        }

    }


}
