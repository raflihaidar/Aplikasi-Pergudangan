package controller;

import Components.Table;
import helper.UserQueries;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JTable;
import config.Config;
import javax.swing.table.DefaultTableModel;
import model.User;

public class UserController {
    private JTable table;
    private User user;
    
    public UserController(Table table){
        this.table = table;
    }
    
    public UserController(User user){
       this.user = user;
    }
    
    public void showAllData(DefaultTableModel model){
        Connection con = Config.connectDB();
        try{
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(UserQueries.SELECT_ALL_USERS);
            while(result.next()){
                String username = result.getString("username");
                String role = result.getString("kode_jabatan");
                String status = result.getString("status");
                model.addRow(new Object[]{username, role, status});
            }
            table.setModel(model);
            con.close();
        }catch(Exception e){
            System.out.println("Error" + e.getMessage());
        }
    }
    
    public void deleteDataUser(JTable table, DefaultTableModel model){
        Connection con = Config.connectDB();
        try{
            int row = table.getSelectedRow();
            String username = table.getModel().getValueAt(row, 0).toString();
            PreparedStatement ps = con.prepareStatement(UserQueries.DELETE_USER);
            ps.setString(1, username);
            ps.executeUpdate();
            if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
            }
            model = (DefaultTableModel) table.getModel();
            model.removeRow(row);
            System.out.println("delete data berhasil");
            con.close();
        }catch(Exception e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public void addUser(){
        Connection con = Config.connectDB();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(UserQueries.INSERT_USER);
            ps.setString(1, user.getFullName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getGender());
            ps.setString(5, user.getRole());
            ps.execute();
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error :" + e.getMessage());
        }
    }
    
    public void updateUser(){
        
    }
}
