package model;

import config.Config;
import helper.BarangQueries;
import helper.UserQueries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class BarangModel {
    private String nama;
    private int harga;
    private int stok;
    private int satuan;
    private String kategori;
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setHarga(int harga){
        this.harga = harga;
    }
    
    public int getHarga(){
        return harga;
    }
    
    public void setStok(int stok){
        this.stok = stok;
    }
    
    public int getStok(){
        return stok;
    }
    
    public void setSatuan(int satuan){
        this.satuan = satuan;
    }
    
    public int getSatuan(){
        return satuan;
    }
    
        
    public void setKategori(String kategori){
        this.kategori = kategori;
    }
    
    public String getKategori(){
        return kategori;
    }
    
    public DefaultTableModel getData(DefaultTableModel model){
        Connection con = Config.connectDB();
        try{
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(BarangQueries.SELECT_ALL_DATA);
            while(result.next()){
                int kode = result.getInt("kode");
                String nama = result.getString("nama");
                int harga = result.getInt("harga");
                int stok = result.getInt("stok");
                String kode_kategori = result.getString("kategori");
                String kode_satuan = result.getString("satuan");
                model.addRow(new Object[]{kode, nama, harga, stok, kode_kategori, kode_satuan});
            }
            con.close();
            System.out.println("berhasil");
            return model;
        }catch(Exception e){
            System.out.println("Error" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    public void deleteData(int kode){
        Connection con = Config.connectDB();
        try{
            PreparedStatement ps = con.prepareStatement(BarangQueries.DELETE_BARANG);
            ps.setInt(1, kode);
            ps.executeUpdate();
            con.close();
        }catch(Exception e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public void addData(String nama, int harga, int stok, int kategori, int satuan){
        Connection con = Config.connectDB();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(BarangQueries.INSERT_BARANG);
            ps.setString(1, nama);
            ps.setInt(2, harga);
            ps.setInt(3, stok);
            ps.setInt(4, kategori);
            ps.setInt(5, satuan);
            ps.execute();
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error :" + e.getMessage());
        }
    }
}
