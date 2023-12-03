package config;

import java.sql.*;

public class Config {

    public static Connection connectDB() throws SQLException {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:/D://sqlite//SIMAG.db");
            String query = "SELECT * FROM user";
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            System.out.println("Connection Successful");
            while(result.next()){
                System.out.println("name : " + result.getString("nama"));
            }
            con.close();
            return con;
        } catch(Exception e) {
            System.out.println("Connection Failed" + e.getMessage());
            return null;
        }finally{
            con.close();
        }
    }

    public static void main(String args[]) throws SQLException{
        connectDB();
    }
}
