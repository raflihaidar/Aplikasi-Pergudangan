/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JTable;
import javax.swing.JComboBox;
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
    
    public DistributorController (JTable table){
        this.table = table;
        distrib = new DistributorModel();
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
}
