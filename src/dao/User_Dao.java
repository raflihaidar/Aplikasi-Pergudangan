package dao;

import config.Config;
import helper.UserQueries;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import model.User;
import services.Login_Service;
import services.Register_Service;
import services.User_Service;

public class User_Dao implements User_Service, Login_Service, Register_Service {

    private Connection con;
    private User user;

    public User_Dao() {
        con = Config.connectDB();
        user = new User();
    }

    public User_Dao(String username, String password) {
        con = Config.connectDB();
        user = new User(username, password);
    }

    public User_Dao(String password) {
        con = Config.connectDB();
        user = new User(password);
    }

    @Override
    public List<User> getSingleData(String username) {
        List<User> data = new ArrayList<>();
        ResultSet result = null;
        try (PreparedStatement ps = con.prepareStatement(UserQueries.SELECT_SINGLE_USER)) {
            ps.setString(1, username);
            result = ps.executeQuery();
            while (result.next()) {
                user.setId(result.getInt("id"));
                user.setUsername(result.getString("username"));
                user.setFullName(String.valueOf(result.getString("nama")));
                user.setNoHp(result.getString("no_hp"));
                user.setEmail(String.valueOf(result.getString("email")));
                user.setAlamat(result.getString("alamat"));
                user.setTglAktif(result.getString("tgl_aktif"));
                user.setKodeJabatan(result.getInt("kode_jabatan"));
                user.setKodeStatus(result.getInt("status_kode"));
                data.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Error getSingle: " + e.getMessage());
        }

        return data;
    }

    @Override
    public void addData(User user) {
        try (PreparedStatement ps = con.prepareStatement(UserQueries.INSERT_USER)) {
            ps.setString(1, user.getFullName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getKodeGender());
            ps.setInt(5, user.getKodeJabatan());
            ps.setInt(6, 1);
            ps.execute();
        } catch (Exception e) {
            System.out.println("Error add ?:" + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateData(User user) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(UserQueries.UPDATE_USER);
            ps.setString(1, user.getFullName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getNoHp());
            ps.setString(5, user.getAlamat());
            ps.setInt(6, user.getKodeStatus());
            ps.setInt(7, user.getKodeJabatan());
            ps.setInt(8, user.getId());

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Update successful!");
            } else {
                System.out.println("No rows updated.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteData(String username) {
        try {
            PreparedStatement ps = con.prepareStatement(UserQueries.DELETE_USER);
            ps.setString(1, username);
            ps.executeUpdate();
            con.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error delete : " + e.getMessage());
        }
    }

    @Override
    public void updateAuthentication(int bool) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(UserQueries.IS_AUTHENTICATED);
            ps.setInt(1, bool);
            ps.setString(2, user.getUsername());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updateAuh:" + e.getMessage());
        } finally {
            if (ps != null) {
                try {
                    con.close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean authentication() {
        ResultSet rs = null;
        System.out.println(user.getUsername());
        try (PreparedStatement ps = con.prepareStatement(UserQueries.SEARCH_USER)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            System.out.println("username : " + user.getUsername());
            rs = ps.executeQuery();
            if (rs.next()) {
                rs.close();
                return true;
            } else {
                updateAuthentication(0);
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error di sini : " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean isValidPassword() {
        // Memeriksa panjang minimal
        if (user.getPassword().length() < 8) {
            return false;
        }

        // Memeriksa keberadaan angka
        if (!user.getPassword().matches(".*\\d.*")) {
            return false;
        }

        // Memeriksa keberadaan huruf besar
        if (!user.getPassword().matches(".*[A-Z].*")) {
            return false;
        }
        return true;
    }

    @Override
    public int getIdByStatus() {
        ResultSet result = null;
        int id = 0;
        try (PreparedStatement ps = con.prepareStatement(UserQueries.SELECT_DATA_BY_STATUS)) {
            result = ps.executeQuery();
            while(result.next()){
                id = result.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return id;
    }
}
