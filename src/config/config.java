package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author rafli
 */
public class config {
    
    public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:D:/sqlite/SIMAG.db");
            System.out.println("Connection Successful");
            return con;
        } catch(Exception e) {
            System.out.println("Connection Failed" + e.getMessage());
            return null;
        }
    }
    
    public static void main(String args[]){
        connectDB();
    }
}
