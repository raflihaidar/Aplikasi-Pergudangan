package model;

import config.Config;
import helper.BarangQueries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class BarangModel {
    private String nama;
    private int harga;
    private int stok;
    private int satuan;
    private int kategori;

    public BarangModel(String nama, int harga, int stok, int satuan, int kategori) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.kategori = kategori;
        this.satuan = satuan;
    }

    public BarangModel() {
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getHarga() {
        return harga;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getStok() {
        return stok;
    }

    public void setSatuan(int satuan) {
        this.satuan = satuan;
    }

    public int getSatuan() {
        return satuan;
    }

    public void setKategori(int kategori) {
        this.kategori = kategori;
    }

    public int getKategori() {
        return kategori;
    }

    public DefaultTableModel getData(DefaultTableModel model) {
        Connection con = Config.connectDB();
        try {
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(BarangQueries.SELECT_ALL_DATA);
            while (result.next()) {
                int kode = result.getInt("kode");
                String nama = result.getString("nama");
                int harga = result.getInt("harga");
                int stok = result.getInt("stok");
                String kode_kategori = result.getString("kategori");
                String kode_satuan = result.getString("satuan");
                model.addRow(new Object[] { kode, nama, harga, stok, kode_kategori, kode_satuan });
            }
            con.close();
            statement.close();
            return model;
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet getSingleData(int kodeBarang) {
        Connection con = Config.connectDB();
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            ps = con.prepareStatement(BarangQueries.SELECT_SINGLE_DATA);
            ps.setInt(1, kodeBarang);
            result = ps.executeQuery();
            return result;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    

    public void deleteData(int kode) {
        Connection con = Config.connectDB();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(BarangQueries.DELETE_BARANG);
            ps.setInt(1, kode);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        if (ps != null) {
            try {
                con.close();
                ps.close();
            } catch (SQLException e) {
                /* handle exception */
                e.printStackTrace();
            }
        }
    }

    public int addData(String nama, int harga, int stok, int kategori, int satuan) {
        Connection con = Config.connectDB();
        PreparedStatement ps = null;
        ResultSet generatedKeys = null;
        int kode = -1;
        try {
            ps = con.prepareStatement(BarangQueries.INSERT_BARANG);
            ps.setString(1, nama);
            ps.setInt(2, harga);
            ps.setInt(3, stok);
            ps.setInt(4, kategori);
            ps.setInt(5, satuan);
            ps.execute();

            generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                kode = generatedKeys.getInt(1);
            }
            generatedKeys.close();
            return kode;
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
            return 0;
        } finally {
            if (ps != null) {
                try {
                    con.close();
                    ps.close();
                } catch (SQLException e) {
                    /* handle exception */
                    e.printStackTrace();
                }
            }
        }
    }

    public void updateData(int kode) {
        Connection con = Config.connectDB();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(BarangQueries.UPDATE_BARANG);
            ps.setString(1, nama);
            ps.setInt(2, harga);
            ps.setInt(3, stok);
            ps.setInt(4, kategori);
            ps.setInt(5, satuan);
            ps.setInt(6, kode);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    con.close();
                    ps.close();
                } catch (SQLException e) {
                    /* handle exception */
                    e.printStackTrace();
                }
            }
        }
    }
}
