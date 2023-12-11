package model;

import config.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KlasifikasiModel {

    private int kode;
    private String nama;

    public KlasifikasiModel(String nama) {
        this.nama = nama;
    }

    public KlasifikasiModel() {
    }

    public String getNama() {
        return nama;
    }

    public int getKode() {
        return kode;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ResultSet getData(String query) {
        Connection con = Config.connectDB();
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
    
    public ResultSet getSingleData(int kode, String query) {
        Connection con = Config.connectDB();
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, kode);
            result = ps.executeQuery();
            System.out.println("kode data  " + kode);
            return result;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }


    public int addData(String query) {
        Connection con = Config.connectDB();
        PreparedStatement ps = null;
        ResultSet generatedKeys = null;
        int kode = -1;
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, nama);
            ps.execute();

            generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                kode = generatedKeys.getInt(1);
            }
            generatedKeys.close();
            return kode;
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
            return 0;
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

    public void deleteData(int kode, String query) {
        Connection con = Config.connectDB();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, kode);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        if (ps != null) {
            try {
                con.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateData(int kode, String query) {
        Connection con = Config.connectDB();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, nama);
            ps.setInt(2, kode);
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
    
    public ResultSet getTotalData(String query){
       Connection con = Config.connectDB();
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
}
