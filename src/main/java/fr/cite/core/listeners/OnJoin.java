package fr.cite.core.listeners;

import fr.cite.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage("");
        if(!player.hasPlayedBefore()){
            if(Main.getInstance().getConfig().getBoolean("options.welcome")){
                Bukkit.broadcastMessage(Main.getInstance().getPrefix()
                        +player.getName()+" §2 à rejoins la cité pour la première fois souhaitez lui la bienvenue");
            }else{
                Bukkit.broadcastMessage("§7[§2+§7]§r "+player.getName());
            }
        }else{
            if (player.isOp()){
                Bukkit.broadcastMessage("§7[§2+§7] §cAdmin§r "+player.getName());
            }else{
                Bukkit.broadcastMessage("§7[§2+§7]§r "+player.getName());
            }
        }
    }


}
