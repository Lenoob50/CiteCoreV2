package fr.cite.core.listeners;

import com.sun.org.apache.regexp.internal.RE;
import fr.cite.core.Main;
import fr.cite.core.utils.SQLMethods;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Team;

import java.util.Map;

import static org.bukkit.ChatColor.*;

public class OnInventoryInterract implements Listener {

    @EventHandler
    public void onInvInterract(InventoryClickEvent event){
        Player p = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        int ems = 0;
        if(clickedItem == null)return;
        if(p.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.AQUA+"Banque")){
            event.setCancelled(true);
            if(clickedItem.getType().equals(Material.EMERALD)){
                if(clickedItem.getItemMeta().getDisplayName().equalsIgnoreCase(GREEN+"Déposer des Emeraudes")){
                    if(p.getInventory().contains(Material.EMERALD)){
                        for(Map.Entry<Integer, ? extends ItemStack> mapentry : p.getInventory().all(Material.EMERALD).entrySet()){
                            ems = ems + mapentry.getValue().getAmount();
                        }
                        SQLMethods.addCoins(p,ems*1);
                        p.sendMessage(Main.getInstance().getPrefix()+"Votre compte à été crédité de "+AQUA+ems+ RESET+" drachmes");
                        p.getInventory().remove(Material.EMERALD);
                        SQLMethods.addTeamCoins(ems*1,p);
                        if(Main.getInstance().scoreboard.getEntryTeam(p.getDisplayName()).getName().equalsIgnoreCase("Arès")){
                            SQLMethods.addCoinsPerTeam(Main.getInstance().scoreboard.getEntryTeam(p.getDisplayName()).getName().replace("Arès","Ares"),p);
                        }
                        if(Main.getInstance().scoreboard.getEntryTeam(p.getDisplayName()).getName().equalsIgnoreCase("Poséidon")){
                            SQLMethods.addCoinsPerTeam(Main.getInstance().scoreboard.getEntryTeam(p.getDisplayName()).getName().replace("Poséidon","Poseidon"),p);
                        }else{
                            SQLMethods.addCoinsPerTeam(Main.getInstance().scoreboard.getEntryTeam(p.getDisplayName()).getName(),p);
                        }


                }
                }
            }else if(clickedItem.getType().equals(Material.EMERALD_BLOCK)) {
                if (clickedItem.getItemMeta().getDisplayName().equalsIgnoreCase(GREEN + "Déposer des blocks d'emeraude")) {
                    if (p.getInventory().contains(Material.EMERALD_BLOCK)) {
                        for(Map.Entry<Integer, ? extends ItemStack> mapentry : p.getInventory().all(Material.EMERALD_BLOCK).entrySet()){
                            ems = ems + mapentry.getValue().getAmount();
                        }
                        p.sendMessage(Main.getInstance().getPrefix() + "Votre compte à été crédité de " + AQUA + ems*9 + RESET + " drachmes");
                        SQLMethods.addCoins(p, ems * 9);
                        p.getInventory().remove(Material.EMERALD_BLOCK);
                        SQLMethods.addTeamCoins(ems*9,p);
                        if(Main.getInstance().scoreboard.getEntryTeam(p.getDisplayName()).getName().equalsIgnoreCase("Arès")){
                            SQLMethods.addCoinsPerTeam(Main.getInstance().scoreboard.getEntryTeam(p.getDisplayName()).getName().replace("Arès","Ares"),p);
                        }
                        if(Main.getInstance().scoreboard.getEntryTeam(p.getDisplayName()).getName().equalsIgnoreCase("Poséidon")){
                            SQLMethods.addCoinsPerTeam(Main.getInstance().scoreboard.getEntryTeam(p.getDisplayName()).getName().replace("Poséidon","Poseidon"),p);
                        }else{
                            SQLMethods.addCoinsPerTeam(Main.getInstance().scoreboard.getEntryTeam(p.getDisplayName()).getName(),p);
                        }
                    }
                }
            }
            }else if(clickedItem.getType() == null){
                return;
            }

        }

}
