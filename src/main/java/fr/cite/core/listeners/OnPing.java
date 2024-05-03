package fr.cite.core.listeners;

import fr.cite.core.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class OnPing implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent event){
        if(Main.getInstance().getConfig().getInt("options.jour")<1){
            event.setMotd("§4Cité férmé au public");
        }else{
            event.setMotd("§2La Cité Divine \n§3Event du jour : §b"+Main.getInstance().event.get(Main.getInstance().getConfig().getInt("options.jour")));
        }
    }

}
