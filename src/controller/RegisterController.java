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
    private User user;
    
    public RegisterController(Register register){
        this.register = register;
    }
    
    public void registUser(User user){
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
    
    public void validationPassword() {

       String Passvalidation = register.getTxtPassword();

        if (user.isValidPassword()) {
            register.setTxtWarning("Password valid!");
            JOptionPane.showMessageDialog(register, "Registration Successful!");
            registUser(user);
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
