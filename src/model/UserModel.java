package model;

import config.Config;
import helper.BarangQueries;
import helper.UserQueries;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import view.Register;

public class UserModel {

    private String username;
    private String password;
    private String fullName;
    private boolean status;
    private String gender;
    private String role;

    public UserModel(Register register) {
        this.fullName = register.getTxtFullName();
        this.username = register.getTxtUserName();
        this.password = register.getTxtPassword();
        this.gender = (String) register.getCmbGender();
        this.role = (String) register.getCmbRole();
    }

    public UserModel() {
    }

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserModel(String username) {
        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String username) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public boolean isValidPassword() {
        // Memeriksa panjang minimal
        if (this.password.length() < 8) {
            return false;
        }

        // Memeriksa keberadaan angka
        if (!this.password.matches(".*\\d.*")) {
            return false;
        }

        // Memeriksa keberadaan huruf besar
        if (!this.password.matches(".*[A-Z].*")) {
            return false;
        }
        return true;
    }

    public DefaultTableModel getData(DefaultTableModel model) {
        Connection con = Config.connectDB();
        try {
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(UserQueries.SELECT_ALL_USERS);
            while (result.next()) {
                String username = result.getString("username");
                String role = result.getString("kode_jabatan");
                String status = result.getString("status");
                model.addRow(new Object[]{username, role, status});
            }
            con.close();
            return model;
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return null;
        }
    }

    public ResultSet getSingleData(int id) {
        Connection con = Config.connectDB();
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            ps = con.prepareStatement(UserQueries.SELECT_SINGLE_USER);
            ps.setInt(1, id);
            result = ps.executeQuery();
            return result;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public void deleteData(String username) {
        Connection con = Config.connectDB();
        try {
            PreparedStatement ps = con.prepareStatement(UserQueries.DELETE_USER);
            ps.setString(1, username);
            ps.executeUpdate();
            con.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void addData(UserModel user) {
        Connection con = Config.connectDB();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(UserQueries.INSERT_USER);
            ps.setString(1, getFullName());
            ps.setString(2, getUsername());
            ps.setString(3, getPassword());
            ps.setString(4, getGender());
            ps.setString(5, getRole());
            ps.execute();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }
    }

    public void updateAuthentication(int bool, String username) {
        Connection con = Config.connectDB();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(UserQueries.IS_AUTHENTICATED);
            ps.setInt(1, bool);
            ps.setString(2, username);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }
    }

    public boolean authentication() {
        ResultSet rs = null;
        try (Connection con = Config.connectDB(); PreparedStatement ps = con.prepareStatement(UserQueries.SEARCH_USER)) {
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                rs.close();
                return true;
            } else {
                updateAuthentication(0, username);
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
            return false;
        }
    }

    public void updateData(int id) {
        Connection con = Config.connectDB();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(UserQueries.UPDATE_USER);
            ps.setBoolean(1, status);
            ps.setString(2, role);
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
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
}
