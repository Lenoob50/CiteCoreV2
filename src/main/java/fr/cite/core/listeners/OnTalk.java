package fr.cite.core.listeners;

import fr.cite.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import static org.bukkit.ChatColor.*;

public class OnTalk implements Listener {

    @EventHandler
    public void onTalk(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        String newmsg = event.getMessage().substring(1);
        event.setCancelled(true);
        if(Main.getInstance().Apolon.getEntries().contains(player.getDisplayName())){
            if(!event.getMessage().startsWith("!")){
                for(String pt : Main.getInstance().Apolon.getEntries()){
                    Player pr = Bukkit.getPlayer(pt);
                    pr.sendMessage(WHITE+"["+YELLOW+"Team"+RESET+"] "+GREEN+""+player.getName()+
                            GOLD+" >> "+RESET+""+event.getMessage());
                }
            }else {
                for(Player op : Bukkit.getOnlinePlayers()){
                    op.sendMessage(WHITE+"["+GREEN+"Global"+RESET+"] "+GREEN+""+Main.getInstance().Apolon.getPrefix()+RESET+""
                            +player.getDisplayName()+
                            GOLD+" >> "+RESET+""+newmsg);
                }
            }
        }else if(Main.getInstance().Ares.getEntries().contains(player.getDisplayName())){
            if(!event.getMessage().startsWith("!")){
                for(String pt : Main.getInstance().Ares.getEntries()){
                    Player pr = Bukkit.getPlayer(pt);
                    pr.sendMessage(WHITE+"["+YELLOW+"Team"+RESET+"] "+RED+""+player.getName()+
                            GOLD+" >> "+RESET+""+event.getMessage());
                }
            }else {
                for(Player op : Bukkit.getOnlinePlayers()){
                    op.sendMessage(WHITE+"["+GREEN+"Global"+RESET+"] "+RED+""+Main.getInstance().Ares.getPrefix()+RESET+""
                            +player.getDisplayName()+
                            GOLD+" >> "+RESET+""+newmsg);
                }
            }
        }else if(Main.getInstance().Dionysos.getEntries().contains(player.getDisplayName())){
            if(!event.getMessage().startsWith("!")){
                for(String pt : Main.getInstance().Dionysos.getEntries()){
                    Player pr = Bukkit.getPlayer(pt);
                    pr.sendMessage(WHITE+"["+YELLOW+"Team"+RESET+"] "+DARK_PURPLE+""+player.getName()+
                            GOLD+" >> "+RESET+""+event.getMessage());
                }
            }else {
                for(Player op : Bukkit.getOnlinePlayers()){
                    op.sendMessage(WHITE+"["+GREEN+"Global"+RESET+"] "+DARK_PURPLE+""+Main.getInstance().Dionysos.getPrefix()+RESET+""
                            +player.getDisplayName()+
                            GOLD+" >> "+RESET+""+newmsg);
                }
            }
        }else if(Main.getInstance().Poseidon.getEntries().contains(player.getDisplayName())){
            if(!event.getMessage().startsWith("!")){
                for(String pt : Main.getInstance().Poseidon.getEntries()){
                    Player pr = Bukkit.getPlayer(pt);
                    pr.sendMessage(WHITE+"["+YELLOW+"Team"+RESET+"] "+AQUA+""+player.getName()+
                            GOLD+" >> "+RESET+""+event.getMessage());
                }
            }else {
                for(Player op : Bukkit.getOnlinePlayers()){
                    op.sendMessage(WHITE+"["+GREEN+"Global"+RESET+"] "+AQUA+""+Main.getInstance().Poseidon.getPrefix()+RESET+""
                            +player.getDisplayName()+
                            GOLD+" >> "+RESET+""+newmsg);
                }
            }
        }else if(Main.getInstance().Zeus.getEntries().contains(player.getDisplayName())){
            if(!event.getMessage().startsWith("!")){
                for(String pt : Main.getInstance().Zeus.getEntries()){
                    Player pr = Bukkit.getPlayer(pt);
                    pr.sendMessage(WHITE+"["+YELLOW+"Team"+RESET+"] "+GOLD+""+player.getName()+
                            GOLD+" >> "+RESET+""+event.getMessage());
                }
            }else {
                for(Player op : Bukkit.getOnlinePlayers()){
                    op.sendMessage(WHITE+"["+GREEN+"Global"+RESET+"] "+GOLD+""+Main.getInstance().Zeus.getPrefix()+RESET+""
                            +player.getDisplayName()+
                            GOLD+" >> "+RESET+""+newmsg);
                }
            }
        }else if(player.isOp()){
            for(Player op : Bukkit.getOnlinePlayers()){
                op.sendMessage(WHITE+"["+GREEN+"Global"+RESET+"] "+DARK_RED+"Admin "+player.getName()+
                        GOLD+" >> "+RESET+""+event.getMessage());
            }
        }else {
            for(Player op : Bukkit.getOnlinePlayers()){
                op.sendMessage(WHITE+"["+GREEN+"Global"+RESET+"] "+player.getName()+
                        GOLD+" >> "+RESET+""+event.getMessage());
            }
        }
    }

}
