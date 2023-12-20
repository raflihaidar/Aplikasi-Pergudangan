package controller;

import Page.DetailBarangMasuk_Page;
import dao.BarangKeluar_Dao;
import dao.Barang_Dao;
import dao.DetailBarangKeluar_Dao;
import dao.Getter_Dao;
import helper.BarangQueries;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DetailBarangKeluar;
import model.DetailBarangMasuk;
import model.DetailPesanan;
import model.DetailTransaksi;

public class DetailBarangKeluarController {

    private DetailBarangKeluar_Dao transDao;
    private Getter_Dao getterDao;
    private DetailTransaksi detail;
    private BarangKeluar_Dao bkDao;
    private JTable table;
    private Barang_Dao barangDao;
    private DetailBarangMasuk_Page detailPage;

    public DetailBarangKeluarController(JTable table) {
        this.table = table;
        transDao = new DetailBarangKeluar_Dao();
        detail = new DetailBarangKeluar();
        getterDao = new Getter_Dao();
        bkDao = new BarangKeluar_Dao();
    }

    public DetailBarangKeluarController(JTable table, DetailBarangMasuk_Page detailPage) {
        detail = new DetailBarangMasuk();
        bkDao = new BarangKeluar_Dao();
        getterDao = new Getter_Dao();
        barangDao = new Barang_Dao();
        transDao = new DetailBarangKeluar_Dao();
        this.detailPage = detailPage;
        this.table = table;
    }

    public void addDataBarang() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int kodeBarangKeluar = bkDao.getLastId();

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Table is Empty");
        } else {
            try {
                for (int i = 0; i < model.getRowCount(); i++) {
                    Object kodeBarangObj = model.getValueAt(i, 0);
                    Object kuantitasObj = model.getValueAt(i, 6);
                    Object subTotalObj = model.getValueAt(i, 7);

                    if (kodeBarangObj != null && kuantitasObj != null && subTotalObj != null) {
                        int kodeBarang = Integer.parseInt(kodeBarangObj.toString());
                        int kuantitas = Integer.parseInt(kuantitasObj.toString());
                        int subTotal = Integer.parseInt(subTotalObj.toString());
                        this.detail = new DetailBarangKeluar(kodeBarangKeluar, kodeBarang, kuantitas, subTotal);
                        transDao.addData(detail);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void getSingleData(int row, JTable table) {
        DefaultTableModel modelPemesanan = (DefaultTableModel) table.getModel();
        DefaultTableModel modelDetail = (DefaultTableModel) this.table.getModel();
        int kode_barang_masuk = Integer.parseInt(modelPemesanan.getValueAt(row, 0).toString());
        try {
            ResultSet result = transDao.getSingleData(kode_barang_masuk);
            while (result.next()) {
                DetailPesanan detail = new DetailPesanan();
                detail.getBarang().setKode(result.getInt("kode"));
                detail.getBarang().setNama(result.getString("nama"));
                detail.getBarang().setHarga(result.getInt("harga"));
                detail.setKuantitas(result.getInt("kuantitas"));
                detail.setSubTotal(result.getInt("subtotal"));
                modelDetail.addRow(new Object[]{detail.getBarang().getKode(), detail.getBarang().getNama(), detail.getBarang().getHarga(), detail.getKuantitas(),
                    detail.getSubTotal()});
            }
            this.table.setModel(modelDetail);
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStokBarang() {
        if (!detailPage.getTxtStatus().equals("Dikirim") && !detailPage.getTxtStatus().equals("Dibatalkan")) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                int kodeBarang = Integer.parseInt(model.getValueAt(i, 0).toString());
                int kuantitas = Integer.parseInt(model.getValueAt(i, 3).toString());
                barangDao.updateStok(kuantitas, kodeBarang, BarangQueries.KURANGI_STOK);
            }
            bkDao.updateData(2, detailPage.getTxtKeterangan(), Integer.parseInt(detailPage.getTxtIdPemesanan()));
            detailPage.setTxtStatus("Dikirim");
            JOptionPane.showMessageDialog(null, "Berhasil Update Data");
            getterDao.closeConnection();
        }
    }

    public void cancelBarangKeluar() {
        if (!detailPage.getTxtStatus().equals("Disimpan") && !detailPage.getTxtStatus().equals("Dibatalkan")) {
            int option = JOptionPane.showConfirmDialog(detailPage, "Apakah Anda Yakin ?", null, JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                bkDao.updateData(4, detailPage.getTxtKeterangan(), Integer.parseInt(detailPage.getTxtIdPemesanan()));
                detailPage.setTxtStatus("Dibatalkan");
                getterDao.closeConnection();
            }
        }
    }

}
