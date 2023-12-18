package dao;

import java.sql.*;
import model.Barang;
import config.Config;
import helper.BarangQueries;
import java.util.ArrayList;
import java.util.List;
import services.Barang_Service;

public class Barang_Dao implements Barang_Service {

    private Connection con;
    private Barang barang;

    public Barang_Dao() {
        con = Config.connectDB();
        barang = new Barang();
    }

    @Override
    public List<Barang> getSingleData(String username) {
        List<Barang> data = new ArrayList<>();
        ResultSet result = null;
        try (PreparedStatement ps = con.prepareStatement(BarangQueries.SELECT_SINGLE_DATA)) {
            ps.setString(1, username);
            result = ps.executeQuery();
            while (result.next()) {
                barang.setKode(result.getInt("kode"));
                barang.setNama(result.getString("nama"));
                barang.setHarga(result.getInt("harga"));
                barang.setStok(result.getInt("stok"));
                barang.setKodeKategori(result.getInt("kategori"));
                barang.setSatuan(result.getString("satuan"));
                data.add(barang);
            }
        } catch (SQLException e) {
            System.out.println("Error getSingle: " + e.getMessage());
        }
        return data;
    }

    @Override
    public int addData(Barang barang) {
        ResultSet generatedKeys = null;
        int kode = 0;
        try (PreparedStatement ps = con.prepareStatement(BarangQueries.INSERT_BARANG)) {
            ps.setString(1, barang.getNama());
            ps.setInt(2, barang.getHarga());
            ps.setInt(3, barang.getStok());
            ps.setInt(4, barang.getKodeKategori());
            ps.setInt(5, barang.getKodeSatuan());
            ps.execute();

            generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                kode = generatedKeys.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return kode;
    }

    @Override
    public void updateData(Barang barang) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(BarangQueries.UPDATE_BARANG);
            ps.setString(1, barang.getNama());
            ps.setInt(2, barang.getHarga());
            ps.setInt(3, barang.getStok());
            ps.setInt(4, barang.getKodeKategori());
            ps.setInt(5, barang.getKodeSatuan());
            ps.setInt(6, barang.getKode());

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
        PreparedStatement ps = null;
        Connection con = Config.connectDB();
        try {
            ps = con.prepareStatement(BarangQueries.DELETE_BARANG);
            ps.setInt(1, kode);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error delete : " + e.getMessage());
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

    @Override
    public void updateStok(int kuantitas, int kode) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(BarangQueries.UPDATE_STOK);
            ps.setInt(1, kuantitas);
            ps.setInt(2, kode);

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

}
