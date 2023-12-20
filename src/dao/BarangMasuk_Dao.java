package dao;

import config.Config;
import model.BarangMasuk;
import helper.BarangMasukQueries;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Transaksi;
import services.Transaksi_Service;

public class BarangMasuk_Dao implements Transaksi_Service {

    private Connection con;
    private Transaksi barang;

    public BarangMasuk_Dao() {
        con = Config.connectDB();
        barang = new BarangMasuk();
    }

    @Override
    public int addData(Transaksi transaksi) {
        ResultSet generatedKeys = null;
        int kode = 0;
        try (PreparedStatement ps = con.prepareStatement(BarangMasukQueries.ADD_BARANG_MASUK)) {
            ps.setInt(1, transaksi.getUser().getId());
            ps.setInt(2, transaksi.getDistributor().getId());
            ps.setString(3, transaksi.getTanggal());
            ps.setInt(4, transaksi.getJumlah());
            ps.execute();

            generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                kode = generatedKeys.getInt(1);
            }
             JOptionPane.showMessageDialog(null, "Barang Berhasil ditambahkan");
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
    public List<Transaksi> getSingleData(int Kode) {
        List<Transaksi> data = new ArrayList<>();
        ResultSet result = null;
        try (PreparedStatement ps = con.prepareStatement(BarangMasukQueries.GET_SINGLE_DATA)) {
            ps.setInt(1, Kode);
            result = ps.executeQuery();
            while (result.next()) {
                barang.setId(result.getInt("id"));
                barang.getUser().setUsername(result.getString("user"));
                barang.getDistributor().setNama(result.getString("distributor"));
                barang.setTanggal(result.getString("tanggal"));
                barang.setJumlah(result.getInt("jumlah"));
                barang.getDistributor().setAlamat(result.getString("alamat"));
                barang.getStatus().setStatus(result.getString("status"));
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

    @Override
    public void deleteData(int id) {
        PreparedStatement ps = null;
        Connection con = Config.connectDB();
        try {
            ps = con.prepareStatement(BarangMasukQueries.DELETE_DATA);
            ps.setInt(1, id);
            ps.executeUpdate();;
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
}
