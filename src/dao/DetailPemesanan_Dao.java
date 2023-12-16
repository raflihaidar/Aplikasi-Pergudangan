package dao;

import config.Config;
import java.sql.*;
import helper.DetailPesananQueries;
import model.DetailPesanan;
import services.DetailPesanan_Service;

public class DetailPemesanan_Dao implements DetailPesanan_Service {

    private Connection con;
    private DetailPesanan detail;

    public DetailPemesanan_Dao() {
        con = Config.connectDB();
        DetailPesanan detail = new DetailPesanan();
    }

    @Override
    public void addData(DetailPesanan detail) {
        try (PreparedStatement ps = con.prepareStatement(DetailPesananQueries.INSERT_DATA)) {
            ps.setInt(1, detail.getPemesanan());
            ps.setInt(2, detail.getBarang());
            ps.setInt(3, detail.getKuantitas());
            ps.setInt(4, detail.getSubTotal());
            ps.execute();
        } catch (Exception e) {
            System.out.println("Error disini ? :" + e.getMessage());
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
