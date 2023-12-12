package controller;

import Components.Table;
import Form.PopUpUser;
import dao.UserDao;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.User;
import view.Login;

public class UserController {

    private JTable table;
    private JFrame frame;
    private PopUpUser popUp;
    private User user;
    private List<User> data;
    private UserDao userDao;

    public UserController(Table table) {
        this.table = table;
        this.userDao = new UserDao();
        this.data = userDao.getAllData();
    }

    public UserController(User user) {
        this.user = user;
    }

    public UserController(JFrame frame, String username) {
        this.frame = frame;
        this.userDao = new UserDao(username);
    }

    public UserController(PopUpUser popUp, JTable table) {
        this.table = table;
        this.popUp = popUp;
        this.userDao = new UserDao();
    }

    public void showAllData(DefaultTableModel model) {
        data = userDao.getAllData();

        for (User user : data) {
            String username = user.getUsername();
            String role = user.getJabatan();
            String status = user.getStatus();
            model.addRow(new Object[]{username, role, status});
        }
        table.setModel(model);
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
        showAllData(model);
    }

    public void logOutConfirm() {
        userDao.updateAuthentication(0);
        this.frame.dispose();
        Login login = new Login();
        login.setVisible(true);
    }
}
