package controller;

import Form.PopUpUser;
import dao.Getter_Dao;
import dao.User_Dao;
import helper.UserQueries;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;
import model.User;
import view.Login;

public class UserController {

    private JTable table;
    private JFrame frame;
    private PopUpUser popUp;
    private User user;
    private List<User> data;
    private User_Dao userDao;
    private Getter_Dao dao;

    public UserController(JTable table) {
        this.table = table;
        this.userDao = new User_Dao();
        this.dao = new Getter_Dao();
        this.user = new User();
    }

    public UserController(User user) {
        this.user = user;
    }

    public UserController(JFrame frame, String username) {
        this.frame = frame;
        this.userDao = new User_Dao(username);
    }

    public UserController(PopUpUser popUp, JTable table) {
        this.table = table;
        this.popUp = popUp;
        this.userDao = new User_Dao();
        this.dao = new Getter_Dao();
    }

    public void getData(DefaultTableModel model) {
         ResultSet result = dao.getData(UserQueries.SELECT_ALL_USERS);
        try {
            while (result.next()) {
                user.setUsername(result.getString("username"));
                user.setJabatan(result.getString("jabatan"));
                user.setStatus(result.getString("status"));
                model.addRow(new Object[]{user.getUsername(), user.getJabatan(), user.getStatus()});
            }
            table.setModel(model);
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

      public void getSingleData(int row, JTable table, PopUpUser modal) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String username = model.getValueAt(row, 0).toString();
        data = userDao.getSingleData(username);
        for (User user : data) {
            modal.setTxtId(String.valueOf(user.getId()));
            modal.setTxtNama(user.getFullName());
            modal.setTxtUsername(user.getUsername());
            modal.setTxtEmail(user.getEmail());
            modal.setTxtNoHp(user.getNoHp());
            modal.setTxtAlamat(user.getAlamat());
            modal.setCmbJabatan(user.getKodeJabatan() - 1);
            modal.setCmbStatus(user.getKodeStatus() - 1);
        }
    }

    public void deleteDataUser() {
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int row = table.getSelectedRow();
            String username = table.getModel().getValueAt(row, 0).toString();
            userDao.deleteData(username);
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

    public void updateUser(int row) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        user = new User(popUp.getTxtId(), popUp.getTxtNama(), popUp.getTxtUsername(), popUp.getTxtEmail(), popUp.getTxtNoHp(), popUp.getTxtAlamat(), popUp.getCmbJabatan(), popUp.getCmbStatus());
        userDao.updateData(user);
        JOptionPane.showMessageDialog(frame, "Berhasil Update Data");
        model.setRowCount(0);
        getData(model);
    }

    public void logOutConfirm() {
        userDao.updateAuthentication(0);
        this.frame.dispose();
        Login login = new Login();
        login.setVisible(true);
    }
}
