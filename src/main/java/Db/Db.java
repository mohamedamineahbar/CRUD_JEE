package Db;
import java.sql.*;

public class Db {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "medamineahbar255364";
    private static final String URL = "jdbc:mysql://localhost:3306/biblio";
    private static Connection conn;

    public static Connection getConn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Charger le driver
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); // Connexion
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            conn = null;
        }
        return conn;
    }
}
