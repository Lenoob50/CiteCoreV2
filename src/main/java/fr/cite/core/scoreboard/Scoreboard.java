package fr.cite.core.scoreboard;

import eu.decentsoftware.holograms.api.DHAPI;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import fr.cite.core.Main;
import fr.cite.core.utils.SQLMethods;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Scoreboard {
  private final ScoreboardManager scoreboardManager;
  
  public Scoreboard(ScoreboardManager scoreboardManager) {
    this.scoreboardManager = scoreboardManager;
  }
  
  public void game(final Player player) {
    this.scoreboardManager.createBoard(player, fastBoard -> {
          fastBoard.updateTitle(ChatColor.GREEN + "" + ChatColor.BOLD + "Cité Divine");
          Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
                public void run() {
                  Hologram teamhologram = DHAPI.getHologram("Teams");
                  if (teamhologram != null) {
                    ArrayList<String> lines = new ArrayList<>();
                    HashMap<String, Integer> classment = SQLMethods.sortByValue(SQLMethods.doTeamClassement());
                    lines.add(ChatColor.GREEN + "Classement des équipes");
                    for (Map.Entry<String, Integer> mapentry : classment.entrySet())
                      lines.add(ChatColor.AQUA + mapentry.getKey() + " : " + mapentry.getValue() + "\n");
                    DHAPI.setHologramLines(teamhologram, lines);
                  } 
                  Hologram playersHologram = DHAPI.getHologram("Players");
                  if (playersHologram != null) {
                    ArrayList<String> playerslines = new ArrayList<>();
                    HashMap<String, Integer> playersclassment = SQLMethods.sortByValue(SQLMethods.doPlayerClassement());
                    playerslines.add(ChatColor.GREEN + "Classement des joueurs");
                    for (Map.Entry<String, Integer> mapentry : playersclassment.entrySet())
                      playerslines.add(ChatColor.AQUA + mapentry.getKey() + " : " + mapentry.getValue() + "\n");
                    DHAPI.setHologramLines(playersHologram, playerslines);
                  }
                  if ((Main.getInstance()).Apolon.getEntries().contains(player.getDisplayName())) {
                    SQLMethods.getTeamMoney(2);
                    if ((Main.getInstance()).team_money.get(Integer.valueOf(2)) == null) {
                      fastBoard.updateLine(2, ChatColor.WHITE + "  0 Drachmes");
                    } else {
                      if(Main.getInstance().getConfig().getInt("options.jour")==5){
                        fastBoard.updateLine(2, ChatColor.MAGIC + "  " + (Main.getInstance()).team_money.get(Integer.valueOf(2)) +ChatColor.WHITE + " Drachmes");
                      }else {
                        fastBoard.updateLine(2, ChatColor.WHITE + "  " + (Main.getInstance()).team_money.get(Integer.valueOf(2)) + " Drachmes");
                      }
                    } 
                    if(Main.getInstance().getConfig().getInt("options.jour")==5){
                      fastBoard.updateLine(8, ChatColor.MAGIC+"  " + SQLMethods.placeInLeader().get("Apollon").toString() + "/" + SQLMethods.getTotalTeam());
                    }else {
                      fastBoard.updateLine(8, "  " + SQLMethods.placeInLeader().get("Apollon").toString() + "/" + SQLMethods.getTotalTeam());
                    }
                    fastBoard.updateLine(1, ChatColor.AQUA + "Apollon");
                  } else if ((Main.getInstance()).Ares.getEntries().contains(player.getDisplayName())) {
                    SQLMethods.getTeamMoney(1);
                    if ((Main.getInstance()).team_money.get(Integer.valueOf(1)) == null) {
                      fastBoard.updateLine(2, ChatColor.WHITE + "  0 Drachmes");
                    } else {
                      if(Main.getInstance().getConfig().getInt("options.jour")==5){
                        fastBoard.updateLine(2, ChatColor.MAGIC + "  " + (Main.getInstance()).team_money.get(Integer.valueOf(1)) +ChatColor.WHITE + " Drachmes");
                      }else {
                        fastBoard.updateLine(2, ChatColor.WHITE + "  " + (Main.getInstance()).team_money.get(Integer.valueOf(1)) + " Drachmes");
                      }
                    } 
                    fastBoard.updateLine(1, ChatColor.AQUA + "Arès");
                    if(Main.getInstance().getConfig().getInt("options.jour")==5){
                      fastBoard.updateLine(8, ChatColor.MAGIC+"  " + SQLMethods.placeInLeader().get("Ares").toString() + "/" + SQLMethods.getTotalTeam());
                    }else {
                      fastBoard.updateLine(8, ChatColor.WHITE+"  " + SQLMethods.placeInLeader().get("Ares").toString() + "/" + SQLMethods.getTotalTeam());
                    }
                  } else if ((Main.getInstance()).Dionysos.getEntries().contains(player.getDisplayName())) {
                    SQLMethods.getTeamMoney(3);
                    if ((Main.getInstance()).team_money.get(Integer.valueOf(3)) == null) {
                      fastBoard.updateLine(2, ChatColor.WHITE + "  0 Drachmes");
                    } else {
                      if(Main.getInstance().getConfig().getInt("options.jour")==5){
                        fastBoard.updateLine(2, ChatColor.MAGIC + "  " + (Main.getInstance()).team_money.get(Integer.valueOf(3)) +ChatColor.WHITE +" Drachmes");
                      }
                      else {
                        fastBoard.updateLine(2, ChatColor.WHITE + "  " + (Main.getInstance()).team_money.get(Integer.valueOf(3)) + " Drachmes");
                      }
                    } 
                    fastBoard.updateLine(1, ChatColor.AQUA + "Dionysos");
                    if(Main.getInstance().getConfig().getInt("options.jour")==5){
                      fastBoard.updateLine(8, ChatColor.MAGIC+"  " + SQLMethods.placeInLeader().get("Dionysos").toString() + "/" + SQLMethods.getTotalTeam());
                    }else {
                      fastBoard.updateLine(8, "  " + SQLMethods.placeInLeader().get("Dionysos").toString() + "/" + SQLMethods.getTotalTeam());
                    }

                  } else if ((Main.getInstance()).Poseidon.getEntries().contains(player.getDisplayName())) {
                    SQLMethods.getTeamMoney(4);
                    if ((Main.getInstance()).team_money.get(Integer.valueOf(4)) == null) {
                      fastBoard.updateLine(2, ChatColor.WHITE + "  0 Drachmes");
                    } else {
                      if(Main.getInstance().getConfig().getInt("options.jour")==5){
                        fastBoard.updateLine(2, ChatColor.MAGIC + "  " + (Main.getInstance()).team_money.get(Integer.valueOf(4)) +ChatColor.WHITE + " Drachmes");
                      }else {
                        fastBoard.updateLine(2, ChatColor.WHITE + "  " + (Main.getInstance()).team_money.get(Integer.valueOf(4)) + " Drachmes");
                      }
                    } 
                    fastBoard.updateLine(1, ChatColor.AQUA + "Poséidon");
                    if(Main.getInstance().getConfig().getInt("options.jour")==5){
                      fastBoard.updateLine(8, ChatColor.MAGIC+"  " + SQLMethods.placeInLeader().get("Poséidon").toString() + "/" + SQLMethods.getTotalTeam());
                    }else {
                      fastBoard.updateLine(8, "  " + SQLMethods.placeInLeader().get("Poséidon").toString() + "/" + SQLMethods.getTotalTeam());
                    }
                  } else if ((Main.getInstance()).Zeus.getEntries().contains(player.getDisplayName())) {
                    SQLMethods.getTeamMoney(5);
                    if ((Main.getInstance()).team_money.get(Integer.valueOf(5)) == null) {
                      fastBoard.updateLine(2, ChatColor.WHITE + "  0 Drachmes");
                    } else {
                      if(Main.getInstance().getConfig().getInt("options.jour")==5){
                        fastBoard.updateLine(2, ChatColor.MAGIC + "  " + (Main.getInstance()).team_money.get(Integer.valueOf(5)) +ChatColor.WHITE + " Drachmes");
                      }else {
                        fastBoard.updateLine(2, ChatColor.WHITE + "  " + (Main.getInstance()).team_money.get(Integer.valueOf(5)) + " Drachmes");
                      }
                    } 
                    fastBoard.updateLine(1, ChatColor.AQUA + "Zeus");
                    if(Main.getInstance().getConfig().getInt("options.jour")==5){
                      fastBoard.updateLine(8, ChatColor.MAGIC+"  " + SQLMethods.placeInLeader().get("Zeus").toString() + "/" + SQLMethods.getTotalTeam());
                    }else {
                      fastBoard.updateLine(8, "  " + SQLMethods.placeInLeader().get("Zeus").toString() + "/" + SQLMethods.getTotalTeam());
                    }
                  } else {
                    fastBoard.updateLine(2, ChatColor.WHITE + "  0 Drachmes");
                    fastBoard.updateLine(1, ChatColor.AQUA + "No Team");
                    fastBoard.updateLine(8, "   0/" + SQLMethods.getTotalTeam());
                  } 
                  SQLMethods.getMoney(player);
                  if ((Main.getInstance()).argent.get(player.getUniqueId()) == null) {
                    fastBoard.updateLine(5, ChatColor.WHITE + "  0 Drachmes");
                  } else {
                    if(Main.getInstance().getConfig().getInt("options.jour")==5){
                      fastBoard.updateLine(5, ChatColor.MAGIC + "  " + (Main.getInstance()).argent.get(player.getUniqueId())+ChatColor.WHITE + " Drachmes");
                    }else {
                      fastBoard.updateLine(5, ChatColor.WHITE + "  " + (Main.getInstance()).argent.get(player.getUniqueId()) + " Drachmes");
                    }
                  } 
                  if (Main.getInstance().getConfig().getInt("options.jour") > 0 && Main.getInstance().getConfig().getInt("options.jour") <= 5)
                    fastBoard.updateLine(11, "   " + (Main.getInstance()).event.get(Integer.valueOf(Main.getInstance().getConfig().getInt("options.jour"))));
                }
              },20, 20);
          fastBoard.updateLines(
                  ChatColor.WHITE + " ",
                  ChatColor.AQUA + "No Team",
                  ChatColor.WHITE + "  0 Drachmes",
                  ChatColor.WHITE + " ",
                  ChatColor.AQUA + player.getName(),
                  ChatColor.WHITE + "  0 Drachmes",
                  ChatColor.WHITE + "",
                  ChatColor.AQUA + "Classement ",
                  ChatColor.WHITE + "   0/5",
                  ChatColor.WHITE + "",
                  ChatColor.AQUA + "Event du jour ",
                  ChatColor.WHITE + "   None");
        });
  }
}
