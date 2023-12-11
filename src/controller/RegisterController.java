package controller;

import dao.UserDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.User;
import view.Login;
import view.Register;

public class RegisterController implements ActionListener {

    private Register register;
    private User user;
    private UserDao userDao;

    public RegisterController(Register register) {
        this.register = register;
    }

    public void addUser() {
        String fullName = register.getTxtFullName();
        String userName = register.getTxtUserName();
        String password = register.getTxtPassword();
        String gender = register.getCmbGender();
        String jabatan = register.getCmbRole();
        this.user = new User(fullName, userName, password, gender, jabatan);
        userDao.addData(user);
    }

    public void validationPassword() {

        String Passvalidation = register.getTxtPassword();

        if (user.isValidPassword()) {
            register.setTxtWarning("Password valid!");
            JOptionPane.showMessageDialog(register, "Registration Successful!");
            addUser();
            register.dispose();
            Login l = new Login();
            l.setVisible(true);
        } else {
            System.out.println("Password : " + Passvalidation);
            register.setTxtWarning("Password Not Match");
            register.setTxtPassword("");
            register.setTxtRepass("");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String repass = register.getTxtRepass();
        String fullName = register.getTxtFullName();
        String userName = register.getTxtUserName();
        String password = register.getTxtPassword();
        String gender = register.getCmbGender();
        String jabatan = register.getCmbRole();
        this.user = new User(fullName, userName, password, gender, jabatan);
        this.userDao = new UserDao(password);
        if (user.getFullName().isEmpty() || user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            // Tampilkan pesan kesalahan jika tidak diisi
            JOptionPane.showMessageDialog(register, "Please fill in the whole field!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (user.getPassword().equals(repass)) {
                validationPassword();
            } else {
                register.setTxtWarning("Password Not Match");
                register.setTxtPassword("");
                register.setTxtRepass("");
            }
        }
    }

}
