package controller;

import java.sql.*;
import Page.DaftarPemesanan;
import Page.Pemesanan_Page;
import model.Pemesanan;
import dao.Getter_Dao;
import dao.Pemesanan_Dao;
import dao.User_Dao;
import helper.PemesananQueries;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.MainMenus;

public class PemesananController {

    private JTable table;
    private MainMenus mainMenu;
    private DaftarPemesanan daftarPemesanan;
    private Pemesanan pemesanan;
    private Pemesanan_Page pemesananPage = new Pemesanan_Page();
    private Pemesanan_Dao pemesananDao;
    private Getter_Dao getterDao;
    private User_Dao userDao;

    public PemesananController(JTable table, DaftarPemesanan daftarPemesanan, MainMenus mainMenu) {
        this.mainMenu = mainMenu;
        this.daftarPemesanan = daftarPemesanan;
        this.pemesanan = new Pemesanan();
        this.pemesananDao = new Pemesanan_Dao();
        this.getterDao = new Getter_Dao();
        this.userDao = new User_Dao();
        this.table = table;
    }

    public PemesananController() {

    }

    public void getData(DefaultTableModel model) {
        ResultSet result = getterDao.getData(PemesananQueries.GET_ALL_PESANAN);
        try {
            while (result.next()) {
                Pemesanan pemesanan = new Pemesanan();
                pemesanan.setId(result.getInt("id"));
                pemesanan.setIdUser(result.getInt("id_user"));
                pemesanan.setIdDistributor(result.getInt("id_distributor"));
                pemesanan.setTanggal(result.getString("tanggal"));
                pemesanan.setStatus(result.getString("status"));;
                pemesanan.setTotal(result.getInt("total"));
                model.addRow(new Object[]{pemesanan.getId(), pemesanan.getIdDistributor(), pemesanan.getIdUser(), pemesanan.getTanggal(), pemesanan.getTotal(), pemesanan.getStatus()});
            }
            table.setModel(model);
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDataPemesanan() {
        int idUser = userDao.getIdByStatus();
        this.pemesanan = new Pemesanan(idUser);
        pemesananDao.addData(pemesanan);
    }

    public void deleteBarang() {
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int row = table.getSelectedRow();
            int kode = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
            System.out.println(kode);
            pemesananDao.deleteData(kode);
            if (table.isEditing()) {
                table.getCellEditor().stopCellEditing();
            }
            model = (DefaultTableModel) table.getModel();
            model.removeRow(row);
            System.out.println("delete data berhasil");
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
}
