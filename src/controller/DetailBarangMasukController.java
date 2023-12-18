package controller;

import Page.DetailBarangMasuk_Page;
import dao.BarangMasuk_Dao;
import dao.Barang_Dao;
import dao.DetailBarangMasuk_Dao;
import dao.Getter_Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.BarangMasuk;
import model.DetailBarangMasuk;
import model.DetailPesanan;

public class DetailBarangMasukController {

    private JTable table;
    private Getter_Dao getterDao;
    private BarangMasuk_Dao barangMasukDao;
    private DetailBarangMasuk_Dao detailDao;
    private Barang_Dao barangDao;
    private DetailBarangMasuk detail;
    private DetailBarangMasuk_Page detailPage;
    private List<BarangMasuk> data;

    public DetailBarangMasukController(JTable table) {
        detail = new DetailBarangMasuk();
        barangMasukDao = new BarangMasuk_Dao();
        getterDao = new Getter_Dao();
        barangDao = new Barang_Dao();
        detailDao = new DetailBarangMasuk_Dao();
        this.table = table;
    }

    public DetailBarangMasukController(JTable table, DetailBarangMasuk_Page detailPage) {
        detail = new DetailBarangMasuk();
        barangMasukDao = new BarangMasuk_Dao();
        getterDao = new Getter_Dao();
        barangDao = new Barang_Dao();
        detailDao = new DetailBarangMasuk_Dao();
        this.detailPage = detailPage;
        this.table = table;
    }

    public void getSingleData(int row, JTable table) {
        DefaultTableModel modelPemesanan = (DefaultTableModel) table.getModel();
        DefaultTableModel modelDetail = (DefaultTableModel) this.table.getModel();
        int kode_barang_masuk = Integer.parseInt(modelPemesanan.getValueAt(row, 0).toString());
        try {
            ResultSet result = detailDao.getSingleData(kode_barang_masuk);
            while (result.next()) {
                DetailPesanan detail = new DetailPesanan();
                detail.setKodeBarang(result.getInt("kode"));
                detail.setNamaBarang(result.getString("nama"));
                detail.setHargaBarang(result.getInt("harga"));
                detail.setKuantitas(result.getInt("kuantitas"));
                detail.setSubTotal(result.getInt("subtotal"));
                modelDetail.addRow(new Object[]{detail.getKodeBarang(), detail.getNamaBarang(), detail.getHargaBarang(), detail.getKuantitas(),
                    detail.getSubTotal()});
            }
            this.table.setModel(modelDetail);
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDataBarang() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Table is Empty");
        } else {
            try {
                for (int i = 0; i < model.getRowCount(); i++) {
                    int kodeBarang = Integer.parseInt(model.getValueAt(i, 0).toString());
                    int kodeBarangMasuk = barangMasukDao.getLastId();
                    int kuantitas = Integer.parseInt(model.getValueAt(i, 3).toString());
                    int subTotal = Integer.parseInt(model.getValueAt(i, 4).toString());
                    this.detail = new DetailBarangMasuk(kodeBarang, kodeBarangMasuk, kuantitas, subTotal);
                    detailDao.addData(detail);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                detailDao.closeConnection();
            }
        }
    }

    public void updateStokBarang() {
        if (!detailPage.getTxtStatus().equals("Disimpan") && !detailPage.getTxtStatus().equals("Dibatalkan")) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                int kodeBarang = Integer.parseInt(model.getValueAt(i, 0).toString());
                int kuantitas = Integer.parseInt(model.getValueAt(i, 3).toString());
                barangDao.updateStok(kuantitas, kodeBarang);
            }
            barangMasukDao.updateData(5, detailPage.getTxtKeterangan(), Integer.parseInt(detailPage.getTxtIdPemesanan()));
                detailPage.setTxtStatus("Disimpan");
            JOptionPane.showMessageDialog(null, "Berhasil Update Data");
            detailDao.closeConnection();
        }
    }

    public void cancelBarangMasuk() {
        if (!detailPage.getTxtStatus().equals("Disimpan") && !detailPage.getTxtStatus().equals("Dibatalkan")) {
            int option = JOptionPane.showConfirmDialog(detailPage, "Apakah Anda Yakin ?", null, JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                barangMasukDao.updateData(4, detailPage.getTxtKeterangan(), Integer.parseInt(detailPage.getTxtIdPemesanan()));
                detailPage.setTxtStatus("Dibatalkan");
                detailDao.closeConnection();
            }
        }
    }
}
