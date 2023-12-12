package controller;

import javax.swing.JTable;
import javax.swing.JTextField;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import model.DistributorModel;
import Form.AddDistributor;

/**
 *
 * @author ACER
 */
public class DistributorController {
    private JTable table;
    private DistributorModel distrib;
    private JTextField namaDistrib;
    private JTextField alamatDistrib;
    private JTextField no_tlpDistrib;
    
    
    
    public DistributorController (JTable table){
        this.table = table;
        distrib = new DistributorModel();
    }
    
    public DistributorController(JTextField nama,JTextField alamat,JTextField no_tlp,JTable table){
        this.namaDistrib = nama;
        this.alamatDistrib = alamat;
        this.no_tlpDistrib = no_tlp;
        
        distrib = new DistributorModel(nama.getText(),
                alamat.getText(),no_tlp.getText());
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
    public void addDataDistributor(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int id = distrib.addData();
        String nama = (this.namaDistrib.getText());
        String alamat = (this.alamatDistrib.getText());
        String no_tlp = (this.no_tlpDistrib.getText());
        
        model.addRow(new Object[]{id, nama, alamat, no_tlp});
        table.setModel(model);
    }
//    public void getSingleData(int row, JTable table, AddDistributor agen) {
//        DefaultTableModel model = (DefaultTableModel) table.getModel();
//        int ID = (int) model.getValueAt(row, 0);
//        ResultSet rs = distrib.getSingleData(ID);
//        try {
//            if (rs.next()) {
//                agen.setName(rs.getString("nama"));
//                agen.setAlamat(rs.getString("nama"));
//                
//            }
//            rs.close();
//        } catch (Exception e) {
//            System.out.println("Error : " + e.getMessage());
//        }
//   }
}
