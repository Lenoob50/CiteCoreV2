package fr.cite.core;

import fr.cite.core.commands.CommandLeader;
import fr.cite.core.commands.CommandMoney;
import fr.cite.core.commands.CommandNPC;
import fr.cite.core.commands.CommandTeams;
import fr.cite.core.listeners.OnJoin;
import fr.cite.core.listeners.OnLeave;
import fr.cite.core.listeners.OnTalk;
import fr.cite.core.scoreboard.ScoreboardManager;
import fr.cite.core.tabcomplete.TabMoney;
import fr.cite.core.tabcomplete.TabNpc;
import fr.cite.core.tabcomplete.TabTeams;
import fr.cite.core.utils.DBCredentials;
import fr.cite.core.utils.DatabaseManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import static org.bukkit.ChatColor.*;

public class Main extends JavaPlugin {

    public PluginManager pm = Bukkit.getPluginManager();
    public static Main instance;
    public String prefix = getConfig().getString("msg.prefix");
    public FileConfiguration configuration = getConfig();
    private DatabaseManager databaseManager;
    private DBCredentials dbCredentials;
    public ScoreboardManager sm = new ScoreboardManager();
    public Scoreboard scoreboard;
    public Team Apolon;
    public Team Ares;
    public Team Poseidon;
    public Team Zeus;
    public Team Dionysos;
    public HashMap<UUID,Integer> argent = new HashMap();
    public HashMap<Integer,Integer> team_money = new HashMap<>();
    public SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
    public  Date date = new Date();

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
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                if(formatter.format(date).toString() == getConfig().getString("options.time.close") ){
                    for(Player players : Bukkit.getOnlinePlayers()){
                        if(!players.isOp()){
                            players.kickPlayer(prefix+" Le serveur réouvre à "+getConfig().getString("options.time.close"));
                        }
                    }
                    getServer().setWhitelist(true);
                }
                if(formatter.format(date).toString() == getConfig().getString("options.time.open") ){
                    getServer().setWhitelist(false);
                }
            }
        },20,20);
        //Déclaration de la classe principale
        instance = this;
        //Enregistrement des commmandes
        getCommand("npc").setExecutor(new CommandNPC());
        getCommand("npc").setTabCompleter(new TabNpc());
        getCommand("money").setExecutor(new CommandMoney());
        getCommand("money").setTabCompleter(new TabMoney());
        getCommand("leaderboard").setExecutor(new CommandLeader());
        getCommand("teams").setExecutor(new CommandTeams());
        getCommand("teams").setTabCompleter(new TabTeams());
        //Connexion à la base de donnée
        databaseManager = new DatabaseManager();
        //Enregistrements des evenements relatifs au jeu
        pm.registerEvents(new OnJoin(),this);
        pm.registerEvents(new OnLeave(),this);
        pm.registerEvents(new OnTalk(),this);
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
        configuration.addDefault("options.time.close.heure",2);
        configuration.addDefault("options.time.close.minutes",0);
        configuration.addDefault("options.time.close.secondes",0);
        configuration.addDefault("options.time.open.heure",10);
        configuration.addDefault("options.time.open.minutes",0);
        configuration.addDefault("options.time.open.secondes",0);
        //Génération du fichier de configuration
        configuration.options().copyDefaults(true);
        saveConfig();
        saveDefaultConfig();
        //Création des teams
        scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        //Creation de la team Apollon
        Apolon = scoreboard.registerNewTeam("Apollon");
        Apolon.setAllowFriendlyFire(true);
        Apolon.setDisplayName(GREEN+"");
        Apolon.setPrefix(GREEN+"Apollon ");
        //Creation de la team Arès
        Ares = scoreboard.registerNewTeam("Arès");
        Ares.setAllowFriendlyFire(true);
        Ares.setDisplayName(RED+"");
        Ares.setPrefix(RED+"Arès ");
        //Création de la team Poséidon
        Poseidon = scoreboard.registerNewTeam("Poséidon");
        Poseidon.setAllowFriendlyFire(true);
        Poseidon.setDisplayName(AQUA+"");
        Poseidon.setPrefix(AQUA+"Poséidon ");
        //Création de la team Zeus
        Zeus = scoreboard.registerNewTeam("Zeus");
        Zeus.setAllowFriendlyFire(true);
        Zeus.setDisplayName(GOLD+"");
        Zeus.setPrefix(GOLD+"Zeus ");
        //Création de la team Dionysos
        Dionysos = scoreboard.registerNewTeam("Dionysos");
        Dionysos.setAllowFriendlyFire(true);
        Dionysos.setPrefix(DARK_PURPLE+"");
        Dionysos.setPrefix(DARK_PURPLE+"Dionysos ");
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
