package fr.cite.core.utils;

import fr.cite.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class SQLMethods {

    public static DbConnection dbConnection = Main.getInstance().getDatabaseManager().getDbConnection();
    public static Connection connection;
    public static int argent = 0;
    public static ArrayList<String> var = new ArrayList<String>();
    public static int teams = 0;
    public static int drachmes = 0;

    static {
        try {
            connection = dbConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SQLMethods() throws SQLException {
    }


    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
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
                   Main.getInstance().argent.put(player.getUniqueId(),argent);
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


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name,Coins FROM team ORDER BY Coins ASC");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                classement.put(rs.getString("name"),rs.getInt("Coins"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classement;
    }

    public static int getTotalTeam(){
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(),()->{
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) AS 'Nombre de team' FROM team");
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    teams = rs.getInt("Nombre de team");
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        });
        return teams;
    }

    public static int getTeamMoney(int team_id){
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(),()->{
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT Coins FROM team WHERE id = ?");
                preparedStatement.setInt(1,team_id);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    drachmes = rs.getInt("Coins");
                    Main.getInstance().team_money.put(team_id,drachmes);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        });
        return drachmes;
    }

    public static void setTeams(Player player){
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(),()->{
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE core SET Team = ? WHERE UUID = ?");
                preparedStatement.setString(1,Main.getInstance().scoreboard.getEntryTeam(player.getName()).getName());
                preparedStatement.setString(2,player.getUniqueId().toString());
                preparedStatement.executeUpdate();
                }catch (SQLException e){
                e.printStackTrace();
            }
        });
    }


}
