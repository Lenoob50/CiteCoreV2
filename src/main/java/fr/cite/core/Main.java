package fr.cite.core;

import fr.cite.core.commands.CommandNPC;
import fr.cite.core.listeners.OnJoin;
import fr.cite.core.listeners.OnLeave;
import fr.cite.core.utils.DatabaseManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import static org.bukkit.ChatColor.*;

public class Main extends JavaPlugin {

    public PluginManager pm = Bukkit.getPluginManager();
    public static Main instance;
    public String prefix = getConfig().getString("msg.prefix");
    public FileConfiguration configuration = getConfig();
    private DatabaseManager databaseManager;

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public void onDisable() {
        this.databaseManager.close();
        super.onDisable();
    }

    @Override
    public void onEnable() {
        //Enregistrement des commmandes
        getCommand("npc").setExecutor(new CommandNPC());
        //Connexion à la base de donnée
        databaseManager = new DatabaseManager();
        //Déclaration de la classe principale
        instance = this;
        //Enregistrements des evenements relatifs au jeu
        pm.registerEvents(new OnJoin(),this);
        pm.registerEvents(new OnLeave(),this);
        //Ajout des options au fichier de configuration
        configuration.addDefault("msg.prefix",DARK_AQUA+""+BOLD+"Cite >>"+RESET);
        configuration.addDefault("options.welcome",false);
        configuration.addDefault("msg.welcome","%player_name% "+GREEN+" à rejoins la cité pour la première fois souhaitez lui la bienvenue");
        configuration.addDefault("mysql.host","node2.hogcraft.fr");
        configuration.addDefault("mysql.port",3306);
        configuration.addDefault("mysql.dbName","bdd_cite");
        configuration.addDefault("mysql.user","bdd_cite");
        configuration.addDefault("mysql.password","qy4_-tC]t1m0-zX2");
        configuration.addDefault("options.spawn.x",0);
        configuration.addDefault("options.spawn.y",105);
        configuration.addDefault("options.spawn.z",0);
        //Génération du fichier de configuration
        configuration.options().copyDefaults(true);
        saveConfig();
        saveDefaultConfig();
        super.onEnable();
    }


    public static Main getInstance() {
        return instance;
    }

    public String getPrefix() {
        return prefix;
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }
}
