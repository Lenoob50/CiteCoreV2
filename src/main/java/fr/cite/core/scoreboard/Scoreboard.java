package fr.cite.core.scoreboard;

import fr.cite.core.Main;
import fr.cite.core.utils.SQLMethods;
import org.bukkit.*;
import org.bukkit.entity.Player;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
                    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                    Date date = new Date();
                    if(formatter.format(date) == Main.getInstance().getConfig().getString("options.time.close") ){
                        Bukkit.broadcastMessage(Main.getInstance().getPrefix()+" Test de synchro");
                    }
                    if(formatter.format(date).toString() == Main.getInstance().getConfig().getString("options.time.open") ){
                        Main.getInstance().getServer().setWhitelist(false);
                    }
                    fastBoard.updateLine(10,AQUA+""+formatter.format(date));
                    if(Main.getInstance().Apolon.getEntries().contains(player.getDisplayName())){
                        SQLMethods.getTeamMoney(1);
                        if(Main.getInstance().team_money.get(1) == null){
                            fastBoard.updateLine(2,WHITE+"  0 Drachmes");
                        }else {
                            fastBoard.updateLine(2,WHITE+"  "+Main.getInstance().team_money.get(1)+" Drachmes");
                        }
                        fastBoard.updateLine(1,AQUA+"Apollon");
                    }else if(Main.getInstance().Ares.getEntries().contains(player.getDisplayName())){
                        SQLMethods.getTeamMoney(2);
                        if(Main.getInstance().team_money.get(2) == null){
                            fastBoard.updateLine(2,WHITE+"  0 Drachmes");
                        }else {
                            fastBoard.updateLine(2,WHITE+"  "+Main.getInstance().team_money.get(2)+" Drachmes");
                        }
                        fastBoard.updateLine(1,AQUA+"Arès");
                    }else if(Main.getInstance().Dionysos.getEntries().contains(player.getDisplayName())){
                        SQLMethods.getTeamMoney(5);
                        if(Main.getInstance().team_money.get(5) == null){
                            fastBoard.updateLine(2,WHITE+"  0 Drachmes");
                        }else {
                            fastBoard.updateLine(2,WHITE+"  "+Main.getInstance().team_money.get(5)+" Drachmes");
                        }
                        fastBoard.updateLine(1,AQUA+"Dionysos");
                    }else if(Main.getInstance().Poseidon.getEntries().contains(player.getDisplayName())){
                        SQLMethods.getTeamMoney(3);
                        if(Main.getInstance().team_money.get(3) == null){
                            fastBoard.updateLine(2,WHITE+"  0 Drachmes");
                        }else {
                            fastBoard.updateLine(2,WHITE+"  "+Main.getInstance().team_money.get(3)+" Drachmes");
                        }
                        fastBoard.updateLine(1,AQUA+"Poséidon");
                    }else if(Main.getInstance().Zeus.getEntries().contains(player.getDisplayName())){
                        SQLMethods.getTeamMoney(4);
                        if(Main.getInstance().team_money.get(4)==null){
                            fastBoard.updateLine(2,WHITE+"  0 Drachmes");
                        }else {
                            fastBoard.updateLine(2,WHITE+"  "+Main.getInstance().team_money.get(4)+" Drachmes");
                        }
                        fastBoard.updateLine(1,AQUA+"Zeus");
                    }else{
                        fastBoard.updateLine(2,WHITE+"  0 Drachmes");
                        fastBoard.updateLine(1,AQUA+"No Team");
                    }
                    SQLMethods.getMoney(player);
                    if(Main.getInstance().argent.get(player.getUniqueId()) == null){
                        fastBoard.updateLine(5,WHITE+"  0 Drachmes");
                    }else {
                        fastBoard.updateLine(5,WHITE+"  "+ Main.getInstance().argent.get(player.getUniqueId())+" Drachmes");
                    }
                    fastBoard.updateLine(12,AQUA+""+date.getSeconds());
                    fastBoard.updateLine(8,WHITE +"  0/"+SQLMethods.getTotalTeam());
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
                    WHITE +"   0/5",
                    //9
                    WHITE+ " ",
                    //10
                    AQUA+" ",
                    //11
                    WHITE+ " ",
                    //12
                    AQUA+""+Main.getInstance().getConfig().getString("options.time.close")
            );
        });
    }



}

