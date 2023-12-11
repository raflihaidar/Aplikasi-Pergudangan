package controller;

import Form.PopUpKlasifikasi;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.KlasifikasiModel;

public class KlasifikasiController {

    private JTable table;
    private KlasifikasiModel data;

    public KlasifikasiController(JTable table) {
        this.table = table;
        data = new KlasifikasiModel();
    }

    public KlasifikasiController(JTable table, String nama) {
        this.table = table;
        data = new KlasifikasiModel(nama);
    }
    
    public KlasifikasiController() {
        data = new KlasifikasiModel();
    }

    public void getData(DefaultTableModel model, String query) {
        ResultSet result = data.getData(query);
        try {
            while (result.next()) {
                int kode = result.getInt("kode");
                String nama = result.getString("nama");
                model.addRow(new Object[]{kode, nama});
            }
            table.setModel(model);
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getSingleData(int row, JTable table, PopUpKlasifikasi modal, String query) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int kode = (int) model.getValueAt(row, 0);
        ResultSet rs = data.getSingleData(kode, query);
        try {
            if (rs.next()) {
                modal.setName(rs.getString("nama"));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error dari controller : " + e.getMessage());
        }
    }

    public void addData(JTable table, String query) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String namaKategori = data.getNama();
        int kodeKategori = data.addData(query);
        model.addRow(new Object[]{kodeKategori, namaKategori});
        table.setModel(model);
    }

    public void deleteData(String query) {
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int row = table.getSelectedRow();
            int kode = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
            data.deleteData(kode, query);
            if (table.isEditing()) {
                table.getCellEditor().stopCellEditing();
            }
            model = (DefaultTableModel) table.getModel();
            model.removeRow(row);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void updateData(int row, String loadQuery, String updateQuery) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int kode = (int) table.getValueAt(row, 0);
        data.updateData(kode, updateQuery);
        model.setRowCount(0);
        getData(model, loadQuery);
    }
    
    public String getTotalData(String query) {
        ResultSet result = data.getData(query);
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
