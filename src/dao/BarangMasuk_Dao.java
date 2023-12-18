package dao;

import config.Config;
import model.BarangMasuk;
import helper.BarangMasukQueries;
import services.BarangMasuk_Services;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BarangMasuk_Dao implements BarangMasuk_Services {

    private Connection con;
    private BarangMasuk barang;

    public BarangMasuk_Dao() {
        con = Config.connectDB();
        barang = new BarangMasuk();
    }

    @Override
    public int addData(BarangMasuk barang) {
        ResultSet generatedKeys = null;
        int kode = 0;
        try (PreparedStatement ps = con.prepareStatement(BarangMasukQueries.ADD_BARANG_MASUK)) {
            ps.setInt(1, barang.getIdUser());
            ps.setInt(2, barang.getIdDistributor());
            ps.setString(3, barang.getTanggalMasuk());
            ps.setInt(4, barang.getJumlah());
            ps.execute();

            generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                kode = generatedKeys.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error disini :" + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return kode;
    }

    public int getLastId() {
        ResultSet result = null;
        int id = 0;
        try (PreparedStatement ps = con.prepareStatement(BarangMasukQueries.GET_LAST_ID)) {
            result = ps.executeQuery();
            while (result.next()) {
                id = result.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return id;
    }

    @Override
    public List<BarangMasuk> getSingleData(int Kode) {
        List<BarangMasuk> data = new ArrayList<>();
        ResultSet result = null;
        try (PreparedStatement ps = con.prepareStatement(BarangMasukQueries.GET_SINGLE_DATA)) {
            ps.setInt(1, Kode);
            result = ps.executeQuery();
            while (result.next()) {
                barang.setIdPemesanan(result.getInt("id"));
                barang.setUsername(result.getString("user"));
                barang.setDistributor(result.getString("distributor"));
                barang.setTanggalMasuk(result.getString("tanggal"));
                barang.setJumlah(result.getInt("jumlah"));
                barang.setAlamatDistributor(result.getString("alamat"));
                barang.setStatusPemesanan(result.getString("status"));
                barang.setKeterangan(result.getString("keterangan"));
                data.add(barang);
            }
        } catch (SQLException e) {
            System.out.println("Error getSingle: " + e.getMessage());
        }
        return data;
    }

    @Override
    public void updateData(int idStatus, String keterangan, int id) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(BarangMasukQueries.UPDATE_DATA);
            ps.setInt(1, idStatus);
            ps.setString(2, keterangan);
            ps.setInt(3, id);

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
