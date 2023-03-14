package fr.cite.core.inventory;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import static org.bukkit.ChatColor.*;


public class InventoryManager {

	public Inventory Banque;

	
	 public InventoryManager(){
		 	Banque();
	 }

	public void Banque(){
	        Inventory invt = Bukkit.createInventory(null,27, ChatColor.AQUA+"Banque");

	        ItemStack ems = new ItemStack(Material.EMERALD,1);
	        ItemMeta emsM = ems.getItemMeta();
			emsM.setDisplayName(GREEN+"Déposer des Emeraudes");
			ems.setItemMeta(emsM);


			ItemStack emsblock = new ItemStack(Material.EMERALD_BLOCK,1);
			ItemMeta emsblockM = emsblock.getItemMeta();
			emsblockM.setDisplayName(GREEN+"Déposer des blocks d'emeraude");
			emsblock.setItemMeta(emsblockM);

			invt.setItem(12,ems);
			invt.setItem(14,emsblock);

	        Banque = invt;
	 }
}

