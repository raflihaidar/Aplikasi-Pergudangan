package controller;

import Page.DetailPemesanan;
import dao.BarangMasuk_Dao;
import dao.ComboBox_Dao;
import model.BarangMasuk;
import dao.Getter_Dao;
import helper.BarangMasukQueries;
import helper.DistributorQueries;
import helper.UserQueries;
import javax.swing.JTable;
import java.sql.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Page.DetailBarangMasuk_Page;
import javax.swing.JOptionPane;
import model.Transaksi;

public class BarangMasukController {

    private JTable table;
    private Getter_Dao getterDao;
    private BarangMasuk_Dao barangMasukDao;
    private BarangMasuk barang;
    private DetailPemesanan detail;
    private ComboBox_Dao cb;
    private List<Transaksi> data;

    public BarangMasukController(DetailPemesanan detail) {
        this.detail = detail;
        getterDao = new Getter_Dao();
        barang = new BarangMasuk();
        barangMasukDao = new BarangMasuk_Dao();
        cb = new ComboBox_Dao();
    }

    public BarangMasukController(JTable table) {
        this.table = table;
        getterDao = new Getter_Dao();
        barang = new BarangMasuk();
        barangMasukDao = new BarangMasuk_Dao();
        cb = new ComboBox_Dao();
    }

    public BarangMasukController() {
        getterDao = new Getter_Dao();
    }

    public void getData() {
        ResultSet result = getterDao.getData(BarangMasukQueries.GET_DATA_BARANG_MASUK);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        try {
            while (result.next()) {
                BarangMasuk barang = new BarangMasuk();
                barang.setId(result.getInt("id"));
                barang.getUser().setUsername(result.getString("user"));
                barang.getDistributor().setNama(result.getString("distributor"));
                barang.setTanggal(result.getString("tanggal"));
                barang.getStatus().setStatus(result.getString("status"));
                barang.setJumlah(result.getInt("jumlah"));
                model.addRow(new Object[]{barang.getId(),  barang.getUser().getUsername(), barang.getDistributor().getNama(),
                    barang.getTanggal(), barang.getJumlah(), barang.getStatus().getStatus()});
            }
            table.setModel(model);
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getSingleData(int row, DetailBarangMasuk_Page detail) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int id = Integer.parseInt(model.getValueAt(row, 0).toString());
        data = barangMasukDao.getSingleData(id);
        for (Transaksi barangMasuk : data) {
            detail.setTxtUser(String.valueOf(barangMasuk.getUser().getUsername()));
            detail.setTxtTglPemesanan(String.valueOf(barangMasuk.getTanggal()));
            detail.setTxtDistributor(String.valueOf(barangMasuk.getDistributor().getNama()));
            detail.setTxtAlamatDistributor(barangMasuk.getDistributor().getAlamat());
            detail.setTxtIdPemesanan(String.valueOf(barangMasuk.getId()));
            detail.setTxtStatus(barangMasuk.getStatus().getStatus());
            detail.setTxtKeterangan(barangMasuk.getKeterangan());
        }
    }

    public void addDataBarang() {
        int idUser = cb.getDataById(UserQueries.SELECT_ID_BY_NAME, "id", detail.getTxtUser());
        int idDistributor = cb.getDataById(DistributorQueries.SELECT_ID, "id", detail.getDistributor());
        String tanggal = detail.getTxtTglPemesanan();
        int jumlah = detail.getJumlahBarang();
        this.barang = new BarangMasuk(idUser, idDistributor, tanggal, jumlah);
        barangMasukDao.addData(barang);
    }

    public void deleteData() {
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int row = table.getSelectedRow();
            int kode = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
            int option = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Menghapus Pesanan", "Question", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                JOptionPane.showMessageDialog(null, "Pesanan Berhasil Dihapus", "Success", JOptionPane.INFORMATION_MESSAGE);
                barangMasukDao.deleteData(kode);
                if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
                }
                model = (DefaultTableModel) table.getModel();
                model.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(null, "Gagal Menghapus Pesanan", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public String getTotalData() {
        ResultSet result = getterDao.getData(BarangMasukQueries.GET_TOTAL_DATA);
        int total = 0;
        try {
            while (result.next()) {
                total = result.getInt(1);
            }
            result.close();
            return String.valueOf(total);
        } catch (SQLException e) {
            e.printStackTrace();
            return String.valueOf(total);
        }
    }
}
