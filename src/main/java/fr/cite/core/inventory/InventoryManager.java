package fr.cite.core.inventory;

import java.util.ArrayList;

import fr.cite.core.utils.SQLMethods;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import static org.bukkit.ChatColor.*;

public class InventoryManager {
  public Inventory Banque;
  public Inventory Team;
  public Inventory mario;

  public Inventory block_j1;
  public Inventory block_j2;
  public Inventory block_j3;
  public Inventory block_j4;
  public Inventory block_j5;

  public Inventory food_j1;
  public Inventory food_j2;
  public Inventory food_j3;
  public Inventory food_j4;
  public Inventory food_j5;

  public Inventory divers_j1;
  public Inventory divers_j2;
  public Inventory divers_j3;
  public Inventory divers_j4;
  public Inventory divers_j5;

  public Inventory ressource_j1;
  public Inventory ressource_j2;
  public Inventory ressource_j3;
  public Inventory ressource_j4;
  public Inventory ressource_j5;

  public Inventory ItemJ1;
  public Inventory ItemJ2;
  public Inventory ItemJ3;
  public Inventory ItemJ4;
  public Inventory ItemJ5;
  public Inventory Black_Market;

  public InventoryManager() {
    Banque();
    Team();
    Mario();
    Block_J1();
    Block_J2();
    Block_J3();
    Block_J4();
    Block_J5();
    food_j1();
    food_j2();
    food_j3();
    food_j4();
    food_j5();
    divers_j1();
    divers_j2();
    divers_j3();
    divers_j4();
    divers_j5();
    ressource_j1();
    ressource_j2();
    ressource_j3();
    ressource_j4();
    ressource_j5();
    ItemJ1();
    ItemJ2();
    ItemJ3();
    ItemJ4();
    ItemJ5();
    Black_Market();
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
    lore.add("§28 Gold");
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
    ItemStack melon = new ItemStack(Material.MELON);
    ArrayList<String> melon_lore = new ArrayList<>();
    melon_lore.add(AQUA+"Vendre "+GREEN+""+melon.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(melon.getType().toString()));
    ItemMeta melon_meta = melon.getItemMeta();
    melon_meta.setLore(melon_lore);
    melon_meta.setDisplayName(GREEN+"Vendre du melon");
    melon.setItemMeta(melon_meta);

    invt.setItem(0,sponge);
    invt.setItem(1,cobweb);
    invt.setItem(2,gold_block);
    invt.setItem(3,iron_block);
    invt.setItem(4,brick);
    invt.setItem(5,bookshelf);
    invt.setItem(6,magma);
    invt.setItem(7,pumpkin);
    invt.setItem(8,melon);
    this.block_j3 = invt;

  }

  public void Block_J4(){
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
    ItemStack melon = new ItemStack(Material.MELON);
    ArrayList<String> melon_lore = new ArrayList<>();
    melon_lore.add(AQUA+"Vendre "+GREEN+""+melon.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(melon.getType().toString()));
    ItemMeta melon_meta = melon.getItemMeta();
    melon_meta.setLore(melon_lore);
    melon_meta.setDisplayName(GREEN+"Vendre du melon");
    melon.setItemMeta(melon_meta);
    ItemStack mycellium = new ItemStack(Material.MYCELIUM);
    ArrayList<String> mycellium_lore = new ArrayList<>();
    mycellium_lore.add(AQUA+"Vendre "+GREEN+""+mycellium.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(mycellium.getType().toString()));
    ItemMeta mycellium_meta = mycellium.getItemMeta();
    mycellium_meta.setDisplayName(GREEN+"Vendre du mycellium");
    mycellium.setItemMeta(mycellium_meta);
    ItemStack nether_brick = new ItemStack(Material.NETHER_BRICK);
    ArrayList<String> nt_brick_lore = new ArrayList<>();
    nt_brick_lore.add(AQUA+"Vendre "+GREEN+""+nether_brick.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(nether_brick.getType().toString()));
    ItemMeta nether_meta = nether_brick.getItemMeta();
    nether_meta.setDisplayName(GREEN+"Vendre nether brick");
    nether_meta.setLore(nt_brick_lore);
    nether_brick.setItemMeta(nether_meta);
    ItemStack cauldron = new ItemStack(Material.CAULDRON);
    ArrayList<String> cauldron_lore = new ArrayList<>();
    cauldron_lore.add(AQUA+"Vendre "+GREEN+""+cauldron.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(cauldron.getType().toString()));
    ItemMeta cauldron_meta = cauldron.getItemMeta();
    cauldron_meta.setLore(cauldron_lore);
    cauldron_meta.setDisplayName(GREEN+"Vendre Chaudron");
    cauldron.setItemMeta(cauldron_meta);


    invt.setItem(0,sponge);
    invt.setItem(1,cobweb);
    invt.setItem(2,gold_block);
    invt.setItem(3,iron_block);
    invt.setItem(4,brick);
    invt.setItem(5,bookshelf);
    invt.setItem(6,magma);
    invt.setItem(7,pumpkin);
    invt.setItem(8,melon);
    invt.setItem(9,mycellium);
    invt.setItem(10,nether_brick);
    invt.setItem(11,cauldron);
    this.block_j4 = invt;
  }

  public void Block_J5(){
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
    ItemStack melon = new ItemStack(Material.MELON);
    ArrayList<String> melon_lore = new ArrayList<>();
    melon_lore.add(AQUA+"Vendre "+GREEN+""+melon.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(melon.getType().toString()));
    ItemMeta melon_meta = melon.getItemMeta();
    melon_meta.setLore(melon_lore);
    melon_meta.setDisplayName(GREEN+"Vendre du melon");
    melon.setItemMeta(melon_meta);
    ItemStack mycellium = new ItemStack(Material.MYCELIUM);
    ArrayList<String> mycellium_lore = new ArrayList<>();
    mycellium_lore.add(AQUA+"Vendre "+GREEN+""+mycellium.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(mycellium.getType().toString()));
    ItemMeta mycellium_meta = mycellium.getItemMeta();
    mycellium_meta.setDisplayName(GREEN+"Vendre du mycellium");
    mycellium.setItemMeta(mycellium_meta);
    ItemStack nether_brick = new ItemStack(Material.NETHER_BRICK);
    ArrayList<String> nt_brick_lore = new ArrayList<>();
    nt_brick_lore.add(AQUA+"Vendre "+GREEN+""+nether_brick.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(nether_brick.getType().toString()));
    ItemMeta nether_meta = nether_brick.getItemMeta();
    nether_meta.setDisplayName(GREEN+"Vendre nether brick");
    nether_meta.setLore(nt_brick_lore);
    nether_brick.setItemMeta(nether_meta);
    ItemStack cauldron = new ItemStack(Material.CAULDRON);
    ArrayList<String> cauldron_lore = new ArrayList<>();
    cauldron_lore.add(AQUA+"Vendre "+GREEN+""+cauldron.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(cauldron.getType().toString()));
    ItemMeta cauldron_meta = cauldron.getItemMeta();
    cauldron_meta.setLore(cauldron_lore);
    cauldron_meta.setDisplayName(GREEN+"Vendre Chaudron");
    cauldron.setItemMeta(cauldron_meta);
    ItemStack beacon = new ItemStack(Material.BEACON);
    ArrayList<String> beacon_lore = new ArrayList<>();
    beacon_lore.add(AQUA+"Vendre "+GREEN+""+beacon.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(beacon.getType().toString()));
    ItemMeta beacon_meta = beacon.getItemMeta();
    beacon_meta.setLore(beacon_lore);
    beacon_meta.setDisplayName(GREEN+"Vendre Beacon");
    beacon.setItemMeta(beacon_meta);
    ItemStack terracotta = new ItemStack(Material.TERRACOTTA);
    ArrayList<String> terracotta_lore = new ArrayList<>();
    terracotta_lore.add(AQUA+"Vendre "+GREEN+""+terracotta.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(terracotta.getType().toString()));
    ItemMeta terracotta_meta = terracotta.getItemMeta();
    terracotta_meta.setDisplayName(GREEN+"Vendre terracotta");
    terracotta_meta.setLore(terracotta_lore);
    terracotta.setItemMeta(terracotta_meta);
    ItemStack quartz = new ItemStack(Material.QUARTZ_BLOCK);
    ArrayList<String> quart_lore = new ArrayList<>();
    quart_lore.add(AQUA+"Vendre "+GREEN+""+quartz.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(quartz.getType().toString()));
    ItemMeta quartz_meta = quartz.getItemMeta();
    quartz_meta.setLore(quart_lore);
    quartz_meta.setDisplayName(GREEN+"Vendre bloc de Quartz");
    quartz.setItemMeta(quartz_meta);
    ItemStack hay_bale = new ItemStack(Material.HAY_BLOCK);
    ArrayList<String> hay_lore = new ArrayList<>();
    hay_lore.add(AQUA+"Vendre "+GREEN+""+hay_bale.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(hay_bale.getType().toString()));
    ItemMeta hay_meta = hay_bale.getItemMeta();
    hay_meta.setLore(hay_lore);
    hay_meta.setDisplayName(GREEN+"Vendre bloc de blé");
    hay_bale.setItemMeta(hay_meta);
    ItemStack purpur = new ItemStack(Material.PURPUR_BLOCK);
    ArrayList<String> purpur_lore = new ArrayList<>();
    purpur_lore.add(AQUA+"Vendre "+GREEN+""+quartz.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(quartz.getType().toString()));
    ItemMeta purpur_meta = purpur.getItemMeta();
    purpur_meta.setDisplayName(GREEN+"Vendre bloc de Purpur");
    purpur_meta.setLore(purpur_lore);
    purpur.setItemMeta(purpur_meta);


    invt.setItem(0,sponge);
    invt.setItem(1,cobweb);
    invt.setItem(2,gold_block);
    invt.setItem(3,iron_block);
    invt.setItem(4,brick);
    invt.setItem(5,bookshelf);
    invt.setItem(6,magma);
    invt.setItem(7,pumpkin);
    invt.setItem(8,melon);
    invt.setItem(9,mycellium);
    invt.setItem(10,nether_brick);
    invt.setItem(11,cauldron);
    invt.setItem(12,beacon);
    invt.setItem(13,terracotta);
    invt.setItem(14,quartz);
    invt.setItem(15,hay_bale);
    invt.setItem(16,purpur);
    this.block_j5 = invt;
  }

  public void food_j1(){
    ArrayList<String> list = SQLMethods.getItemList(17,20);
    Inventory invt = Bukkit.createInventory(null,27,ChatColor.GOLD+"Vente de Nourriture");
    for(String itemList : list ){
      ItemStack item = new ItemStack(Material.valueOf(itemList),1);
      ArrayList<String> lore = new ArrayList<>();
      lore.add(AQUA+"Vendre "+GREEN+""+item.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(item.getType().toString())+AQUA+" drachmes");
      ItemMeta itemMeta = item.getItemMeta();
      itemMeta.setLore(lore);
      itemMeta.setDisplayName(GREEN+"Vendre "+item.getType());
      item.setItemMeta(itemMeta);
      invt.addItem(item);
    }
    this.food_j1 = invt;
  }

  public void food_j2(){
    ArrayList<String> list = SQLMethods.getItemList(17,24);
    Inventory invt = Bukkit.createInventory(null,27,ChatColor.GOLD+"Vente de Nourriture");
    for(String itemList : list ){
      ItemStack item = new ItemStack(Material.valueOf(itemList),1);
      ArrayList<String> lore = new ArrayList<>();
      lore.add(AQUA+"Vendre "+GREEN+""+item.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(item.getType().toString())+AQUA+" drachmes");
      ItemMeta itemMeta = item.getItemMeta();
      itemMeta.setLore(lore);
      itemMeta.setDisplayName(GREEN+"Vendre "+item.getType());
      item.setItemMeta(itemMeta);
      invt.addItem(item);
    }
    this.food_j2 = invt;
  }

  public void food_j3(){
    ArrayList<String> list = SQLMethods.getItemList(17,28);
    Inventory invt = Bukkit.createInventory(null,27,ChatColor.GOLD+"Vente de Nourriture");
    for(String itemList : list ){
      ItemStack item = new ItemStack(Material.valueOf(itemList),1);
      ArrayList<String> lore = new ArrayList<>();
      lore.add(AQUA+"Vendre "+GREEN+""+item.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(item.getType().toString())+AQUA+" drachmes");
      ItemMeta itemMeta = item.getItemMeta();
      itemMeta.setLore(lore);
      itemMeta.setDisplayName(GREEN+"Vendre "+item.getType());
      item.setItemMeta(itemMeta);
      invt.addItem(item);
    }
    this.food_j3 = invt;
  }

  public void food_j4(){
    ArrayList<String> list = SQLMethods.getItemList(17,32);
    Inventory invt = Bukkit.createInventory(null,27,ChatColor.GOLD+"Vente de Nourriture");
    for(String itemList : list ){
      ItemStack item = new ItemStack(Material.valueOf(itemList),1);
      ArrayList<String> lore = new ArrayList<>();
      lore.add(AQUA+"Vendre "+GREEN+""+item.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(item.getType().toString())+AQUA+" drachmes");
      ItemMeta itemMeta = item.getItemMeta();
      itemMeta.setLore(lore);
      itemMeta.setDisplayName(GREEN+"Vendre "+item.getType());
      item.setItemMeta(itemMeta);
      invt.addItem(item);
    }
    this.food_j4 = invt;
  }

  public void food_j5(){
    ArrayList<String> list = SQLMethods.getItemList(17,38);
    Inventory invt = Bukkit.createInventory(null,27,ChatColor.GOLD+"Vente de Nourriture");
    for(String itemList : list ){
      ItemStack item = new ItemStack(Material.valueOf(itemList),1);
      ArrayList<String> lore = new ArrayList<>();
      lore.add(AQUA+"Vendre "+GREEN+""+item.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(item.getType().toString())+AQUA+" drachmes");
      ItemMeta itemMeta = item.getItemMeta();
      itemMeta.setLore(lore);
      itemMeta.setDisplayName(GREEN+"Vendre "+item.getType());
      item.setItemMeta(itemMeta);
      invt.addItem(item);
    }
    this.food_j5 = invt;
  }

  public void divers_j1(){
    ArrayList<String> list = SQLMethods.getItemList(39,40);
    Inventory invt = Bukkit.createInventory(null,27,ChatColor.GOLD+"Vente d'item divers");
    for(String itemList : list ){
      ItemStack item = new ItemStack(Material.valueOf(itemList),1);
      ArrayList<String> lore = new ArrayList<>();
      lore.add(AQUA+"Vendre "+GREEN+""+item.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(item.getType().toString())+AQUA+" drachmes");
      ItemMeta itemMeta = item.getItemMeta();
      itemMeta.setLore(lore);
      itemMeta.setDisplayName(GREEN+"Vendre "+item.getType());
      item.setItemMeta(itemMeta);
      invt.addItem(item);
    }
    this.divers_j1 = invt;
  }

  public void divers_j2(){
    ArrayList<String> list = SQLMethods.getItemList(39,41);
    Inventory invt = Bukkit.createInventory(null,27,ChatColor.GOLD+"Vente d'item divers");
    for(String itemList : list ){
      ItemStack item = new ItemStack(Material.valueOf(itemList),1);
      ArrayList<String> lore = new ArrayList<>();
      lore.add(AQUA+"Vendre "+GREEN+""+item.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(item.getType().toString())+AQUA+" drachmes");
      ItemMeta itemMeta = item.getItemMeta();
      itemMeta.setLore(lore);
      itemMeta.setDisplayName(GREEN+"Vendre "+item.getType());
      item.setItemMeta(itemMeta);
      invt.addItem(item);
    }
    this.divers_j2 = invt;
  }

  public void divers_j3(){
    ArrayList<String> list = SQLMethods.getItemList(39,42);
    Inventory invt = Bukkit.createInventory(null,27,ChatColor.GOLD+"Vente d'item divers");
    for(String itemList : list ){
      ItemStack item = new ItemStack(Material.valueOf(itemList),1);
      ArrayList<String> lore = new ArrayList<>();
      lore.add(AQUA+"Vendre "+GREEN+""+item.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(item.getType().toString())+AQUA+" drachmes");
      ItemMeta itemMeta = item.getItemMeta();
      itemMeta.setLore(lore);
      itemMeta.setDisplayName(GREEN+"Vendre "+item.getType());
      item.setItemMeta(itemMeta);
      invt.addItem(item);
    }
    this.divers_j3 = invt;
  }

  public void divers_j4(){
    ArrayList<String> list = SQLMethods.getItemList(39,43);
    Inventory invt = Bukkit.createInventory(null,27,ChatColor.GOLD+"Vente d'item divers");
    for(String itemList : list ){
      ItemStack item = new ItemStack(Material.valueOf(itemList),1);
      ArrayList<String> lore = new ArrayList<>();
      lore.add(AQUA+"Vendre "+GREEN+""+item.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(item.getType().toString())+AQUA+" drachmes");
      ItemMeta itemMeta = item.getItemMeta();
      itemMeta.setLore(lore);
      itemMeta.setDisplayName(GREEN+"Vendre "+item.getType());
      item.setItemMeta(itemMeta);
      invt.addItem(item);
    }
    this.divers_j4 = invt;
  }

  public void divers_j5(){
    ArrayList<String> list = SQLMethods.getItemList(39,46);
    Inventory invt = Bukkit.createInventory(null,27,ChatColor.GOLD+"Vente d'item divers");
    for(String itemList : list ){
      ItemStack item = new ItemStack(Material.valueOf(itemList),1);
      ArrayList<String> lore = new ArrayList<>();
      lore.add(AQUA+"Vendre "+GREEN+""+item.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(item.getType().toString())+AQUA+" drachmes");
      ItemMeta itemMeta = item.getItemMeta();
      itemMeta.setLore(lore);
      itemMeta.setDisplayName(GREEN+"Vendre "+item.getType());
      item.setItemMeta(itemMeta);
      invt.addItem(item);
    }
    this.divers_j5 = invt;
  }

  public void ressource_j1(){
    ArrayList<String> list = SQLMethods.getItemList(51,56);
    Inventory invt = Bukkit.createInventory(null,36,ChatColor.GOLD+"Vente de ressources");
    for(String itemList : list ){
      ItemStack item = new ItemStack(Material.valueOf(itemList),1);
      ArrayList<String> lore = new ArrayList<>();
      lore.add(AQUA+"Vendre "+GREEN+""+item.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(item.getType().toString())+AQUA+" drachmes");
      ItemMeta itemMeta = item.getItemMeta();
      itemMeta.setLore(lore);
      itemMeta.setDisplayName(GREEN+"Vendre "+item.getType());
      item.setItemMeta(itemMeta);
      invt.addItem(item);
    }
    this.ressource_j1 = invt;
  }

  public void ressource_j2(){
    ArrayList<String> list = SQLMethods.getItemList(51,61);
    Inventory invt = Bukkit.createInventory(null,36,ChatColor.GOLD+"Vente de ressources");
    for(String itemList : list ){
      ItemStack item = new ItemStack(Material.valueOf(itemList),1);
      ArrayList<String> lore = new ArrayList<>();
      lore.add(AQUA+"Vendre "+GREEN+""+item.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(item.getType().toString())+AQUA+" drachmes");
      ItemMeta itemMeta = item.getItemMeta();
      itemMeta.setLore(lore);
      itemMeta.setDisplayName(GREEN+"Vendre "+item.getType());
      item.setItemMeta(itemMeta);
      invt.addItem(item);
    }
    this.ressource_j2 = invt;
  }

  public void ressource_j3(){
    ArrayList<String> list = SQLMethods.getItemList(51,66);
    Inventory invt = Bukkit.createInventory(null,36,ChatColor.GOLD+"Vente de ressources");
    for(String itemList : list ){
      ItemStack item = new ItemStack(Material.valueOf(itemList),1);
      ArrayList<String> lore = new ArrayList<>();
      lore.add(AQUA+"Vendre "+GREEN+""+item.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(item.getType().toString())+AQUA+" drachmes");
      ItemMeta itemMeta = item.getItemMeta();
      itemMeta.setLore(lore);
      itemMeta.setDisplayName(GREEN+"Vendre "+item.getType());
      item.setItemMeta(itemMeta);
      invt.addItem(item);
    }
    this.ressource_j3 = invt;
  }

  public void ressource_j4(){
    ArrayList<String> list = SQLMethods.getItemList(51,71);
    Inventory invt = Bukkit.createInventory(null,36,ChatColor.GOLD+"Vente de ressources");
    for(String itemList : list ){
      ItemStack item = new ItemStack(Material.valueOf(itemList),1);
      ArrayList<String> lore = new ArrayList<>();
      lore.add(AQUA+"Vendre "+GREEN+""+item.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(item.getType().toString())+AQUA+" drachmes");
      ItemMeta itemMeta = item.getItemMeta();
      itemMeta.setLore(lore);
      itemMeta.setDisplayName(GREEN+"Vendre "+item.getType());
      item.setItemMeta(itemMeta);
      invt.addItem(item);
    }
    this.ressource_j4 = invt;
  }

  public void ressource_j5(){
    ArrayList<String> list = SQLMethods.getItemList(51,76);
    Inventory invt = Bukkit.createInventory(null,36,ChatColor.GOLD+"Vente de ressources");
    for(String itemList : list ){
      ItemStack item = new ItemStack(Material.valueOf(itemList),1);
      ArrayList<String> lore = new ArrayList<>();
      lore.add(AQUA+"Vendre "+GREEN+""+item.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(item.getType().toString())+AQUA+" drachmes");
      ItemMeta itemMeta = item.getItemMeta();
      itemMeta.setLore(lore);
      itemMeta.setDisplayName(GREEN+"Vendre "+item.getType());
      item.setItemMeta(itemMeta);
      invt.addItem(item);
    }
    this.ressource_j5 = invt;
  }

  public void ItemJ1(){
    ArrayList<String> list = SQLMethods.getItemList(77,82);
    Inventory invt = Bukkit.createInventory(null,27,ChatColor.GOLD+"Vente d'Item");
    for(String itemList : list ){
      ItemStack item = new ItemStack(Material.valueOf(itemList),1);
      ArrayList<String> lore = new ArrayList<>();
      lore.add(AQUA+"Vendre "+GREEN+""+item.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(item.getType().toString())+AQUA+" drachmes");
      ItemMeta itemMeta = item.getItemMeta();
      itemMeta.setLore(lore);
      itemMeta.setDisplayName(GREEN+"Vendre "+item.getType());
      item.setItemMeta(itemMeta);
      invt.addItem(item);
    }
    this.ItemJ1 = invt;
  }

  public void ItemJ2(){
    ArrayList<String> list = SQLMethods.getItemList(77,86);
    Inventory invt = Bukkit.createInventory(null,27,ChatColor.GOLD+"Vente d'Item");
    for(String itemList : list ){
      ItemStack item = new ItemStack(Material.valueOf(itemList),1);
      ArrayList<String> lore = new ArrayList<>();
      lore.add(AQUA+"Vendre "+GREEN+""+item.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(item.getType().toString())+AQUA+" drachmes");
      ItemMeta itemMeta = item.getItemMeta();
      itemMeta.setLore(lore);
      itemMeta.setDisplayName(GREEN+"Vendre "+item.getType());
      item.setItemMeta(itemMeta);
      invt.addItem(item);
    }
    this.ItemJ2 = invt;
  }

  public void ItemJ3(){
    ArrayList<String> list = SQLMethods.getItemList(77,91);
    Inventory invt = Bukkit.createInventory(null,27,ChatColor.GOLD+"Vente d'Item");
    for(String itemList : list ){
      ItemStack item = new ItemStack(Material.valueOf(itemList),1);
      ArrayList<String> lore = new ArrayList<>();
      lore.add(AQUA+"Vendre "+GREEN+""+item.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(item.getType().toString())+AQUA+" drachmes");
      ItemMeta itemMeta = item.getItemMeta();
      itemMeta.setLore(lore);
      itemMeta.setDisplayName(GREEN+"Vendre "+item.getType());
      item.setItemMeta(itemMeta);
      invt.addItem(item);
    }
    this.ItemJ3 = invt;
  }

  public void ItemJ4(){
    ArrayList<String> list = SQLMethods.getItemList(77,95);
    Inventory invt = Bukkit.createInventory(null,27,ChatColor.GOLD+"Vente d'Item");
    for(String itemList : list ){
      ItemStack item = new ItemStack(Material.valueOf(itemList),1);
      ArrayList<String> lore = new ArrayList<>();
      lore.add(AQUA+"Vendre "+GREEN+""+item.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(item.getType().toString())+AQUA+" drachmes");
      ItemMeta itemMeta = item.getItemMeta();
      itemMeta.setLore(lore);
      itemMeta.setDisplayName(GREEN+"Vendre "+item.getType());
      item.setItemMeta(itemMeta);
      invt.addItem(item);
    }
    this.ItemJ4 = invt;
  }

  public void ItemJ5(){
    ArrayList<String> list = SQLMethods.getItemList(77,99);
    Inventory invt = Bukkit.createInventory(null,27,ChatColor.GOLD+"Vente d'Item");
    for(String itemList : list ){
      ItemStack item = new ItemStack(Material.valueOf(itemList),1);
      ArrayList<String> lore = new ArrayList<>();
      lore.add(AQUA+"Vendre "+GREEN+""+item.getType()+AQUA+" pour "+GREEN+""+ SQLMethods.getPrice(item.getType().toString())+AQUA+" drachmes");
      ItemMeta itemMeta = item.getItemMeta();
      itemMeta.setLore(lore);
      itemMeta.setDisplayName(GREEN+"Vendre "+item.getType());
      item.setItemMeta(itemMeta);
      invt.addItem(item);
    }
    this.ItemJ5 = invt;
  }

  public void Black_Market(){
    ArrayList<String> list = SQLMethods.getBlackMarket();
    Inventory invt = Bukkit.createInventory(null,27, DARK_PURPLE+"Marché Noir");
    for(String itemList : list){
      ItemStack item = new ItemStack(Material.valueOf(itemList),1);
      int price = (int) (SQLMethods.getPrice(item.getType().toString())*1.1);
      ArrayList<String> lore = new ArrayList<>();
      lore.add(AQUA+"Vendre "+GREEN+""+item.getType()+AQUA+" pour "+GREEN+""+price+AQUA+" drachmes");
      ItemMeta itemMeta = item.getItemMeta();
      itemMeta.setLore(lore);
      itemMeta.setDisplayName(GREEN+"Vendre "+item.getType());
      item.setItemMeta(itemMeta);
      invt.addItem(item);
    }
    this.Black_Market = invt;
  }



}
