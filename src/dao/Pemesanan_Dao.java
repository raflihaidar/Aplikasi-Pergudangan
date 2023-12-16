package dao;

import config.Config;
import helper.PemesananQueries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Pemesanan;
import services.Pemesanan_Service;

public class Pemesanan_Dao implements Pemesanan_Service {

    private Connection con;
    private Pemesanan pemesanan;

    public Pemesanan_Dao() {
        con = Config.connectDB();
        pemesanan = new Pemesanan();
    }

    @Override
    public List<Pemesanan> getSingleData(int Kode) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addData(Pemesanan pemesanan) {
        try (PreparedStatement ps = con.prepareStatement(PemesananQueries.INSERT_PESANAN)) {
            ps.setInt(1, pemesanan.getIdUser());
            ps.execute();
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateData(Pemesanan pemesanan) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(PemesananQueries.UPDATE_PESANAN);
            ps.setInt(1, pemesanan.getIdDistributor());
            ps.setInt(2, pemesanan.getTotal());
            ps.setInt(3, pemesanan.getId());

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
    public void deleteData(int kode) {
        try {
            PreparedStatement ps = con.prepareStatement(PemesananQueries.DELETE_PESANAN);
            ps.setInt(1, kode);
            ps.executeUpdate();
            con.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error delete : " + e.getMessage());
        }
    }

    @Override
    public int getLastId() {
        ResultSet result = null;
        int id = 0;
        try (PreparedStatement ps = con.prepareStatement(PemesananQueries.GET_LAST_ID)) {
            result = ps.executeQuery();
            while (result.next()) {
                id = result.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return id;
    }

}
