package controller;

import Page.DetailBarangMasuk_Page;
import dao.BarangKeluar_Dao;
import dao.Getter_Dao;
import dao.User_Dao;
import helper.BarangKeluarQueries;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.BarangKeluar;
import model.Transaksi;

public class BarangKeluarController {

    private BarangKeluar_Dao barangKeluarDao;
    private User_Dao userDao;
    private Transaksi transaksi;
    private JTable table;
    private Getter_Dao getterDao;
    private List<Transaksi> data;

    public BarangKeluarController() {
        barangKeluarDao = new BarangKeluar_Dao();
        transaksi = new BarangKeluar();
        userDao = new User_Dao();
        getterDao = new Getter_Dao();
    }

    public BarangKeluarController(JTable table) {
        barangKeluarDao = new BarangKeluar_Dao();
        transaksi = new BarangKeluar();
        userDao = new User_Dao();
        getterDao = new Getter_Dao();
        this.table = table;
    }

    public void getData() {
        ResultSet result = getterDao.getData(BarangKeluarQueries.GET_DATA);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try {
            while (result.next()) {
                Transaksi transaksi = new BarangKeluar();
                transaksi.setIdPemesanan(result.getInt("id"));
                transaksi.setUsername(result.getString("user"));
                transaksi.setTotalPemesanan(result.getInt("total"));
                transaksi.setTanggalMasuk(result.getString("tanggal"));
                transaksi.setStatusPemesanan(result.getString("status"));
                transaksi.setJumlah(result.getInt("jumlah"));
                model.addRow(new Object[]{transaksi.getIdPemesanan(), transaksi.getUsername(), transaksi.getTotalPemesanan(), transaksi.getTanggalMasuk(), transaksi.getStatusPemesanan()});
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
        data = barangKeluarDao.getSingleData(id);
        for (Transaksi transaksi : data) {
            detail.setTxtUser(String.valueOf(transaksi.getUsername()));
            detail.setTxtTglPemesanan(String.valueOf(transaksi.getTanggalMasuk()));
            detail.setTxtIdPemesanan(String.valueOf(transaksi.getIdPemesanan()));
            detail.setTxtStatus(transaksi.getStatusPemesanan());
            System.out.println("status : " + transaksi.getStatusPemesanan());
            detail.setTxtKeterangan(transaksi.getKeterangan());
        }
    }

    public void addData(int amount, int jumlahBaris) {
        int idUser = userDao.getIdByStatus();
        int total = amount;
        int jumlah = jumlahBaris;
        this.transaksi = new BarangKeluar(idUser, total, jumlah);
        barangKeluarDao.addData(transaksi);
    }
    
//        public void deleteData() {
//        try {
//            DefaultTableModel model = (DefaultTableModel) table.getModel();
//            int row = table.getSelectedRow();
//            int kode = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
//            int option = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Menghapus Pesanan", "Question", JOptionPane.YES_NO_OPTION);
//            if (option == 0) {
//                JOptionPane.showMessageDialog(null, "Pesanan Berhasil Dihapus", "Success", JOptionPane.INFORMATION_MESSAGE);
//                pemesananDao.deleteData(kode);
//                if (table.isEditing()) {
//                    table.getCellEditor().stopCellEditing();
//                }
//                model = (DefaultTableModel) table.getModel();
//                model.removeRow(row);
//            }else{
//                JOptionPane.showMessageDialog(null, "Gagal Menghapus Pesanan", "Error", JOptionPane.WARNING_MESSAGE);
//            }
//        } catch (Exception e) {
//            System.out.println("Error : " + e.getMessage());
//        }
//    }
}
