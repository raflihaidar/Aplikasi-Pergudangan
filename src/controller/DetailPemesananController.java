package controller;

import Page.DaftarPemesanan;
import Page.Pemesanan_Page;
import dao.Barang_Dao;
import dao.DetailPemesanan_Dao;
import dao.Pemesanan_Dao;
import javax.swing.JTable;
import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Barang;
import model.DetailPesanan;
import model.DetailTransaksi;
import model.Pemesanan;

public class DetailPemesananController {

    private JTable table;
    private DetailTransaksi detailPesanan;
    private Pemesanan pemesananModel;
    private DetailPemesanan_Dao detailDao;
    private Pemesanan_Dao pesananDao;
    private Barang_Dao barangDao;
    private Pemesanan_Page pemesanan;

    public DetailPemesananController(JTable table, Pemesanan_Page pemesanan) {
        this.table = table;
        this.pemesanan = pemesanan;
        detailPesanan = new DetailPesanan(); // Polymorpism
        detailDao = new DetailPemesanan_Dao();
        pesananDao = new Pemesanan_Dao();
        barangDao = new Barang_Dao();
        pemesananModel = new Pemesanan();
    }

    public DetailPemesananController(JTable table) {
        this(table, null);
    }

    public void getSingleData(int row, JTable table) {
        DefaultTableModel modelPemesanan = (DefaultTableModel) table.getModel();
        DefaultTableModel modelDetail = (DefaultTableModel) this.table.getModel();
        int idPesanan = Integer.parseInt(modelPemesanan.getValueAt(row, 0).toString());
        try {
            ResultSet result = detailDao.getSingleData(idPesanan);
            while (result.next()) {
                DetailTransaksi detail = new DetailPesanan();
                detail.getBarang().setKode(result.getInt("kode"));
                detail.getBarang().setNama(result.getString("nama"));
                detail.getBarang().setHarga(result.getInt("harga"));
                detail.setKuantitas(result.getInt("kuantitas"));
                detail.setSubTotal(result.getInt("subtotal"));
                modelDetail.addRow(new Object[] { detail.getBarang().getKode(), detail.getBarang().getNama(),
                        detail.getBarang().getHarga(), detail.getKuantitas(),
                        detail.getSubTotal() });
            }
            this.table.setModel(modelDetail);
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addToTable() {
        int username = Integer.parseInt(pemesanan.getTxtKodeBarang());
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        List<Barang> data = barangDao.getSingleData(username);
        for (Barang barang : data) {
            String namaBarang = barang.getNama();
            int kodeBarang = barang.getKode();
            int hargaBarang = barang.getHarga();
            model.addRow(new Object[] { kodeBarang, namaBarang, hargaBarang });
        }
        table.setModel(model);
    }

    public void addDataDetail() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(pemesanan, "Table is Empty");
        } else {
            try {
                for (int i = 0; i < model.getRowCount(); i++) {
                    int idPesanan = pesananDao.getLastId();
                    int kodeBarang = Integer.parseInt(model.getValueAt(i, 0).toString());
                    int kuantitas = Integer.parseInt(model.getValueAt(i, 3).toString());
                    int subTotal = Integer.parseInt(model.getValueAt(i, 4).toString());
                    this.detailPesanan = new DetailPesanan(idPesanan, kodeBarang, kuantitas, subTotal);
                    detailDao.addData(detailPesanan);
                }
                JOptionPane.showConfirmDialog(pemesanan, "Ingin Menambahkan Pesanan ?", "Question",
                        JOptionPane.YES_NO_OPTION);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                detailDao.closeConnection();
            }
        }
    }

    public int getLastId() {
        int id = pesananDao.getLastId();
        return id;
    }

    public void updateTotal() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int total = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            total += Integer.parseInt(model.getValueAt(i, 4).toString());
        }
        pemesanan.setTotalBarang(String.valueOf(total));
    }

    public void updateSubtotal() {
        int selectedRow = table.getSelectedRow();
        int kolomKuantitas = 3;
        int kolomHarga = 2;
        int kolomSubtotal = 4;
        Object kuantitasObj = table.getValueAt(selectedRow, kolomKuantitas);
        Object hargaObj = table.getValueAt(selectedRow, kolomHarga);

        if (kuantitasObj != null && hargaObj != null) {
            try {
                int kuantitas = Integer.parseInt(kuantitasObj.toString());
                int harga = Integer.parseInt(hargaObj.toString());
                int subTotal = kuantitas * harga;
                table.setValueAt(subTotal, selectedRow, kolomSubtotal);
                updateTotal();
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void updateData() {
        pemesananModel = new Pemesanan(pemesanan.getIdPesanan(), pemesanan.getTxtDistributor(),
                pemesanan.getTotalBarang());
        pesananDao.updateData(pemesananModel);
    }
}
