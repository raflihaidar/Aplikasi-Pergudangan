package controller;

import Components.Table;
import Form.PopUpBarang;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.User;
import view.Login;

public class UserController {

    private JTable table;
    private JFrame frame;
    private User user;

    public UserController(Table table, User user) {
        this.table = table;
        this.user = user;
    }

    public UserController(User user) {
        this.user = user;
    }

    public UserController(JFrame frame, User user) {
        this.frame = frame;
        this.user = user;
    }

    public void showAllData(DefaultTableModel model) {
        table.setModel(user.getData(model));
    }
    
    public void getSingleData(int row, JTable table, PopUpBarang modal) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int username = (int) model.getValueAt(row, 0);
        ResultSet rs = user.getSingleData(username);
        try {
            if (rs.next()) {
                modal.setName(rs.getString("username"));
                modal.setHarga(String.valueOf(rs.getInt("nama")));
                modal.setStok(String.valueOf(rs.getInt("email")));
                modal.setKategori(rs.getString("kategori"));
                modal.setSatuan(rs.getString("satuan"));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void deleteDataUser() {
        try {
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
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void addUser() {
        user.addData(user);
    }

    public void updateUser() {

    }

    public void logOutConfirm() {
        user.updateAuthentication(0, user.getUsername());
        this.frame.dispose();
        Login login = new Login();
        login.setVisible(true);
    }
}
