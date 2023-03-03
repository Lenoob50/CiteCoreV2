package fr.cite.core.scoreboard;

import fr.cite.core.Main;
import fr.cite.core.utils.SQLMethods;
import org.bukkit.*;
import org.bukkit.entity.Player;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

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
                    fastBoard.updateLine(2,WHITE+"  0 Drachmes");
                    fastBoard.updateLine(5,WHITE+"  "+ SQLMethods.getMoney(player)+" Drachmes");
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
                    WHITE +"   0/8",
                    //9
                    WHITE+ " "
            );
        });
    }



}

