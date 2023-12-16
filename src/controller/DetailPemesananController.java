package controller;

import Page.Pemesanan_Page;
import dao.Barang_Dao;
import dao.DetailPemesanan_Dao;
import dao.Getter_Dao;
import dao.Pemesanan_Dao;
import helper.DetailPesananQueries;
import javax.swing.JTable;
import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Barang;
import model.DetailPesanan;
import model.Pemesanan;

public class DetailPemesananController {

    private JTable table;
    private DetailPesanan detailPesanan;
    private Pemesanan pemesananModel;
    private DetailPemesanan_Dao detailDao;
    private Pemesanan_Dao pesananDao;
    private Getter_Dao getterDao;
    private Barang_Dao barangDao;
    private Pemesanan_Page pemesanan;

    public DetailPemesananController(JTable table, Pemesanan_Page pemesanan) {
        this.table = table;
        this.pemesanan = pemesanan;
        detailPesanan = new DetailPesanan();
        detailDao = new DetailPemesanan_Dao();
        pesananDao = new Pemesanan_Dao();
        getterDao = new Getter_Dao();
        barangDao = new Barang_Dao();
        pemesananModel = new Pemesanan();
    }

    public void getData(DefaultTableModel model) {
        ResultSet result = getterDao.getData(DetailPesananQueries.SELECT_ALL_DETAIL);
        try {
            while (result.next()) {
                DetailPesanan detail = new DetailPesanan();
                detail.setId(result.getInt("id"));
                detail.setBarang(result.getInt("kode_barang"));
                detail.setKuantitas(result.getInt("kuantitas"));
                detail.setSubTotal(result.getInt("subtotal"));
                model.addRow(new Object[]{detail.getId(), detail.getBarang(), detail.getKuantitas(),
                    detail.getSubTotal()});
            }
            table.setModel(model);
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addToTable() {
        String username = pemesanan.getTxtKodeBarang();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        List<Barang> data = barangDao.getSingleData(username);
        for (Barang barang : data) {
            String namaBarang = barang.getNama();
            int kodeBarang = barang.getKode();
            int hargaBarang = barang.getHarga();
            model.addRow(new Object[]{kodeBarang, namaBarang, hargaBarang});
        }
        table.setModel(model);
    }

    public void addDataDetail() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(pemesanan, "Table is Empty");
        } else {
            System.out.println(model.getRowCount());
            try {
                for (int i = 0; i < model.getRowCount(); i++) {
                    int idPesanan = pesananDao.getLastId() + 1;
                    int kodeBarang = Integer.parseInt(model.getValueAt(i, 0).toString());
                    int kuantitas = Integer.parseInt(model.getValueAt(i, 3).toString());
                    int subTotal = Integer.parseInt(model.getValueAt(i, 4).toString());
                    this.detailPesanan = new DetailPesanan(idPesanan, kodeBarang, kuantitas, subTotal);
                    detailDao.addData(detailPesanan);
                }
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
