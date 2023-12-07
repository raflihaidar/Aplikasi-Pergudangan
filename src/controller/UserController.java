package controller;

import Components.Table;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.UserModel;

public class UserController {
    private JTable table;
    private UserModel user;
    
    public UserController(Table table, UserModel user){
        this.table = table;
        this.user = user;
    }
    
    public UserController(UserModel user){
       this.user = user;
    }
    
    public void showAllData(DefaultTableModel model){
        table.setModel( user.getData(model));
    }
    
    public void deleteDataUser(){
        try{
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int row = table.getSelectedRow();
            String username = table.getModel().getValueAt(row, 0).toString();
            user.deleteData(username);
            if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
            }
            model = (DefaultTableModel) table.getModel();
            model.removeRow(row);
            System.out.println("delete data berhasil");
        }catch(Exception e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public void addUser(){
       user.addData(user);
    }
    
    public void updateUser(){
        
    }
}
