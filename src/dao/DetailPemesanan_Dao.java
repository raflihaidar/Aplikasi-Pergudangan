package dao;

import config.Config;
import java.sql.*;
import helper.DetailPesananQueries;
import model.DetailPesanan;
import model.DetailTransaksi;
import services.DetailTransaksi_Service;

public class DetailPemesanan_Dao implements DetailTransaksi_Service  {

    private Connection con;
    private DetailTransaksi detail;

    public DetailPemesanan_Dao() {
        con = Config.connectDB();
        detail = new DetailPesanan();
    }

    @Override
    public void addData(DetailTransaksi detail) {
        try (PreparedStatement ps = con.prepareStatement(DetailPesananQueries.INSERT_DATA)) {
            ps.setInt(1, detail.getIdTransaksi());
            ps.setInt(2, detail.getBarang().getKode());
            ps.setInt(3, detail.getKuantitas());
            ps.setInt(4, detail.getSubTotal());
            ps.execute();
        } catch (Exception e) {
            System.out.println("Error disini ? :" + e.getMessage());
        }
    }

    public ResultSet getSingleData(int idPemesanan) {
        ResultSet result = null;
        try{
            PreparedStatement ps = con.prepareStatement(DetailPesananQueries.GET_SINGLE_PEMESANAN);
            ps.setInt(1, idPemesanan);
            result = ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error getSingle: " + e.getMessage());
        }
        return result;
    }

    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
