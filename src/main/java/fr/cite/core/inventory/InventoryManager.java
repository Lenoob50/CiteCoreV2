package fr.cite.core.inventory;

import java.util.ArrayList;

import fr.cite.core.utils.SQLMethods;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import static org.bukkit.ChatColor.*;

public class InventoryManager {
  public Inventory Banque;
  
  public Inventory Food;
  
  public Inventory Team;
  
  public Inventory mario;

  public Inventory block_j1;
  public Inventory block_j2;
  public Inventory block_j3;
  public Inventory block_j4;
  public Inventory block_j5;

  public InventoryManager() {
    Banque();
    Food();
    Team();
    Mario();
    Block_J1();
    Block_J2();
    Block_J3();
    Block_J4();
    Block_J5();
  }
  
  public void Food() {
    Inventory invt = Bukkit.createInventory(null, 54, ChatColor.AQUA + "Vendeur de Nourriture");
    ItemStack steak = new ItemStack(Material.COOKED_BEEF, 1);
  }
  
  public void Team() {
    Inventory inventory = Bukkit.createInventory(null, 27, ChatColor.AQUA + "Choix des Teams");
    ItemStack apollon = new ItemStack(Material.LIME_WOOL, 1);
    ItemMeta apollonM = apollon.getItemMeta();
    apollonM.setDisplayName(ChatColor.AQUA + "Choisir " + ChatColor.GREEN + "Apollon");
    apollon.setItemMeta(apollonM);
    ItemStack ares = new ItemStack(Material.RED_WOOL, 1);
    ItemMeta aresM = ares.getItemMeta();
    aresM.setDisplayName(ChatColor.AQUA + "Choisir " + ChatColor.RED + "Arès");
    ares.setItemMeta(aresM);
    ItemStack Poseidon = new ItemStack(Material.CYAN_WOOL, 1);
    ItemMeta poseidonM = Poseidon.getItemMeta();
    poseidonM.setDisplayName(ChatColor.AQUA + "Choisir Poséidon");
    Poseidon.setItemMeta(poseidonM);
    ItemStack zeus = new ItemStack(Material.YELLOW_WOOL, 1);
    ItemMeta zeusM = zeus.getItemMeta();
    zeusM.setDisplayName(ChatColor.AQUA + "Choisir " + ChatColor.GOLD + "Zeus");
    zeus.setItemMeta(zeusM);
    ItemStack dionysos = new ItemStack(Material.PURPLE_WOOL, 1);
    ItemMeta dionysosM = dionysos.getItemMeta();
    dionysosM.setDisplayName(ChatColor.AQUA + "Choisir " + ChatColor.DARK_PURPLE + "Dionysos");
    dionysos.setItemMeta(dionysosM);
    inventory.setItem(9, apollon);
    inventory.setItem(11, ares);
    inventory.setItem(13, Poseidon);
    inventory.setItem(15, zeus);
    inventory.setItem(17, dionysos);
    this.Team = inventory;
  }
  
  public void Banque() {
    Inventory invt = Bukkit.createInventory(null, 27, ChatColor.AQUA + "Banque");
    ItemStack ems = new ItemStack(Material.EMERALD, 1);
    ItemMeta emsM = ems.getItemMeta();
    emsM.setDisplayName(ChatColor.GREEN + "Déposer des Emeraudes");
    ems.setItemMeta(emsM);
    ItemStack emsblock = new ItemStack(Material.EMERALD_BLOCK, 1);
    ItemMeta emsblockM = emsblock.getItemMeta();
    emsblockM.setDisplayName(ChatColor.GREEN + "Déposer des blocks d'emeraude");
    emsblock.setItemMeta(emsblockM);
    invt.setItem(12, ems);
    invt.setItem(14, emsblock);
    this.Banque = invt;
  }
  
  public void Mario() {
    Inventory invt = Bukkit.createInventory(null, 27, ChatColor.GOLD + "Here we go");
    ArrayList<String> lore = new ArrayList();
    ItemStack lb1 = new ItemStack(Material.PLAYER_HEAD);
    SkullMeta meta1 = (SkullMeta)lb1.getItemMeta();
    meta1.setOwner("luck");
    meta1.setDisplayName("Lucky blocks");
    lore.add(": &28G");
    meta1.setLore(lore);
    meta1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
    meta1.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
    meta1.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
    lb1.setItemMeta((ItemMeta)meta1);
    invt.setItem(13, lb1);
    this.mario = invt;
  }

  public void Block_J1(){
    Inventory invt = Bukkit.createInventory(null,27,ChatColor.GOLD+"Vente de block");
    ItemStack sponge = new ItemStack(Material.SPONGE);
    ArrayList<String> sponge_lore = new ArrayList<>();
    sponge_lore.add(AQUA+"Vendre "+GREEN+""+sponge.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(sponge.getType().toString()));
    ItemMeta meta_sponge = sponge.getItemMeta();
    meta_sponge.setDisplayName(GREEN+"Vendre Eponges");
    meta_sponge.setLore(sponge_lore);
    sponge.setItemMeta(meta_sponge);
    ItemStack cobweb = new ItemStack(Material.COBWEB);
    ArrayList<String> web_lore = new ArrayList<>();
    web_lore.add(AQUA+"Vendre "+GREEN+""+cobweb.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(cobweb.getType().toString()));
    ItemMeta web = cobweb.getItemMeta();
    web.setLore(web_lore);
    web.setDisplayName(GREEN+"Vendre Cobweb");
    cobweb.setItemMeta(web);
    ItemStack gold_block = new ItemStack(Material.GOLD_BLOCK);
    ArrayList<String> gold_lore = new ArrayList<>();
    gold_lore.add(AQUA+"Vendre "+GREEN+""+gold_block.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(gold_block.getType().toString()));
    ItemMeta gold_meta = gold_block.getItemMeta();
    gold_meta.setDisplayName(GREEN+"Vendre bloc d'or");
    gold_meta.setLore(gold_lore);
    gold_block.setItemMeta(gold_meta);
    invt.setItem(0,sponge);
    invt.setItem(1,cobweb);
    invt.setItem(2,gold_block);
    this.block_j1 = invt;

  }
  public void Block_J2(){
    Inventory invt = Bukkit.createInventory(null,27,ChatColor.GOLD+"Vente de block");
    ItemStack sponge = new ItemStack(Material.SPONGE);
    ArrayList<String> sponge_lore = new ArrayList<>();
    sponge_lore.add(AQUA+"Vendre "+GREEN+""+sponge.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(sponge.getType().toString()));
    ItemMeta meta_sponge = sponge.getItemMeta();
    meta_sponge.setDisplayName(GREEN+"Vendre Eponges");
    meta_sponge.setLore(sponge_lore);
    sponge.setItemMeta(meta_sponge);
    ItemStack cobweb = new ItemStack(Material.COBWEB);
    ArrayList<String> web_lore = new ArrayList<>();
    web_lore.add(AQUA+"Vendre "+GREEN+""+cobweb.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(cobweb.getType().toString()));
    ItemMeta web = cobweb.getItemMeta();
    web.setLore(web_lore);
    web.setDisplayName(GREEN+"Vendre Cobweb");
    cobweb.setItemMeta(web);
    ItemStack gold_block = new ItemStack(Material.GOLD_BLOCK);
    ArrayList<String> gold_lore = new ArrayList<>();
    gold_lore.add(AQUA+"Vendre "+GREEN+""+gold_block.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(gold_block.getType().toString()));
    ItemMeta gold_meta = gold_block.getItemMeta();
    gold_meta.setDisplayName(GREEN+"Vendre bloc d'or");
    gold_meta.setLore(gold_lore);
    gold_block.setItemMeta(gold_meta);
    ItemStack iron_block = new ItemStack(Material.IRON_BLOCK);
    ArrayList<String> iron_lore = new ArrayList<>();
    iron_lore.add(AQUA+"Vendre "+GREEN+""+iron_block.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(iron_block.getType().toString()));
    ItemMeta iron_meta = iron_block.getItemMeta();
    iron_meta.setLore(iron_lore);
    iron_meta.setDisplayName(GREEN+"Vendre bloc de fer");
    iron_block.setItemMeta(iron_meta);
    ItemStack brick = new ItemStack(Material.BRICK);
    ArrayList<String> brick_lore = new ArrayList<>();
    brick_lore.add(AQUA+"Vendre "+GREEN+""+brick.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(brick.getType().toString()));
    ItemMeta brick_meta = brick.getItemMeta();
    brick_meta.setDisplayName(GREEN+"Vendre bloc de briques");
    brick_meta.setLore(brick_lore);
    brick.setItemMeta(brick_meta);
    ItemStack bookshelf = new ItemStack(Material.BOOKSHELF);
    ArrayList<String> bookshelf_lore = new ArrayList<>();
    bookshelf_lore.add(AQUA+"Vendre "+GREEN+""+bookshelf.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(bookshelf.getType().toString()));
    ItemMeta book_meta = bookshelf.getItemMeta();
    book_meta.setLore(bookshelf_lore);
    book_meta.setDisplayName(GREEN+"Vendre des bibiliothèques");
    bookshelf.setItemMeta(book_meta);

    invt.setItem(0,sponge);
    invt.setItem(1,cobweb);
    invt.setItem(2,gold_block);
    invt.setItem(3,iron_block);
    invt.setItem(4,brick);
    invt.setItem(5,bookshelf);
    this.block_j2 = invt;

  }

  public void Block_J3(){
    Inventory invt = Bukkit.createInventory(null,27,ChatColor.GOLD+"Vente de block");
    ItemStack sponge = new ItemStack(Material.SPONGE);
    ArrayList<String> sponge_lore = new ArrayList<>();
    sponge_lore.add(AQUA+"Vendre "+GREEN+""+sponge.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(sponge.getType().toString()));
    ItemMeta meta_sponge = sponge.getItemMeta();
    meta_sponge.setDisplayName(GREEN+"Vendre Eponges");
    meta_sponge.setLore(sponge_lore);
    sponge.setItemMeta(meta_sponge);
    ItemStack cobweb = new ItemStack(Material.COBWEB);
    ArrayList<String> web_lore = new ArrayList<>();
    web_lore.add(AQUA+"Vendre "+GREEN+""+cobweb.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(cobweb.getType().toString()));
    ItemMeta web = cobweb.getItemMeta();
    web.setLore(web_lore);
    web.setDisplayName(GREEN+"Vendre Cobweb");
    cobweb.setItemMeta(web);
    ItemStack gold_block = new ItemStack(Material.GOLD_BLOCK);
    ArrayList<String> gold_lore = new ArrayList<>();
    gold_lore.add(AQUA+"Vendre "+GREEN+""+gold_block.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(gold_block.getType().toString()));
    ItemMeta gold_meta = gold_block.getItemMeta();
    gold_meta.setDisplayName(GREEN+"Vendre bloc d'or");
    gold_meta.setLore(gold_lore);
    gold_block.setItemMeta(gold_meta);
    ItemStack iron_block = new ItemStack(Material.IRON_BLOCK);
    ArrayList<String> iron_lore = new ArrayList<>();
    iron_lore.add(AQUA+"Vendre "+GREEN+""+iron_block.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(iron_block.getType().toString()));
    ItemMeta iron_meta = iron_block.getItemMeta();
    iron_meta.setLore(iron_lore);
    iron_meta.setDisplayName(GREEN+"Vendre bloc de fer");
    iron_block.setItemMeta(iron_meta);
    ItemStack brick = new ItemStack(Material.BRICK);
    ArrayList<String> brick_lore = new ArrayList<>();
    brick_lore.add(AQUA+"Vendre "+GREEN+""+brick.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(brick.getType().toString()));
    ItemMeta brick_meta = brick.getItemMeta();
    brick_meta.setDisplayName(GREEN+"Vendre bloc de briques");
    brick_meta.setLore(brick_lore);
    brick.setItemMeta(brick_meta);
    ItemStack bookshelf = new ItemStack(Material.BOOKSHELF);
    ArrayList<String> bookshelf_lore = new ArrayList<>();
    bookshelf_lore.add(AQUA+"Vendre "+GREEN+""+bookshelf.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(bookshelf.getType().toString()));
    ItemMeta book_meta = bookshelf.getItemMeta();
    book_meta.setLore(bookshelf_lore);
    book_meta.setDisplayName(GREEN+"Vendre des bibiliothèques");
    bookshelf.setItemMeta(book_meta);
    ItemStack magma = new ItemStack(Material.MAGMA_BLOCK);
    ArrayList<String> magma_lore = new ArrayList<>();
    magma_lore.add(AQUA+"Vendre "+GREEN+""+magma.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(magma.getType().toString()));
    ItemMeta magma_meta = magma.getItemMeta();
    magma_meta.setLore(magma_lore);
    magma_meta.setDisplayName(GREEN+"Vendre bloc de magma");
    magma.setItemMeta(magma_meta);
    ItemStack pumpkin = new ItemStack(Material.PUMPKIN);
    ArrayList<String> pumpkin_lore = new ArrayList<>();
    pumpkin_lore.add(AQUA+"Vendre "+GREEN+""+pumpkin.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(pumpkin.getType().toString()));
    ItemMeta pumpkin_meta = pumpkin.getItemMeta();
    pumpkin_meta.setDisplayName(GREEN+"Vendre des citrouilles");
    pumpkin.setItemMeta(pumpkin_meta);


    invt.setItem(0,sponge);
    invt.setItem(1,cobweb);
    invt.setItem(2,gold_block);
    invt.setItem(3,iron_block);
    invt.setItem(4,brick);
    invt.setItem(5,bookshelf);
    invt.setItem(6,magma);

  }


}
