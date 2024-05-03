package fr.cite.core.listeners;

import fr.cite.core.Main;
import fr.cite.core.utils.SQLMethods;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

import static org.bukkit.ChatColor.DARK_PURPLE;

public class OnShop implements Listener {

    @EventHandler
    public void onShop(InventoryClickEvent event){
        Player p = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        int item = 0;
        int price = 0;
        int price_bm = 0;
        if(clickedItem != null){
            price = SQLMethods.getPrice(clickedItem.getType().toString());
            price_bm = (int) (SQLMethods.getPrice(clickedItem.getType().toString())*1.1);
        }
        if(clickedItem == null){

            return;
        }
        if (clickedItem.getType() == null) {
            return;
        }
        if (p.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.GOLD+"Vente de block")) {
            event.setCancelled(true);
            if(clickedItem.getItemMeta().hasDisplayName() && p.getInventory().contains(clickedItem.getType())){
                for(Map.Entry<Integer, ? extends ItemStack> mapentry : p.getInventory().all(clickedItem.getType()).entrySet()){
                    item += mapentry.getValue().getAmount();
                }
                p.sendMessage(Main.getInstance().getPrefix()+ChatColor.AQUA+" Vous avez vendu "+ChatColor.GREEN+""+item+"x"+clickedItem.getType()+ChatColor.AQUA+" pour "+ChatColor.GREEN+""+item*price+ChatColor.AQUA+" drachmes.");
                SQLMethods.addCoins(p,item*price);
                SQLMethods.addTeamCoins(item*price,p);
                p.getInventory().remove(clickedItem.getType());

            }
        }
        if (p.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.GOLD+"Vente de Nourriture")) {
            event.setCancelled(true);
            if(clickedItem.getItemMeta().hasDisplayName() && p.getInventory().contains(clickedItem.getType())){
                for(Map.Entry<Integer, ? extends ItemStack> mapentry : p.getInventory().all(clickedItem.getType()).entrySet()){
                    item += mapentry.getValue().getAmount();
                }
                p.sendMessage(Main.getInstance().getPrefix()+ChatColor.AQUA+" Vous avez vendu "+ChatColor.GREEN+""+item+"x"+clickedItem.getType()+ChatColor.AQUA+" pour "+ChatColor.GREEN+""+item*price+ChatColor.AQUA+" drachmes.");
                SQLMethods.addCoins(p,item*price);
                SQLMethods.addTeamCoins(item*price,p);
                p.getInventory().remove(clickedItem.getType());

            }
        }
        if (p.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.GOLD+"Vente d'item divers")) {
            event.setCancelled(true);
            if(clickedItem.getItemMeta().hasDisplayName() && p.getInventory().contains(clickedItem.getType())){
                for(Map.Entry<Integer, ? extends ItemStack> mapentry : p.getInventory().all(clickedItem.getType()).entrySet()){
                    item += mapentry.getValue().getAmount();
                }
                p.sendMessage(Main.getInstance().getPrefix()+ChatColor.AQUA+" Vous avez vendu "+ChatColor.GREEN+""+item+"x"+clickedItem.getType()+ChatColor.AQUA+" pour "+ChatColor.GREEN+""+item*price+ChatColor.AQUA+" drachmes.");
                SQLMethods.addCoins(p,item*price);
                SQLMethods.addTeamCoins(item*price,p);
                p.getInventory().remove(clickedItem.getType());

            }
        }
        if (p.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.GOLD+"Vente de ressources")) {
            event.setCancelled(true);
            if(clickedItem.getItemMeta().hasDisplayName() && p.getInventory().contains(clickedItem.getType())){
                for(Map.Entry<Integer, ? extends ItemStack> mapentry : p.getInventory().all(clickedItem.getType()).entrySet()){
                    item += mapentry.getValue().getAmount();
                }
                p.sendMessage(Main.getInstance().getPrefix()+ChatColor.AQUA+" Vous avez vendu "+ChatColor.GREEN+""+item+"x"+clickedItem.getType()+ChatColor.AQUA+" pour "+ChatColor.GREEN+""+item*price+ChatColor.AQUA+" drachmes.");
                SQLMethods.addCoins(p,item*price);
                SQLMethods.addTeamCoins(item*price,p);
                p.getInventory().remove(clickedItem.getType());

            }
        }
        if (p.getOpenInventory().getTitle().equalsIgnoreCase(ChatColor.GOLD+"Vente d'Item")) {
            event.setCancelled(true);
            if(clickedItem.getItemMeta().hasDisplayName() && p.getInventory().contains(clickedItem.getType())){
                for(Map.Entry<Integer, ? extends ItemStack> mapentry : p.getInventory().all(clickedItem.getType()).entrySet()){
                    item += mapentry.getValue().getAmount();
                }
                p.sendMessage(Main.getInstance().getPrefix()+ChatColor.AQUA+" Vous avez vendu "+ChatColor.GREEN+""+item+"x"+clickedItem.getType()+ChatColor.AQUA+" pour "+ChatColor.GREEN+""+item*price+ChatColor.AQUA+" drachmes.");
                SQLMethods.addCoins(p,item*price);
                SQLMethods.addTeamCoins(item*price,p);
                p.getInventory().remove(clickedItem.getType());

            }
        }
        if (p.getOpenInventory().getTitle().equalsIgnoreCase(DARK_PURPLE+"Marché Noir")) {
            event.setCancelled(true);
            if(clickedItem.getItemMeta().hasDisplayName() && p.getInventory().contains(clickedItem.getType())){
                for(Map.Entry<Integer, ? extends ItemStack> mapentry : p.getInventory().all(clickedItem.getType()).entrySet()){
                    item += mapentry.getValue().getAmount();
                }
                p.sendMessage(Main.getInstance().getPrefix()+ChatColor.AQUA+" Vous avez vendu "+ChatColor.GREEN+""+item+"x"+clickedItem.getType()+ChatColor.AQUA+" pour "+ChatColor.GREEN+""+item*price_bm+ChatColor.AQUA+" drachmes.");
                SQLMethods.addCoins(p,item*price_bm);
                SQLMethods.addTeamCoins(item*price_bm,p);
                p.getInventory().remove(clickedItem.getType());

            }
        }
    }

}
