package fr.cite.core;

import fr.cite.core.commands.CommandBroadcast;
import fr.cite.core.commands.CommandClassement;
import fr.cite.core.commands.CommandLB;
import fr.cite.core.commands.CommandLeader;
import fr.cite.core.commands.CommandMoney;
import fr.cite.core.commands.CommandNPC;
import fr.cite.core.commands.CommandRes;
import fr.cite.core.commands.CommandSite;
import fr.cite.core.commands.CommandTeamMoney;
import fr.cite.core.commands.CommandTeams;
import fr.cite.core.listeners.OnInventoryInterract;
import fr.cite.core.listeners.OnJoin;
import fr.cite.core.listeners.OnLBBreak;
import fr.cite.core.listeners.OnLeave;
import fr.cite.core.listeners.OnNPCClicked;
import fr.cite.core.listeners.OnNPCHurt;
import fr.cite.core.listeners.OnSignClicked;
import fr.cite.core.listeners.OnTalk;
import fr.cite.core.scoreboard.ScoreboardManager;
import fr.cite.core.tabcomplete.ResTab;
import fr.cite.core.tabcomplete.TabLead;
import fr.cite.core.tabcomplete.TabMoney;
import fr.cite.core.tabcomplete.TabNpc;
import fr.cite.core.tabcomplete.TabTeams;
import fr.cite.core.utils.DBCredentials;
import fr.cite.core.utils.DatabaseManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

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

    public HashMap<UUID, Integer> argent = new HashMap<>();

    public HashMap<Integer, Integer> team_money = new HashMap<>();

    public HashMap<Integer, String> defis = new HashMap<>();

    public HashMap<Integer, String> event = new HashMap<>();

    public void onLoad() {
        super.onLoad();
    }

    public void onDisable() {
        this.databaseManager.close();
        super.onDisable();
    }

    public void onEnable() {
        instance = this;
        getCommand("npc").setExecutor(new CommandNPC());
        getCommand("npc").setTabCompleter(new TabNpc());
        getCommand("money").setExecutor(new CommandMoney());
        getCommand("money").setTabCompleter(new TabMoney());
        getCommand("leaderboard").setExecutor(new CommandLeader());
        getCommand("teams").setExecutor(new CommandTeams());
        getCommand("teams").setTabCompleter(new TabTeams());
        getCommand("lead").setExecutor((CommandExecutor)new CommandClassement());
        getCommand("lead").setTabCompleter(new TabLead());
        getCommand("teammoney").setTabCompleter(new TabTeams());
        getCommand("teammoney").setExecutor(new CommandTeamMoney());
        getCommand("bc").setExecutor(new CommandBroadcast());
        getCommand("site").setExecutor(new CommandSite());
        getCommand("lb").setExecutor(new CommandLB());
        getCommand("residence").setExecutor(new CommandRes());
        getCommand("residence").setTabCompleter(new ResTab());
        this.databaseManager = new DatabaseManager();
        this.pm.registerEvents(new OnJoin(), this);
        this.pm.registerEvents((Listener)new OnLeave(), this);
        this.pm.registerEvents((Listener)new OnTalk(), this);
        this.pm.registerEvents((Listener)new OnNPCClicked(), this);
        this.pm.registerEvents(new OnInventoryInterract(), this);
        this.pm.registerEvents((Listener)new OnNPCHurt(), this);
        this.pm.registerEvents((Listener)new OnSignClicked(), this);
        this.pm.registerEvents((Listener)new OnLBBreak(), this);
        this.configuration.addDefault("msg.prefix", ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Cite >>" + ChatColor.RESET);
        this.configuration.addDefault("options.welcome", Boolean.valueOf(false));
        this.configuration.addDefault("msg.welcome", "%player_name% " + ChatColor.GREEN + " rejoins la citpour la premifois souhaitez lui la bienvenue");
        this.configuration.addDefault("mysql.host", "host");
        this.configuration.addDefault("mysql.port", Integer.valueOf(0));
        this.configuration.addDefault("mysql.dbName", "dbName");
        this.configuration.addDefault("mysql.user", "dbUser");
        this.configuration.addDefault("mysql.password", "password");
        this.configuration.addDefault("options.spawn.x", Integer.valueOf(0));
        this.configuration.addDefault("options.spawn.y", Integer.valueOf(105));
        this.configuration.addDefault("options.spawn.z", Integer.valueOf(0));
        this.configuration.addDefault("options.time.close.heure", Integer.valueOf(2));
        this.configuration.addDefault("options.time.close.minutes", Integer.valueOf(0));
        this.configuration.addDefault("options.time.close.secondes", Integer.valueOf(0));
        this.configuration.addDefault("options.time.open.heure", Integer.valueOf(10));
        this.configuration.addDefault("options.time.open.minutes", Integer.valueOf(0));
        this.configuration.addDefault("options.time.open.secondes", Integer.valueOf(0));
        this.configuration.addDefault("options.site.url", "http://localhost:80");
        this.configuration.addDefault("options.jour", Integer.valueOf(0));
        this.configuration.addDefault("event.jour1", "Ouverture");
        this.configuration.addDefault("event.jour2", "Build Battle");
        this.configuration.addDefault("event.jour3", "Bingo");
        this.configuration.addDefault("event.jour4", "Triathlon");
        this.configuration.addDefault("event.jour5", "Jump & Fermeture");
        this.configuration.options().copyDefaults(true);
        saveConfig();
        saveDefaultConfig();
        this.event.put(Integer.valueOf(1), this.configuration.getString("event.jour1"));
        this.event.put(Integer.valueOf(2), this.configuration.getString("event.jour2"));
        this.event.put(Integer.valueOf(3), this.configuration.getString("event.jour3"));
        this.event.put(Integer.valueOf(4), this.configuration.getString("event.jour4"));
        this.event.put(Integer.valueOf(5), this.configuration.getString("event.jour5"));
        this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        this.Apolon = this.scoreboard.registerNewTeam("Apollon");
        this.Apolon.setAllowFriendlyFire(true);
        this.Apolon.setDisplayName(ChatColor.GREEN + "");
        this.Apolon.setPrefix(ChatColor.GREEN + "Apollon ");
        if (!this.scoreboard.getTeams().contains("Apollon"))
            System.out.println("Création de la team Apollon effectué");
        this.Ares = this.scoreboard.registerNewTeam("Ares");
        this.Ares.setAllowFriendlyFire(true);
        this.Ares.setDisplayName(ChatColor.RED + "");
        this.Ares.setPrefix(ChatColor.RED + "Arès");
        if (!this.scoreboard.getTeams().contains("Arès"))
                System.out.println("Création de la team Arès effectué");
        this.Poseidon = this.scoreboard.registerNewTeam("Poseidon");
        this.Poseidon.setAllowFriendlyFire(true);
        this.Poseidon.setDisplayName(ChatColor.AQUA + "");
        this.Poseidon.setPrefix(ChatColor.AQUA + "Poséidon");
        if (!this.scoreboard.getTeams().contains("Poséidon"))
                System.out.println("Création de la team Poséidon effectué");
        this.Zeus = this.scoreboard.registerNewTeam("Zeus");
        this.Zeus.setAllowFriendlyFire(true);
        this.Zeus.setDisplayName(ChatColor.GOLD + "");
        this.Zeus.setPrefix(ChatColor.GOLD + "Zeus ");
        if (!this.scoreboard.getTeams().contains("Zeus"))
            System.out.println("Création de la team Zeus effectué");
        this.Dionysos = this.scoreboard.registerNewTeam("Dionysos");
        this.Dionysos.setAllowFriendlyFire(true);
        this.Dionysos.setDisplayName(ChatColor.DARK_PURPLE + "");
        this.Dionysos.setPrefix(ChatColor.DARK_PURPLE + "Dionysos ");
        if (!this.scoreboard.getTeams().contains("Dionysos"))
            System.out.println("Création de la team Dionysos effectué");
        try {
            csvToMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.defis.put(Integer.valueOf(1), "Flower : Recupére 10 fleurs jaunes et ramène les moi");
        this.defis.put(Integer.valueOf(2), "");
        super.onEnable();
    }

    public static Main getInstance() {
        return instance;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public DatabaseManager getDatabaseManager() {
        return this.databaseManager;
    }

    public HashMap csvToMap() throws IOException {
        String csvFile = "./plugins/CiteCore/item.csv";
        String line = "";
        String csvDelimiter = ",";
        HashMap<Object, Object> hashMap = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            try {
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(csvDelimiter);
                    hashMap.put(values[0], values[1]);
                }
                br.close();
            } catch (Throwable throwable) {
                try {
                    br.close();
                } catch (Throwable throwable1) {
                    throwable.addSuppressed(throwable1);
                }
                throw throwable;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashMap;
    }
}
