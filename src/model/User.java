package model;

import config.Config;
import helper.UserQueries;
import java.sql.*;

public class User {

    private int id;
    private String username;
    private String password;
    private String fullName;
    private String status;
    private String email;
    private String noHp;
    private String tglLahir;
    private String alamat;
    private String tglAktif;
    private String gender;
    private String jabatan;
    private boolean isAuthenticated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTglAktif() {
        return tglAktif;
    }

    public void setTglAktif(String tglAktif) {
        this.tglAktif = tglAktif;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return jabatan;
    }

    public void setRole(String jabatan) {
        this.jabatan = jabatan;
    }

    public boolean isIsAuthenticated() {
        return isAuthenticated;
    }

    public void setIsAuthenticated(boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }

    public User(String fullname, String username, String password, String gender, String jabatan) {
        this.fullName = fullname;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.jabatan = jabatan;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        System.out.println(username);
    }

    public User(String username) {
        this.username = username;
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
