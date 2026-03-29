package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;

        try {
            // Load Oracle driver
            Class.forName("oracle.jdbc.OracleDriver");

            // Connect to Oracle DB
            con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "system",     // your DB username
                "1234"        // your DB password (change if needed)
            );

            System.out.println("Connected to Oracle DB");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}