package controller;

import java.sql.*;
import Page.DetailPemesanan;
import dao.ComboBox_Dao;
import model.Pemesanan;
import dao.Getter_Dao;
import dao.Pemesanan_Dao;
import dao.User_Dao;
import helper.BarangQueries;
import helper.PemesananQueries;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Transaksi;
import view.MainMenus;

public class PemesananController {

private JTable table;
private BarangMasukController bmController;
private DetailBarangMasukController detailBmController;
private MainMenus mainMenu;
private Transaksi pemesanan;
private List<Transaksi> data;
private DetailPemesanan detail;
private Pemesanan_Dao pemesananDao;
private Getter_Dao getterDao;
private ComboBox_Dao distributorDao;
private User_Dao userDao;

// Konstruktor untuk DetailPemesanan
public PemesananController(DetailPemesanan detail, JTable table) {
    initializeCommonObjects();
    this.detail = detail;
    this.bmController = new BarangMasukController(detail);
    this.table = table;
    this.detailBmController = new DetailBarangMasukController(table);
}

// Konstruktor untuk MainMenus
public PemesananController(JTable table, MainMenus mainMenu) {
    this(null, table);
    this.mainMenu = mainMenu;
    this.pemesanan = new Pemesanan();
    this.detail = new DetailPemesanan();
}

public PemesananController() {
    getterDao = new Getter_Dao();
}

// Metode untuk inisialisasi objek yang sama pada kedua konstruktor
private void initializeCommonObjects() {
    this.pemesananDao = new Pemesanan_Dao();
    this.getterDao = new Getter_Dao();
    this.distributorDao = new ComboBox_Dao();
    this.userDao = new User_Dao();
}

    public void getData(DefaultTableModel model) {
        ResultSet result = getterDao.getData(PemesananQueries.GET_ALL_PESANAN);
        try {
            while (result.next()) {
                Pemesanan pemesanan = new Pemesanan();
                pemesanan.setId(result.getInt("id"));
                pemesanan.getUser().setId(result.getInt("id_user"));
                pemesanan.getDistributor().setId(result.getInt("id_distributor"));
                pemesanan.setTanggal(result.getString("tanggal"));
                pemesanan.getStatus().setStatus(result.getString("status"));
                pemesanan.setTotal(result.getInt("total"));
                
                model.addRow(new Object[]{pemesanan.getId(), pemesanan.getDistributor().getId(), pemesanan.getUser().getId(),
                    pemesanan.getTanggal(), pemesanan.getTotal(), pemesanan.getStatus().getStatus()});
            }
            table.setModel(model);
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getSingleData(int row, DetailPemesanan detail) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int id = Integer.parseInt(model.getValueAt(row, 0).toString());
        data = pemesananDao.getSingleData(id);
        for (Transaksi pemesanan : data) {
            detail.setTxtUser(String.valueOf(pemesanan.getUser().getFullName()));
            detail.setTxtTotalPemesanan("Rp " + String.valueOf(pemesanan.getTotal()));
            detail.setTxtTglPemesanan(String.valueOf(pemesanan.getTanggal()));
            detail.setStatusPemesanan(pemesanan.getStatus().getKode() - 1);
            detail.setTxtDistributor(String.valueOf(pemesanan.getDistributor().getNama()));
            detail.setTxtAlamatDistributor(pemesanan.getDistributor().getAlamat());
            detail.setTxtIdPemesanan(String.valueOf(pemesanan.getId()));
        }
    }

    public void addData() {
        int idUser = userDao.getIdByStatus();
        this.pemesanan = new Pemesanan(idUser);
        pemesananDao.addData(pemesanan);
    }

    public void deleteData() {
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int row = table.getSelectedRow();
            int kode = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
            int option = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Menghapus Pesanan", "Question", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                JOptionPane.showMessageDialog(null, "Pesanan Berhasil Dihapus", "Success", JOptionPane.INFORMATION_MESSAGE);
                pemesananDao.deleteData(kode);
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

    public void changePage(JPanel panel) {
        mainMenu.getContent().removeAll();
        mainMenu.setContent(panel);
        mainMenu.getContent().repaint();
        mainMenu.getContent().revalidate();
    }

    public void terminateOrder(int id) {
        data = pemesananDao.getSingleData(Integer.parseInt(detail.getTxtIdPemesanan()));
        for (Transaksi pemesanan : data) {
            if (!pemesanan.getStatus().getStatus().equals("Dibatalkan") && !pemesanan.getStatus().getStatus().equals("Diterima")) {
                this.pemesananDao = new Pemesanan_Dao();
                int message = JOptionPane.showConfirmDialog(null, "Batalkan Pemesanan", "Peringatan",
                        JOptionPane.YES_NO_OPTION);
                if (message == 0) {
                    pemesananDao.terminateOrder(id);
                }
            }
        }

    }

    public void modifyOrder() {
        data = pemesananDao.getSingleData(Integer.parseInt(detail.getTxtIdPemesanan()));
        for (Transaksi pemesanan : data) {
            if (!pemesanan.getStatus().getStatus().equals("Dibatalkan") && !pemesanan.getStatus().getStatus().equals("Diterima")) {
                if (detail.getLblModify().equals("Modify")) {
                    detail.setLblModify("Simpan");
                    detail.getStatusPemesanan().setEnabled(true);
                } else {
                    detail.setLblModify("Modify");
                    detail.getStatusPemesanan().setEnabled(false);
                    int kodeStatus = detail.getStatusPemesanan().getSelectedIndex() + 1;
                    int idPemesanan = Integer.parseInt(detail.getTxtIdPemesanan());
                    pemesananDao.updateDetailData(kodeStatus, idPemesanan);

                    if (detail.getStatusPemesanan().getSelectedItem().equals("Diterima")) {
                        bmController.addDataBarang();
                        detailBmController.addDataBarang();
                        JOptionPane.showMessageDialog(null, "Berhasil Ditambahkan ke Barang Masuk");
                    }
                }
            }
        }
    }
    
        public String getTotalPesanan() {
        ResultSet result = getterDao.getData(PemesananQueries.TOTAL_PESANAN);
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
