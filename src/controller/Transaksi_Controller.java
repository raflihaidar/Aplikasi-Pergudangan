package controller;

import dao.Getter_Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Transaksi;

public class Transaksi_Controller {

    private JTable table;
    private Getter_Dao getterDao;
    
    public Transaksi_Controller(JTable table) {
        this.table = table;
        getterDao = new Getter_Dao();
    }

    public void getData(String query) {
        ResultSet result = getterDao.getData(query);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        try {
            while (result.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setIdPemesanan(result.getInt("id"));
                transaksi.setUsername(result.getString("user"));
                transaksi.setDistributor(result.getString("distributor"));
                transaksi.setTanggalMasuk(result.getString("tgl_masuk"));
                transaksi.setStatusPemesanan(result.getString("status"));
                transaksi.setJumlah(result.getInt("jumlah"));
                model.addRow(new Object[]{transaksi.getIdPemesanan(), transaksi.getUsername(), transaksi.getDistributor(), transaksi.getTanggalMasuk(), transaksi.getJumlah(), transaksi.getStatusPemesanan()});
            }
            table.setModel(model);
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
