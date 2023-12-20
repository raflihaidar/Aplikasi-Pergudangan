package dao;

import config.Config;
import helper.BarangKeluarQueries;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.BarangKeluar;
import model.Transaksi;
import services.BarangKeluar_Service;

public class BarangKeluar_Dao implements BarangKeluar_Service {

    private Connection con;
    private Transaksi transaksi;

    public BarangKeluar_Dao() {
        con = Config.connectDB();
        transaksi = new BarangKeluar();
    }

    public int getLastId() {
        ResultSet result = null;
        int id = 0;
        try (PreparedStatement ps = con.prepareStatement(BarangKeluarQueries.GET_LAST_ID)) {
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
    public void addData(Transaksi transaksi) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(BarangKeluarQueries.INSERT_DATA);
            ps.setInt(1, transaksi.getIdUser());
            ps.setInt(2, transaksi.getTotalPemesanan());
            ps.setInt(3, transaksi.getJumlah());
            ps.setString(4, transaksi.getKeterangan());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Barang Berhasil ditambahkan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Barang Gagal Ditambahkan");
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Transaksi> getSingleData(int Kode) {
        List<Transaksi> data = new ArrayList<>();
        ResultSet result = null;
        try (PreparedStatement ps = con.prepareStatement(BarangKeluarQueries.GET_SINGLE_DATA)) {
            ps.setInt(1, Kode);
            result = ps.executeQuery();
            while (result.next()) {
                transaksi.setIdPemesanan(result.getInt("id"));
                transaksi.setUsername(result.getString("user"));
                transaksi.setTanggalMasuk(result.getString("tanggal"));
                transaksi.setJumlah(result.getInt("jumlah"));
                transaksi.setStatusPemesanan(result.getString("status"));
                transaksi.setKeterangan(result.getString("keterangan"));
                data.add(transaksi);
            }
        } catch (SQLException e) {
            System.out.println("Error getSingle: " + e.getMessage());
        }
        return data;
    }

    @Override
    public void updateData(int idStatus, String keterangan, int kode) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(BarangKeluarQueries.UPDATE_DATA);
            ps.setInt(1, idStatus);
            ps.setString(2, keterangan);
            ps.setInt(3, kode);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteData(int id) {
        PreparedStatement ps = null;
        Connection con = Config.connectDB();
        try {
            ps = con.prepareStatement(BarangKeluarQueries.DELETE_DATA);
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
