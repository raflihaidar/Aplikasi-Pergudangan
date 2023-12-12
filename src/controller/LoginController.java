package controller;

import dao.UserDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.Login;
import view.MainMenus;

public class LoginController implements ActionListener{
    private Login login;
    private UserDao userDao;
    
    public LoginController(Login login){
        this.login = login;
    }
    
    public boolean loginUser(){
        boolean isSuccess = userDao.authentication();
        return isSuccess;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = login.getTxtUsername();
        userDao = new UserDao(login.getTxtUsername(), login.getTxtPassword());
        if(!loginUser()){
            login.setTxtWarning("Username or Password is Invalid");
            login.setTxtUsername("");;
            login.setTxtPassword("");
            userDao.updateAuthentication(0);
        }else{
            JOptionPane.showMessageDialog(login, "Login Successful!");
            login.dispose();
            userDao.updateAuthentication(1);
            MainMenus r = new MainMenus(username);
            r.setVisible(true);
        }
    }
    
}
