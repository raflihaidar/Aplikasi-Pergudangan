package model;

import config.Config;
import helper.BarangQueries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import helper.DistributorQueries;
import helper.DistributorQueries;


public class DistributorModel {
    private int ID;
    private String Nama;
    private String Telepon;
    private String Alamat;
    
    public String getNama(){
        return Nama;    
    }
    public String getTelepon(){
        return Telepon;    
    }
    public String getAlamat(){
        return Alamat;    
    }
    public void setNama(String Nama){
        this.Nama = Nama ;    
    }
    public void setTelepon(String Telepon){
        this.Telepon = Telepon ;    
    }
    public void setAlamat(String Alamat){
        this.Alamat = Alamat ;    
    }
    
    public ResultSet getData() {
        Connection con = Config.connectDB();
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = con.createStatement();
            result = statement.executeQuery(DistributorQueries.SELECT_ALL_DISTRIBUTOR);
            return result;
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    
    
//    public ResultSet getSingleData(int kodeBarang) {
//        Connection con = Config.connectDB();
//        PreparedStatement ps = null;
//        ResultSet result = null;
//        try {
//            ps = con.prepareStatement(BarangQueries.SELECT_SINGLE_DATA);
//            ps.setInt(1, kodeBarang);
//            result = ps.executeQuery();
//            return result;
//        } catch (SQLException e) {
//            System.out.println("Error: " + e.getMessage());
//            return null;
//        }
//    }
//    
//
//    public void deleteData(int kode) {
//        Connection con = Config.connectDB();
//        PreparedStatement ps = null;
//        try {
//            ps = con.prepareStatement(BarangQueries.DELETE_BARANG);
//            ps.setInt(1, kode);
//            ps.executeUpdate();
//        } catch (Exception e) {
//            System.out.println("Error : " + e.getMessage());
//        }
//        if (ps != null) {
//            try {
//                con.close();
//                ps.close();
//            } catch (SQLException e) {
//                /* handle exception */
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public int addData(String nama, int harga, int stok, int kategori, int satuan) {
//        Connection con = Config.connectDB();
//        PreparedStatement ps = null;
//        ResultSet generatedKeys = null;
//        int kode = -1;
//        try {
//            ps = con.prepareStatement(BarangQueries.INSERT_BARANG);
//            ps.setString(1, nama);
//            ps.setInt(2, harga);
//            ps.setInt(3, stok);
//            ps.setInt(4, kategori);
//            ps.setInt(5, satuan);
//            ps.execute();
//
//            generatedKeys = ps.getGeneratedKeys();
//            if (generatedKeys.next()) {
//                kode = generatedKeys.getInt(1);
//            }
//            generatedKeys.close();
//            return kode;
//        } catch (Exception e) {
//            System.out.println("Error :" + e.getMessage());
//            return 0;
//        } finally {
//            if (ps != null) {
//                try {
//                    con.close();
//                    ps.close();
//                } catch (SQLException e) {
//                    /* handle exception */
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public void updateData(int kode) {
//        Connection con = Config.connectDB();
//        PreparedStatement ps = null;
//        try {
//            ps = con.prepareStatement(BarangQueries.UPDATE_BARANG);
//            ps.setString(1, nama);
//            ps.setInt(2, harga);
//            ps.setInt(3, stok);
//            ps.setInt(4, kategori);
//            ps.setInt(5, satuan);
//            ps.setInt(6, kode);
//            ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (ps != null) {
//                try {
//                    con.close();
//                    ps.close();
//                } catch (SQLException e) {
//                    /* handle exception */
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}
