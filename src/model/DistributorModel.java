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
    private String nama;
    private String no_tlp;
    private String alamat;
    
    public DistributorModel(String nama,String alamat,String no_tlp){
        this.nama = nama;
        this.alamat = alamat;
        this.no_tlp = no_tlp;
    }

  public DistributorModel() {

    }
    
    public String getNama(){
        return nama;    
    }
    public String getTelepon(){
        return no_tlp;    
    }
    public String getAlamat(){
        return alamat;    
    }
    public void setNama(String Nama){
        this.nama = Nama ;    
    }
    public void setTelepon(String Telepon){
        this.no_tlp = Telepon ;    
    }
    public void setAlamat(String Alamat){
        this.alamat = Alamat ;    
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
    
    
    public ResultSet getSingleData(int ID) {
        Connection con = Config.connectDB();
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            ps = con.prepareStatement(BarangQueries.SELECT_SINGLE_DATA);
            ps.setInt(1, ID);
            result = ps.executeQuery();
            return result;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    

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

    public int addData() {
        Connection con = Config.connectDB();
        PreparedStatement ps = null;
        ResultSet generatedKeys = null;
        int kode = -1;
        try {
            ps = con.prepareStatement(BarangQueries.INSERT_BARANG);
            ps.setString(1, this.nama);
            ps.setString(2, this.alamat);
            ps.setString(3, this.no_tlp);
            
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
                    /* handle exception */
                    e.printStackTrace();
                }
            }
        }
    }}

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
//}
