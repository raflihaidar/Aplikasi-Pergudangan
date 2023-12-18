package controller;

import Form.PopUpDistributor;
import dao.Getter_Dao;
import dao.Distributor_Dao;
import helper.DistributorQueries;
import javax.swing.JTable;
import java.sql.ResultSet;
import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Distributor;

public class DistributorController {

    private JTable table;
    private Distributor distrib;
    private PopUpDistributor popUp;
    private List<Distributor> data;
    private Distributor_Dao distributorDao;
    private Getter_Dao dao;

    public DistributorController(JTable table) {
        this.table = table;
        dao = new Getter_Dao();
        distrib = new Distributor();
        distributorDao = new Distributor_Dao();
    }

    public DistributorController(PopUpDistributor popUp, JTable table) {
        dao = new Getter_Dao();
        this.popUp = popUp;
        this.table = table;
        distrib = new Distributor();
        distributorDao = new Distributor_Dao();
    }

    public DistributorController() {
        dao = new Getter_Dao();
        distrib = new Distributor();
        distributorDao = new Distributor_Dao();
    }

    public void getData(DefaultTableModel model) {
        ResultSet result = dao.getData(DistributorQueries.SELECT_ALL_DISTRIBUTOR);
        try {
            while (result.next()) {
                Distributor distributor = new Distributor();
                distributor.setId(result.getInt("id"));
                distributor.setNama(result.getString("nama"));
                distributor.setAlamat(result.getString("alamat"));
                distributor.setTanggalDaftar(result.getString("tgl_daftar"));
                distributor.setTelepon(result.getString("no_hp"));
                model.addRow(new Object[]{distributor.getId(), distributor.getNama(), distributor.getTelepon(), distributor.getAlamat(), distributor.getTanggalDaftar()});
            }
            table.setModel(model);
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDataDistributor(JTable table) {
        String nama = popUp.getTxtNamaDistributor();
        String telepone = popUp.getTxtTeleponDistributor();
        String alamat = popUp.getTxtAlamatDistributor();
        String tglDaftar = popUp.getTxtTanggalDistributor();
        this.distrib = new Distributor(nama, alamat, telepone);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int id =  distributorDao.addData(distrib);
        model.addRow(new Object[]{id, nama, telepone, alamat, tglDaftar});
        table.setModel(model);
    }

    public void getSingleData(int row, JTable table, PopUpDistributor popUp) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String username = model.getValueAt(row, 0).toString();
        data = distributorDao.getSingleData(username);
        for (Distributor distributor : data) {
            popUp.setTxtIdDistributor(String.valueOf(distributor.getId()));
            popUp.setTxtNamaDistributor(distributor.getNama());
            popUp.setTxtTeleponDistributor(distributor.getTelepon());
            popUp.setTxtAlamatDistributor(distributor.getAlamat());
            popUp.setTxtTanggalDistributor(distributor.getTanggalDaftar());
        }
    }

    public void updateDataDistributor(int row) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        System.out.println("popUp : " + popUp.getTxtIdDistributor());
        distrib = new Distributor(Integer.parseInt(popUp.getTxtIdDistributor()), popUp.getTxtNamaDistributor(), popUp.getTxtAlamatDistributor(), popUp.getTxtTeleponDistributor());
        distributorDao.updateData(distrib);
        JOptionPane.showMessageDialog(null, "Berhasil Update Data");
        model.setRowCount(0);
        getData(model);
    }

    public void deleteData() {
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int row = table.getSelectedRow();
            int id = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
            distributorDao.deleteData(id);
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

    public String getTotalDistributor() {
        ResultSet result = dao.getData(DistributorQueries.GET_TOTAL_DISTRIBUTOR);
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
