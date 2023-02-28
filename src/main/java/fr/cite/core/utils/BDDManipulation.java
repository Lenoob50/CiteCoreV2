package fr.cite.core.utils;

import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BDDManipulation {

    // enregistre un nouveau joueur dans la bdd
    public static void registerPlayer(Player player)
    {
        if(!requeteSqlSelect("select player_id from core where core.player_id=" + player.getUniqueId() + ";", "player_id", false).contains(player.getUniqueId().toString()))
        {
            requeteSqlUpdate("insert into core values (null," + player.getUniqueId() + ", 'no team', " + player.getName() + ", 0, 0);");
        }
    }


    // ajoute une somme de Coins à préciser à un joueur
    public static void addCoins(Player player, int coins)
    {
        requeteSqlUpdate("update core set Coins=" + coins + " where Pseudo=\"" + player.getName() + "\"; ");
    }

    //ajoute l'appartment id_appart au joueur player
    public static void addAppart(Player player, int id_appart)
    {
        requeteSqlUpdate("update core set Appartmement=" + id_appart + " where Pseudo=\"" + player.getName() + "\";");
    }

    // permet d'obtenir les informations d'un joueur à partir de son ID
    public static String getJoueur(int ID)
    {
        String resultat;
        String requete = "select * from core where player_id ="+ID+";";

        resultat = toutRecup(requete);

        return resultat;
    }


    // permet d'obtenir les informations d'un joueur à partir de son pseudo
    public static String getJoueur(String pseudo)
    {
        String resultat;
        String requete = "select * from core where Pseudo =\""+pseudo+"\";";

        resultat = toutRecup(requete);

        return resultat;
    }


    // renvoi le pseudo associé à un ID
    public static String getNom(int ID)
    {
        String nom;
        String requete = "select Pseudo from core where player_id="+ID+";";

        nom = requeteSqlSelect(requete, "Pseudo", false);

        return nom;
    }

    // renvoi l'ID associé à un pseudo
    public static int getId(String nom)
    {
        int id;
        String requete = "select player_id from core where Pseudo=\""+nom+"\";";

        id = Integer.parseInt(requeteSqlSelect(requete, "player_id", true));

        return id;
    }


    // renvoi le montant de Coins possédé par un joueur
    public static int getMonnaie(String nom)
    {
        int argent;
        String requete = "select Coins from core where Pseudo=\""+nom+"\";";

        argent = Integer.parseInt(requeteSqlSelect(requete, "Coins", true));

        return argent;
    }





	/*--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 *  																																									   *
	 * 										                    FONCTIONS LIEES AUX REQUETTES SQL																			   *
	 * 																																										   *
	 --------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/


    // permet d'effectuer des requete SQL qui accèdent à la base de données (SELECT...)
    public static String requeteSqlSelect(String requete, String cle, boolean entier) //entier = false si vous voulez un String en resultat, true si vous voulez un entier
    {
        String resultat = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://node2.hogcraft.fr:3306/bdd_cite","titou","B7T6jXgdEtiyHqG7");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(requete);
            if(entier)
                while(rs.next()){
                    resultat += rs.getString(cle);
                }
            else{
                while(rs.next()){
                    resultat += rs.getString(cle) + "\n";
                }
            }

            con.close();
        }catch(Exception e){ System.out.println(e);}

        return resultat;
    }


    // permet d'effectuer des requette SQL qui modifient la base de donnée (UPDATE, INSERT INTO...)
    public static void requeteSqlUpdate(String requete)
    {
        String resultat = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://node2.hogcraft.fr:3306/bdd_cite","titou","B7T6jXgdEtiyHqG7");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            stmt.executeUpdate(requete);


            con.close();
        }catch(Exception e){ System.out.println(e);}
    }


    // permet de tout selectionner (comme *)
    public static String toutRecup(String requete)
    {
        String resultat = "";

        resultat += requeteSqlSelect(requete, "player_id", false);
        resultat += requeteSqlSelect(requete, "UUID", false);
        resultat += requeteSqlSelect(requete, "Team", false);
        resultat += requeteSqlSelect(requete, "Pseudo", false);
        resultat += requeteSqlSelect(requete, "Coins", false);
        resultat += requeteSqlSelect(requete, "Appartement", false);

        return resultat;
    }

}
