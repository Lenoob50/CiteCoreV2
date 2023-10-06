package fr.cite.core.inventory;


import javafx.geometry.Pos;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import static org.bukkit.ChatColor.*;


public class InventoryManager {

	public Inventory Banque;
	public Inventory Food;
	public Inventory Team;

	
	 public InventoryManager(){
		 	Banque();
		 	Food();
			Team();
	 }

	 public void Food(){
	 	Inventory invt = Bukkit.createInventory(null,6*9, AQUA+"Vendeur de Nourriture");
	 	ItemStack steak = new ItemStack(Material.COOKED_BEEF,1);

	 }

	 public void Team(){
		 Inventory inventory = Bukkit.createInventory(null,3*9,AQUA+"Choix des Teams");

		 ItemStack apollon = new ItemStack(Material.LIME_WOOL,1);
		 ItemMeta apollonM = apollon.getItemMeta();
		 apollonM.setDisplayName(AQUA+"Choisir "+GREEN+"Apollon");
		 apollon.setItemMeta(apollonM);

		 ItemStack ares = new ItemStack(Material.RED_WOOL,1);
		 ItemMeta aresM = ares.getItemMeta();
		 aresM.setDisplayName(AQUA+"Choisir "+RED+"Arès");
		 ares.setItemMeta(aresM);

		 ItemStack Poseidon = new ItemStack(Material.CYAN_WOOL,1);
		 ItemMeta poseidonM = Poseidon.getItemMeta();
		 poseidonM.setDisplayName(AQUA+"Choisir Poséidon");
		 Poseidon.setItemMeta(poseidonM);

		 ItemStack zeus = new ItemStack(Material.YELLOW_WOOL,1);
		 ItemMeta zeusM = zeus.getItemMeta();
		 zeusM.setDisplayName(AQUA+"Choisir "+GOLD+"Zeus");
		 zeus.setItemMeta(zeusM);

		 ItemStack dionysos = new ItemStack(Material.PURPLE_WOOL,1);
		 ItemMeta dionysosM = dionysos.getItemMeta();
		 dionysosM.setDisplayName(AQUA+"Choisir "+DARK_PURPLE+"Dionysos");
		 dionysos.setItemMeta(dionysosM);

		 inventory.setItem(9,apollon);
		 inventory.setItem(11,ares);
		 inventory.setItem(13,Poseidon);
		 inventory.setItem(15,zeus);
		 inventory.setItem(17,dionysos);
		 Team = inventory;

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

