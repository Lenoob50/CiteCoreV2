package fr.cite.core.utils;

import fr.cite.core.Main;
import java.sql.SQLException;

public class DatabaseManager {
    private final DbConnection dbConnection = new DbConnection(new DBCredentials(
            Main.getInstance().getConfig().getString("mysql.host"),
            Main.getInstance().getConfig().getString("mysql.user"),
            Main.getInstance().getConfig().getString("mysql.password"),
            Main.getInstance().getConfig().getString("mysql.dbName"),
            Main.getInstance().getConfig().getInt("mysql.port")));

    public DbConnection getDbConnection() {
        return this.dbConnection;
    }

    public void close() {
        try {
            this.dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
