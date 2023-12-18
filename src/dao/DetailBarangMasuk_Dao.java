package dao;

import config.Config;
import helper.DetailBarangMasukQueries;
import model.DetailBarangMasuk;
import services.DetailBarangMasuk_Service;
import java.sql.*;

public class DetailBarangMasuk_Dao implements DetailBarangMasuk_Service {

    private Connection con;
    private DetailBarangMasuk detail;

    public DetailBarangMasuk_Dao() {
        con = Config.connectDB();
        detail = new DetailBarangMasuk();
    }

    public ResultSet getSingleData(int kode_barang_masuk) {
        ResultSet result = null;
        try {
            PreparedStatement ps = con.prepareStatement(DetailBarangMasukQueries.GET_SINGLE_DATA);
            ps.setInt(1, kode_barang_masuk);
            result = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error getSingle: " + e.getMessage());
        }
        return result;
    }

    @Override
    public void addData(DetailBarangMasuk detail) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(DetailBarangMasukQueries.ADD_DATA);
            ps.setInt(1, detail.getKodeBarang());
            ps.setInt(2, detail.getKodeBarangMasuk());
            ps.setInt(3, detail.getKuantitas());
            ps.setInt(4, detail.getSubTotal());
            ps.execute();
        } catch (Exception e) {
            System.out.println("Error disana :" + e.getMessage());
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
