package fr.cite.core.listeners;

import fr.cite.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import static org.bukkit.ChatColor.*;

public class OnJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        String welcome_msg = Main.getInstance().getConfig().getString("msg.welcome");
        welcome_msg = welcome_msg.replaceAll("%player_name%",player.getName());
        event.setJoinMessage("");
        player.setPlayerListHeaderFooter(DARK_AQUA+"Cite",GREEN+"\nDev : TitouLeVrai et Lenoob_\n"+YELLOW+"Build : lorddowie\n"+AQUA+"Orga : Dori_Ki");
        if(!player.hasPlayedBefore()){
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
    }


}
