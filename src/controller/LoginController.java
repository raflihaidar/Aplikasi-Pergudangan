package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.UserModel;
import view.Login;
import view.MainMenus;

public class LoginController implements ActionListener{
    private Login login;
    private UserModel user;
    
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
        user = new UserModel(login.getTxtUsername(), login.getTxtPassword());
        if(!loginUser()){
            login.setTxtWarning("Username or Password is Invalid");
            login.setTxtUsername("");;
            login.setTxtPassword("");
            user.updateStatus(0, user.getUsername());
        }else{
            JOptionPane.showMessageDialog(login, "Login Successful!");
            login.dispose();
            user.updateStatus(1, user.getUsername());
            MainMenus r = new MainMenus(username);
            r.setVisible(true);
        }
    }
    
}
