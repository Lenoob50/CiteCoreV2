package fr.cite.core.utils;

import fr.cite.core.Main;
import javafx.scene.chart.BubbleChart;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLMethods {

    public static DbConnection dbConnection = Main.getInstance().getDatabaseManager().getDbConnection();
    public static Connection connection;

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
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(),()->{
            try {
              PreparedStatement preparedStatement = connection.prepareStatement("UPDATE core SET coins = ? WHERE UUID = ?");
              preparedStatement.setInt(1,coins);
              preparedStatement.setString(2,player.getUniqueId().toString());
              preparedStatement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
        });
    }

    public static int getMoney(Player player){
        final int[] coins = {0};
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(),()->{
           try {
               PreparedStatement preparedStatement = connection.prepareStatement("SELECT coins FROM core WHERE UUID = ?");
               preparedStatement.setString(1,player.getUniqueId().toString());
               ResultSet rs = preparedStatement.executeQuery();
               while (rs.next()){
                   coins[0] = rs.getInt("Coins");
               }
           }catch (SQLException e){
               e.printStackTrace();
           }
        });
        return coins[0];
    }


}
