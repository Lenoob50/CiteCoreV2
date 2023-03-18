package fr.cite.core.scoreboard;

import eu.decentsoftware.holograms.api.DHAPI;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import fr.cite.core.Main;
import fr.cite.core.utils.SQLMethods;
import org.bukkit.*;
import org.bukkit.entity.Player;
import java.util.*;

import static org.bukkit.ChatColor.*;

public class Scoreboard {


    private ScoreboardManager scoreboardManager;
    public Scoreboard(ScoreboardManager scoreboardManager) {
        this.scoreboardManager = scoreboardManager;

    }


    public void game(Player player) {
        scoreboardManager.createBoard(player, fastBoard -> {
            fastBoard.updateTitle(GREEN+""+BOLD+"Cité");

            Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    Date date = new Date();
                    int secondes = date.getSeconds();
                    int minutes = date.getMinutes();
                    int heure = date.getHours();
                    if(heure == Main.getInstance().getConfig().getInt("options.time.close.heure")){
                        if(minutes == Main.getInstance().getConfig().getInt("options.time.close.minutes")){
                            if(secondes == Main.getInstance().getConfig().getInt("options.time.close.secondes")){
                                for(Player op : Bukkit.getOnlinePlayers()){
                                    if(!op.isOp()){
                                        op.kickPlayer(Main.getInstance().getPrefix()+" Le serveur est sous couvre-feu");
                                    }
                                }
                                Bukkit.setWhitelist(true);
                                Bukkit.setWhitelistEnforced(true);
                            }
                        }
                    }
                    if(heure == Main.getInstance().getConfig().getInt("options.time.open.heure")){
                        if(minutes == Main.getInstance().getConfig().getInt("options.time.open.minutes")){
                            if(secondes == Main.getInstance().getConfig().getInt("options.time.open.secondes")){
                                Bukkit.setWhitelist(false);
                                Bukkit.setWhitelistEnforced(false);
                            }
                        }
                    }
                    Hologram teamhologram = DHAPI.getHologram("Teams");
                    if(teamhologram != null){
                        ArrayList<String> lines = new ArrayList<>();
                        HashMap<String ,Integer > classment = SQLMethods.sortByValue(SQLMethods.doTeamClassement());
                        lines.add(ChatColor.GREEN+"Classement des équipes");
                        for(Map.Entry<String, Integer> mapentry : classment.entrySet()){
                            lines.add(ChatColor.AQUA+""+mapentry.getKey()+" : "+mapentry.getValue()+"\n");
                        }

                        DHAPI.setHologramLines(teamhologram, lines);
                    }

                    Hologram playersHologram = DHAPI.getHologram("Players");
                    if(playersHologram != null){
                        ArrayList<String> playerslines = new ArrayList<>();
                        HashMap<String ,Integer > playersclassment = SQLMethods.sortByValue(SQLMethods.doPlayerClassement());
                        playerslines.add(ChatColor.GREEN+"Classement des joueurs");
                        for(Map.Entry<String, Integer> mapentry : playersclassment.entrySet()){
                            playerslines.add(ChatColor.AQUA+""+mapentry.getKey()+" : "+mapentry.getValue()+"\n");
                        }

                        DHAPI.setHologramLines(playersHologram, playerslines);
                    }


                    if(Main.getInstance().Apolon.getEntries().contains(player.getDisplayName())){
                        SQLMethods.getTeamMoney(1);
                        if(Main.getInstance().team_money.get(1) == null){
                            fastBoard.updateLine(2,WHITE+"  0 Drachmes");
                        }else {
                            fastBoard.updateLine(2,WHITE+"  "+Main.getInstance().team_money.get(1)+" Drachmes");
                        }
                        fastBoard.updateLine(8,"  "+SQLMethods.placeInLeader().get("Apollon").toString()+"/"+SQLMethods.getTotalTeam());
                        fastBoard.updateLine(1,AQUA+"Apollon");
                    }else if(Main.getInstance().Ares.getEntries().contains(player.getDisplayName())){
                        SQLMethods.getTeamMoney(2);
                        if(Main.getInstance().team_money.get(2) == null){
                            fastBoard.updateLine(2,WHITE+"  0 Drachmes");
                        }else {
                            fastBoard.updateLine(2,WHITE+"  "+Main.getInstance().team_money.get(2)+" Drachmes");
                        }
                        fastBoard.updateLine(1,AQUA+"Arès");
                        fastBoard.updateLine(8,"  "+SQLMethods.placeInLeader().get("Arès").toString()+"/"+SQLMethods.getTotalTeam());
                    }else if(Main.getInstance().Dionysos.getEntries().contains(player.getDisplayName())){
                        SQLMethods.getTeamMoney(5);
                        if(Main.getInstance().team_money.get(5) == null){
                            fastBoard.updateLine(2,WHITE+"  0 Drachmes");
                        }else {
                            fastBoard.updateLine(2,WHITE+"  "+Main.getInstance().team_money.get(5)+" Drachmes");
                        }
                        fastBoard.updateLine(1,AQUA+"Dionysos");
                        fastBoard.updateLine(8,"  "+SQLMethods.placeInLeader().get("Dionysos").toString()+"/"+SQLMethods.getTotalTeam());
                    }else if(Main.getInstance().Poseidon.getEntries().contains(player.getDisplayName())){
                        SQLMethods.getTeamMoney(3);
                        if(Main.getInstance().team_money.get(3) == null){
                            fastBoard.updateLine(2,WHITE+"  0 Drachmes");
                        }else {
                            fastBoard.updateLine(2,WHITE+"  "+Main.getInstance().team_money.get(3)+" Drachmes");
                        }
                        fastBoard.updateLine(1,AQUA+"Poséidon");
                        fastBoard.updateLine(8,"  "+SQLMethods.placeInLeader().get("Poséidon").toString()+"/"+SQLMethods.getTotalTeam());
                    }else if(Main.getInstance().Zeus.getEntries().contains(player.getDisplayName())){
                        SQLMethods.getTeamMoney(4);
                        if(Main.getInstance().team_money.get(4)==null){
                            fastBoard.updateLine(2,WHITE+"  0 Drachmes");
                        }else {
                            fastBoard.updateLine(2,WHITE+"  "+Main.getInstance().team_money.get(4)+" Drachmes");
                        }
                        fastBoard.updateLine(1,AQUA+"Zeus");
                        fastBoard.updateLine(8,"  "+SQLMethods.placeInLeader().get("Zeus").toString()+"/"+SQLMethods.getTotalTeam());
                    }else{
                        fastBoard.updateLine(2,WHITE+"  0 Drachmes");
                        fastBoard.updateLine(1,AQUA+"No Team");
                        fastBoard.updateLine(8,"0/"+SQLMethods.getTotalTeam());
                    }
                    SQLMethods.getMoney(player);
                    if(Main.getInstance().argent.get(player.getUniqueId()) == null){
                        fastBoard.updateLine(5,WHITE+"  0 Drachmes");
                    }else {
                        fastBoard.updateLine(5,WHITE+"  "+ Main.getInstance().argent.get(player.getUniqueId())+" Drachmes");
                    }

                }
            },20,20);


            fastBoard.updateLines(
                    //0
                    WHITE+" ",
                    //1
                    AQUA+"No Team",
                    //2
                    WHITE+"  0 Drachmes",
                    //3
                    WHITE+" ",
                    //4
                    AQUA+""+player.getName(),
                    //5
                    WHITE+"  0 Drachmes",
                    //6
                    WHITE+ "",
                    //7
                    AQUA+"Classement ",
                    //8
                    WHITE +"   0/5"
            );
        });
    }



}

