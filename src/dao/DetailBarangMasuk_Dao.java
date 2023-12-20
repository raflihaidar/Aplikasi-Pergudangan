package dao;

import config.Config;
import helper.DetailBarangMasukQueries;
import model.DetailBarangMasuk;
import java.sql.*;
import model.DetailTransaksi;
import services.DetailTransaksi_Service;

public class DetailBarangMasuk_Dao implements DetailTransaksi_Service {

    private Connection con;
    private DetailTransaksi detail;

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
    public void addData(DetailTransaksi detail) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(DetailBarangMasukQueries.ADD_DATA);
            ps.setInt(1, detail.getBarang().getKode());
            ps.setInt(2, detail.getIdTransaksi());
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
