package fr.cite.core.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DbConnection {
    private final DBCredentials dbCredentials;

    private Connection connection;

    public DbConnection(DBCredentials dbCredentials) {
        this.dbCredentials = dbCredentials;
        connect();
    }

    private void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(this.dbCredentials.toURI(), this.dbCredentials.getUser(), this.dbCredentials.getPass());
            Logger.getLogger("Minecraft").info("Successfully connected to Database");
        } catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void close() throws SQLException {
        if (this.connection != null &&
                !this.connection.isClosed())
            this.connection.close();
    }

    public Connection getConnection() throws SQLException {
        if (this.connection != null &&
                !this.connection.isClosed())
            return this.connection;
        connect();
        return this.connection;
    }
}
