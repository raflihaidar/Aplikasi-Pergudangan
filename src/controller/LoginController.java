package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.User;
import view.Login;
import view.MainMenus;

public class LoginController implements ActionListener{
    private Login login;
    private User user;
    
    public LoginController(Login login){
        this.login = login;
    }
    
    public boolean loginUser(){
        boolean isSuccess = user.authentication();
        return isSuccess;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = login.getTxtUsername();
        user = new User(login.getTxtUsername(), login.getTxtPassword());
        if(!loginUser()){
            login.setTxtWarning("Username or Password is Invalid");
            login.setTxtUsername("");;
            login.setTxtPassword("");
            user.updateAuthentication(0, user.getUsername());
        }else{
            JOptionPane.showMessageDialog(login, "Login Successful!");
            login.dispose();
            user.updateAuthentication(1, user.getUsername());
            MainMenus r = new MainMenus(username);
            r.setVisible(true);
        }
    }
    
}
