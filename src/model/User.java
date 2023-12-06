package model;

import view.Register;

public class User {
    private String username;
    private String password;
    private String fullName;
    private String gender;
    private String role;
    
    public User(Register register){
       this.fullName = register.getTxtFullName();
       this.username = register.getTxtUserName();
       this.password = register.getTxtPassword();
       this.gender = (String) register.getCmbGender();
       this.role = (String) register.getCmbRole();
    }
    
    public User(){
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    
    public void setPassword(String username){
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
     
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    
    public String getFullName(){
        return fullName;
    }
     
    public void setGender(String gender){
        this.gender = gender;
    }
    
    public String getGender(){
        return gender;
    }
    
    public void setRole(String role){
        this.role = role;
    }
    
    public String getRole(){
        return role;
    }
    
        
    public boolean isValidPassword() {
        // Memeriksa panjang minimal
        if (this.password.length() < 8) {
            return false;
        }

        // Memeriksa keberadaan angka
        if (!this.password.matches(".*\\d.*")) {
            return false;
        }

        // Memeriksa keberadaan huruf besar
        if (!this.password.matches(".*[A-Z].*")) {
            return false;
        }
        return true;
    }
}
