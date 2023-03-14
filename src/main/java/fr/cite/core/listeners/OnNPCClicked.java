package fr.cite.core.listeners;

import fr.cite.core.Main;
import fr.cite.core.inventory.InventoryManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;

public class OnNPCClicked implements Listener {

    @EventHandler
    public void onNPCClicked(PlayerInteractEntityEvent event){
        Player player = event.getPlayer();
        Entity entity = event.getRightClicked();
        Inventory banque = new InventoryManager().Banque;
        if(isCustomNPC(entity)){
            if(entity.getCustomName().equalsIgnoreCase(ChatColor.DARK_GREEN+"Banque")){
                if(player.isOp()){
                    event.setCancelled(true);
                    player.openInventory(banque);
                    player.updateInventory();
                    player.sendMessage(Main.getInstance().getPrefix()+ChatColor.GREEN+" L'id de l'entity est "+ChatColor.AQUA+""+entity.getEntityId());
                }else{
                    event.setCancelled(true);
                    player.openInventory(banque);
                    player.updateInventory();
                }
            }
        }
    }

    private boolean isCustomNPC(Entity entity) {
        if(entity instanceof Villager){
            Villager npc = (Villager) entity;
            if(npc.isCustomNameVisible() && npc.getCustomName() !=null){
                return true;
            }
        }
        return false;

    }
}
