package fr.cite.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import static org.bukkit.ChatColor.*;

public class OnLeave implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent event){
        Player player = event.getPlayer();
        event.setQuitMessage("");
        if(player.isOp()){
            Bukkit.broadcastMessage(GRAY+"["+RED+"-"+GRAY+"]"+RED+" Admin "+RESET+""+player.getName());
        }else{
            Bukkit.broadcastMessage(GRAY+"["+RED+"-"+GRAY+"]"+RESET+""+player.getName());
        }
    }

}
