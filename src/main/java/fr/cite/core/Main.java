package fr.cite.core;

import fr.cite.core.listeners.OnJoin;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

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
        //Ajout des options au fichier de configuration
        configuration.addDefault("msg.prefix","&3&lCité&r");
        configuration.addDefault("options.welcome",false);
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
        prefix.replaceAll("&","§");
        return prefix;
    }
}
