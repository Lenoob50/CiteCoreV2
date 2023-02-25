package fr.cite.core;

import fr.cite.core.listeners.OnJoin;
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

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        //Déclaration de la classe principale
        instance = this;
        //Enregistrements des evenements relatifs au jeu
        pm.registerEvents(new OnJoin(),this);
        pm.registerEvents(new OnLeave(),this);
        //Ajout des options au fichier de configuration
        configuration.addDefault("msg.prefix",DARK_AQUA+""+BOLD+"Cite >>"+RESET);
        configuration.addDefault("options.welcome",false);
        configuration.addDefault("msg.welcome","%player_name% "+GREEN+" à rejoins la cité pour la première fois souhaitez lui la bienvenue");
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
}
