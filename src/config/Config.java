package config;

import java.sql.*;

public class Config {

    public static Connection connectDB(){
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:D://Belajar Java//Aplikasi-Pergudangan//src//config/SIMAG.db");
          
            //punya alam
//             con = DriverManager.getConnection("jdbc:sqlite:C://Users//ACER//Documents//NetBeansProjects//Aplikasi-Pergudangan/SIMAG.db");
//             System.out.println("connection successful");
            return con;
        } catch(Exception e) {
            System.out.println("Connection Failed " + e.getMessage());
            return null;
        }
    }

    public static void main(String args[]) throws SQLException{
        connectDB();
    }
}
