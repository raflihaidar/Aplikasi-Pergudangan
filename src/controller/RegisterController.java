package controller;

import config.Config;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import model.User;
import view.Login;
import view.Register;
import helper.UserQueries;

public class RegisterController implements ActionListener{
    private Register register;
    private UserController controller;
    private User user;
    
    public RegisterController(Register register){
        this.register = register;
    }
    
    public void validationPassword() {

       String Passvalidation = register.getTxtPassword();

        if (user.isValidPassword()) {
            register.setTxtWarning("Password valid!");
            JOptionPane.showMessageDialog(register, "Registration Successful!");
            controller.addUser();
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
       this.user = new User(register);
       this.controller = new UserController(user);
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
