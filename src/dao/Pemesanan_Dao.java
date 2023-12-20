package dao;

import config.Config;
import helper.PemesananQueries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Pemesanan;
import model.Transaksi;
import services.Pemesanan_Service;

public class Pemesanan_Dao implements Pemesanan_Service {

    private Connection con;
    private Pemesanan pemesanan;

    public Pemesanan_Dao() {
        con = Config.connectDB();
        pemesanan = new Pemesanan();
    }

    @Override
    public List<Transaksi> getSingleData(int id) {
        List<Transaksi> data = new ArrayList<>();
        ResultSet result = null;
        try (PreparedStatement ps = con.prepareStatement(PemesananQueries.GET_SINGLE_PESANAN)) {
            ps.setInt(1, id);
            result = ps.executeQuery();
            while (result.next()) {
                pemesanan.setId(result.getInt("id"));
                pemesanan.getDistributor().setNama(result.getString("distributor"));
                pemesanan.setTotal(result.getInt("total"));
                pemesanan.setTanggal(result.getString("tanggal"));
                pemesanan.getUser().setFullName(result.getString("user"));
                pemesanan.getDistributor().setAlamat(result.getString("alamat"));
                pemesanan.getStatus().setKode(result.getInt("status"));
                pemesanan.getStatus().setStatus(result.getString("nama_status"));
                data.add(pemesanan);
            }
        } catch (SQLException e) {
            System.out.println("Error getSingle: " + e.getMessage());
        }
        return data;
    }

    @Override
    public void addData(Transaksi pemesanan) {
        try (PreparedStatement ps = con.prepareStatement(PemesananQueries.INSERT_PESANAN)) {
            ps.setInt(1, pemesanan.getUser().getId());
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
    public void updateData(Transaksi pemesanan) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(PemesananQueries.UPDATE_PESANAN);
            ps.setInt(1, pemesanan.getDistributor().getId());
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
    public void updateDetailData(int kodeStatus, int idPemesanan) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(PemesananQueries.UPDATE_DETAIL_PEMESANAN);
            ps.setInt(1, kodeStatus);
            ps.setInt(2, idPemesanan);

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
            ps = con.prepareStatement(PemesananQueries.DELETE_PESANAN);
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

    @Override
    public void terminateOrder(int id) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(PemesananQueries.BATALKAN_PEMESANAN);
            ps.setInt(1, id);
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
