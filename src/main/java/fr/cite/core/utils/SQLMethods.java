package fr.cite.core.utils;

import fr.cite.core.Main;
import javafx.scene.chart.BubbleChart;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class SQLMethods {

    public static DbConnection dbConnection = Main.getInstance().getDatabaseManager().getDbConnection();
    public static Connection connection;
    public static int argent = 0;
    public static String test = "";

    static {
        try {
            connection = dbConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SQLMethods() throws SQLException {
    }

    public static void registerPlayer(Player player){
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(),()->{
           try {
               PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `core`(`UUID`, `Team`, `Pseudo`, `Coins`, `Appartement`) VALUES (?,'No Team',?,0,0)");
               preparedStatement.setString(1,player.getUniqueId().toString());
               preparedStatement.setString(2, player.getName());
               preparedStatement.executeUpdate();
           }catch (SQLException e){
               e.printStackTrace();
           }
        });
    }

    public static void addCoins(Player player, int coins){
        int ancien = getMoney(player);
        int nv = coins+ancien;
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(),()->{
            try {
              PreparedStatement preparedStatement = connection.prepareStatement("UPDATE core SET coins = ? WHERE UUID = ?");
              preparedStatement.setInt(1,nv);
              preparedStatement.setString(2,player.getUniqueId().toString());
              preparedStatement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
        });
    }

    public static int getMoney(Player player){

        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(),()->{
           try {
               PreparedStatement preparedStatement = connection.prepareStatement("SELECT coins FROM core WHERE UUID = ?");
               preparedStatement.setString(1,player.getUniqueId().toString());
               ResultSet rs = preparedStatement.executeQuery();
               while (rs.next()){
                   argent = rs.getInt("Coins");
               }
           }catch (SQLException e){
               e.printStackTrace();
           }
        });
        return argent;
    }

    public static int classement(Team team){
        int classement = 0;
        return classement;
    }

    public static HashMap doClassement(){
        HashMap<String,Integer> classement = new HashMap<String,Integer>();
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(),()->{
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT name,Coins FROM team ORDER BY Coins");
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    classement.put(rs.getString("name"),rs.getInt("Coins"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        return classement;
    }

    public static String test(){

        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(),()->{
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT name,Coins FROM team ORDER BY Coins");
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    test = rs.getString("name");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        return test;
    }


}
