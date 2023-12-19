package dao;

import config.Config;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import services.Getter_Service;

public class Getter_Dao implements Getter_Service {

    Connection con = null;

    public Getter_Dao() {
        con = Config.connectDB();
    }

    public ResultSet getData(String query) {
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = con.createStatement();
            result = statement.executeQuery(query);
            return result;
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet getTotalData(String query) {
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = con.createStatement();
            result = statement.executeQuery(query);
            return result;
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
