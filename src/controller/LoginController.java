package controller;

import config.Config;
import helper.UserQueries;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import view.Login;
import view.MainMenus;

public class LoginController implements ActionListener{
    private Login login;
    
    public LoginController(Login login){
        this.login = login;
    }
    
    public boolean loginUser(String username, String password) {
        boolean isSuccess = false;

        try (Connection con = Config.connectDB();
            PreparedStatement ps = con.prepareStatement(UserQueries.SEARCH_USER)) {

            ps.setString(1, username);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Data ditemukan, login berhasil
                    isSuccess = true;
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return isSuccess;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = login.getTxtUsername();
        String password = login.getTxtPassword();
        
        if(!loginUser(username, password)){
            login.setTxtWarning("Username or Password is Invalid");
            login.setTxtUsername("");;
            login.setTxtPassword("");
        }else{
            JOptionPane.showMessageDialog(login, "Login Successful!");
            login.dispose();
            MainMenus r = new MainMenus();
            r.setVisible(true);
        }
    }
    
}
