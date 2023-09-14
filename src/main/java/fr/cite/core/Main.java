package fr.cite.core;

import fr.cite.core.commands.*;
import fr.cite.core.listeners.*;
import fr.cite.core.scoreboard.ScoreboardManager;
import fr.cite.core.tabcomplete.TabLead;
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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    public HashMap<Integer,String > defis = new HashMap<>();


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
        //D�claration de la classe principale
        instance = this;
        //Enregistrement des commmandes
        getCommand("npc").setExecutor(new CommandNPC());
        getCommand("npc").setTabCompleter(new TabNpc());
        getCommand("money").setExecutor(new CommandMoney());
        getCommand("money").setTabCompleter(new TabMoney());
        getCommand("leaderboard").setExecutor(new CommandLeader());
        getCommand("teams").setExecutor(new CommandTeams());
        getCommand("teams").setTabCompleter(new TabTeams());
        getCommand("lead").setExecutor(new CommandClassement());
        getCommand("lead").setTabCompleter(new TabLead());
        getCommand("teammoney").setTabCompleter(new TabTeams());
        getCommand("teammoney").setExecutor(new CommandTeamMoney());
        //Connexion � la base de donn�e
        databaseManager = new DatabaseManager();
        //Enregistrements des evenements relatifs au jeu
        pm.registerEvents(new OnJoin(),this);
        pm.registerEvents(new OnLeave(),this);
        pm.registerEvents(new OnTalk(),this);
        pm.registerEvents(new OnNPCClicked(),this);
        pm.registerEvents(new OnInventoryInterract(),this);
        pm.registerEvents(new OnNPCHurt(),this);
        //Ajout des options au fichier de configuration
        configuration.addDefault("msg.prefix",DARK_AQUA+""+BOLD+"Cite >>"+RESET);
        configuration.addDefault("options.welcome",false);
        configuration.addDefault("msg.welcome","%player_name% "+GREEN+" à rejoins la cité pour la première fois souhaitez lui la bienvenue");
        configuration.addDefault("mysql.host","host");
        configuration.addDefault("mysql.port",0000);
        configuration.addDefault("mysql.dbName","dbName");
        configuration.addDefault("mysql.user","dbUser");
        configuration.addDefault("mysql.password","password");
        configuration.addDefault("options.spawn.x",0);
        configuration.addDefault("options.spawn.y",105);
        configuration.addDefault("options.spawn.z",0);
        configuration.addDefault("options.time.close.heure",2);
        configuration.addDefault("options.time.close.minutes",0);
        configuration.addDefault("options.time.close.secondes",0);
        configuration.addDefault("options.time.open.heure",10);
        configuration.addDefault("options.time.open.minutes",0);
        configuration.addDefault("options.time.open.secondes",0);
        //G�n�ration du fichier de configuration
        configuration.options().copyDefaults(true);
        saveConfig();
        saveDefaultConfig();
        //Cr�ation des teams
        scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        //Creation de la team Apollon
        Apolon = scoreboard.registerNewTeam("Apollon");
        Apolon.setAllowFriendlyFire(true);
        Apolon.setDisplayName(GREEN+"");
        Apolon.setPrefix(GREEN+"Apollon ");
        if(!scoreboard.getTeams().contains("Apollon")){
            System.out.println("Création de la team Apollon effectué");
        }

        //Creation de la team Ar�s
        Ares = scoreboard.registerNewTeam("Ares");
        Ares.setAllowFriendlyFire(true);
        Ares.setDisplayName(RED+"");
        Ares.setPrefix(RED+"Arès ");
        if(!scoreboard.getTeams().contains("Arès")){
            System.out.println("Création de la team Arès effectué");
        }
        //Cr�ation de la team Pos�idon
        Poseidon = scoreboard.registerNewTeam("Poseidon");
        Poseidon.setAllowFriendlyFire(true);
        Poseidon.setDisplayName(AQUA+"");
        Poseidon.setPrefix(AQUA+"Poséidon ");
        if(!scoreboard.getTeams().contains("Poséidon")){
            System.out.println("Création de la team Poséidon effectué");
        }
        //Cr�ation de la team Zeus
        Zeus = scoreboard.registerNewTeam("Zeus");
        Zeus.setAllowFriendlyFire(true);
        Zeus.setDisplayName(GOLD+"");
        Zeus.setPrefix(GOLD+"Zeus ");
        if(!scoreboard.getTeams().contains("Zeus")){
            System.out.println("Création de la team Zeus effectué");
        }
        //Cr�ation de la team Dionysos
        Dionysos = scoreboard.registerNewTeam("Dionysos");
        Dionysos.setAllowFriendlyFire(true);
        Dionysos.setDisplayName(DARK_PURPLE+"");
        Dionysos.setPrefix(DARK_PURPLE+"Dionysos ");
        if(!scoreboard.getTeams().contains("Dionysos")){
            System.out.println("Création de la team Dionysos effectué");
        }
        System.out.println(scoreboard.getTeams().toArray());
        System.out.println(scoreboard.getTeams().size());

        for (Team team : scoreboard.getTeams()){
            System.out.println("Team : "+team.getName());
        }

        try {
            this.csvToMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
        defis.put(1,"Flower : Recupère 10 fleurs jaunes et ramène les moi");
        defis.put(2,"");
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

    public HashMap csvToMap() throws IOException{
        String csvFile = "./plugins/CiteCore/item.csv"; // Chemin vers le fichier CSV
        String line = "";
        String csvDelimiter = ","; // D�limiteur CSV
        HashMap hashMap = new HashMap<String,Integer>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // Diviser chaque ligne en colonnes en utilisant le d�limiteur CSV
                String[] values = line.split(csvDelimiter);

                // Stocker les valeurs dans la HashMap
                hashMap.put(values[0], values[1]);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashMap;
    }




}
