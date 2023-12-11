package controller;

import javax.swing.JTable;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import model.DistributorModel;

/**
 *
 * @author ACER
 */
public class DistributorController {
    private JTable table;
    private DistributorModel distrib;
    private JTextField nama;
    private JTextField alamat;
    private JTextField no_tlp;
    
    
    public DistributorController (JTable table){
        this.table = table;
        distrib = new DistributorModel();
    }
    
    public DistributorController(JTextField nama,JTextField alamat,JTextField no_tlp,JTable table){
        this.nama = nama;
        this.alamat = alamat;
        this.no_tlp = no_tlp;
        distrib = new DistributorModel(nama.getText(),alamat.getText(),no_tlp.getText());
        this.table = table;
    }
    
    public void getData(DefaultTableModel model) {
        ResultSet result = distrib.getData();
        try {
            while (result.next()) {
                int kode = result.getInt("id");
                String nama = result.getString("nama");
                String alamat = result.getString("alamat");
                String tgl_daftar = result.getString("tgl_daftar");
                String no_hp = result.getString("no_hp");
                System.out.println("nama" + result.getString("nama"));
                model.addRow(new Object[]{kode, nama, no_hp, alamat, tgl_daftar});
            }
            
            table.setModel(model);
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addDataDistributor() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int id = distrib.addData();
        
        model.addRow(new Object[]{id, nama, alamat, no_tlp});
        table.setModel(model);
    }
}
