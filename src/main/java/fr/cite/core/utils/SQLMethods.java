package fr.cite.core.utils;

import eu.decentsoftware.holograms.api.DHAPI;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import eu.decentsoftware.holograms.api.holograms.HologramLine;
import fr.cite.core.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import java.security.SecureRandom;
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
    public static String team = "";
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

    public static void registerSite(Player player){
        String admin;
        if(player.isOp()){
            admin = "yes";
        } else {
            admin = "no";
        }
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < 10; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(),()->{
           try {
               PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dashboard ('username','password','admin') VALUE (?,?,?)");
               preparedStatement.setString(1,player.getName());
               preparedStatement.setString(2,sb.toString());
               preparedStatement.setString(3,admin.toString());
               preparedStatement.executeUpdate();
           }catch (SQLException e){
               e.printStackTrace();
           }
        });
    }

    public static String getPassword(Player player){
        final String[] password = {null};
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(),()->{
            try{
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT password FROM dashboard WHERE username = ?");
                preparedStatement.setString(1,player.getName());
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    password[0] = rs.getString("password");
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        });
        return password[0];
    }

    public static void addCoins(Player player, int coins){
        int ancien = getMoney(player);
        int nv = coins+ancien;
            try {
              PreparedStatement preparedStatement = connection.prepareStatement("UPDATE core SET coins = ? WHERE UUID = ?");
              preparedStatement.setInt(1,nv);
              preparedStatement.setString(2,player.getUniqueId().toString());
              preparedStatement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
    }

    public static int getMoney(Player player){
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
        return argent;
    }

    public static int classement(Team team){
        int classement = 0;
        return classement;
    }

    public static HashMap doTeamClassement(){
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

    public static HashMap doPlayerClassement(){
        HashMap<String,Integer> classement = new HashMap<String,Integer>();


        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Pseudo,Coins FROM core ORDER BY Coins ASC");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                classement.put(rs.getString("Pseudo"),rs.getInt("Coins"));

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

    public static String getPlayerTeam(Player player){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Team FROM core WHERE UUID = ?");
            preparedStatement.setString(1,player.getUniqueId().toString());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                team = rs.getString("Team");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return team;
    }

    public static HashMap<String, Integer> placeInLeader(){
        int place = 0;
        HashMap<String ,Integer> place_board = new HashMap();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name FROM team ORDER BY Coins DESC");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                place ++;
                place_board.put(resultSet.getString("name"),place);
            }
            place_board = sortByValue(place_board);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return place_board;
    }
    public static HashMap<String, Integer> teamLeader(String team_name){
        HashMap<String, Integer> place_board = new HashMap<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT name,coins FROM "+team_name+" ORDER BY "+team_name+".coins DESC");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                place_board.put(resultSet.getString("name"),resultSet.getInt("coins"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return place_board;
    }

    public static void addToTeam(String team, Player player){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO "+team+"(`uuid`, `name`, `coins`) VALUES (?,?,?)");
            preparedStatement.setString(1,player.getUniqueId().toString());
            preparedStatement.setString(2,player.getName());
            preparedStatement.setInt(3,getMoney(player));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addCoinsPerTeam(String team,Player player){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE "+team+" SET coins = ? WHERE uuid = ?");
            preparedStatement.setInt(1,getMoney(player));
            preparedStatement.setString(2,player.getUniqueId().toString());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public static int getTeamMoneyByName(String team_name){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT Coins FROM team WHERE name = ?");
                preparedStatement.setString(1,team_name);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    drachmes = rs.getInt("Coins");
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        return drachmes;
    }

    public static void addTeamCoins(int coins,Player player){
        int ancien = 0;
        if(Main.getInstance().Apolon.hasEntry(player.getDisplayName())){
            ancien = getTeamMoney(2);
            int nv = ancien+coins;
            Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(),()->{
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement("UPDATE team SET coins = ? WHERE id = ?");
                    preparedStatement.setInt(1,nv);
                    preparedStatement.setInt(2,2);
                    preparedStatement.executeUpdate();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            });
        }
        else if(Main.getInstance().Ares.hasEntry(player.getDisplayName())){
            ancien = getTeamMoney(1);
            int nv = ancien+coins;
            Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(),()->{
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement("UPDATE team SET coins = ? WHERE id = ?");
                    preparedStatement.setInt(1,nv);
                    preparedStatement.setInt(2,1);
                    preparedStatement.executeUpdate();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            });
        }
        else if(Main.getInstance().Poseidon.hasEntry(player.getDisplayName())){
            ancien = getTeamMoney(4);
            int nv = ancien+coins;
            Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(),()->{
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement("UPDATE team SET coins = ? WHERE id = ?");
                    preparedStatement.setInt(1,nv);
                    preparedStatement.setInt(2,4);
                    preparedStatement.executeUpdate();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            });
        }
        else if(Main.getInstance().Zeus.hasEntry(player.getDisplayName())){
            ancien = getTeamMoney(5);
            int nv = ancien+coins;

            Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(),()->{
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement("UPDATE team SET coins = ? WHERE id = ?");
                    preparedStatement.setInt(1,nv);
                    preparedStatement.setInt(2,5);
                    preparedStatement.executeUpdate();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            });
        }
        else if(Main.getInstance().Dionysos.hasEntry(player.getDisplayName())){
            ancien = getTeamMoney(3);
            int nv = ancien+coins;
            Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(),()->{
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement("UPDATE team SET coins = ? WHERE id = ?");
                    preparedStatement.setInt(1,nv);
                    preparedStatement.setInt(2,3);
                    preparedStatement.executeUpdate();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            });
        }


    }

    public static void addTeamMoney(String team_name,int coins){
        int ancien = getTeamMoneyByName(team_name);
        int nv = coins+ancien;
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(),()->{
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE team SET coins = ? WHERE name = ?");
                preparedStatement.setInt(1,nv);
                preparedStatement.setString(2,team_name);
                preparedStatement.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
        });
    }

    public static void removeToTeam(String team, Player player){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM "+team+" WHERE UUID = ?");
            preparedStatement.setString(1,player.getUniqueId().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
