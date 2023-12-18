package dao;

import config.Config;
import java.sql.*;

public class ComboBox_Dao {

    Connection con;

    public ComboBox_Dao() {
        con = Config.connectDB();
    }

    public int getDataById(String query, String column, String username) {
        ResultSet result = null;
        int id = 0;
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, username);
            result = ps.executeQuery();
            while (result.next()) {
                id = result.getInt(column);
            }
        } catch (SQLException e) {
            System.out.println("Error di comboBox: " + e.getMessage());
        }
        return id;
    }

    public int getDataById(String query, String username) {
        ResultSet result = null;
        int id = 0;
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, username);
            result = ps.executeQuery();
            return id = result.getInt("kode");
        } catch (SQLException e) {
            System.out.println("Error getSingle: " + e.getMessage());
        }
        return id;
    }

//    public int getIdByName(String query, String column, String username) {
//        ResultSet result = null;
//        int id = 0;
//        try (PreparedStatement ps = con.prepareStatement(query)) {
//            ps.setString(1, username);
//            result = ps.executeQuery();
//            return id = Integer.parseInt(result.getString(column));
//        } catch (SQLException e) {
//            System.out.println("Error getSingle: " + e.getMessage());
//        }
//        return id;
//    }
}
