package model;

import services.PasswordValidator;

public class User implements PasswordValidator {

    private int id;
    private String fullName;
    private String email;
    private String noHp;
    private String alamat;
    private String tglAktif;
    private String username;
    private String password;
    private String tglLahir;
    private Jabatan jabatan = new Jabatan();
    private Gender gender = new Gender();
    private Status status = new Status();
    private boolean isAuthenticated;

    public User(int id, String username, String password, String fullName, String email, String noHp, String tglLahir, String alamat, String tglAktif, int kodeJabatan, int kodeGender, int kodeStatus, boolean isAuthenticated) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.noHp = noHp;
        this.alamat = alamat;
        this.tglAktif = tglAktif;
        this.username = username;
        this.password = password;
        this.tglLahir = tglLahir;
        this.jabatan.setKode(kodeJabatan);
        this.gender.setKode(kodeGender);
        this.status.setKode(kodeStatus);
        this.isAuthenticated = isAuthenticated;
    }

    public User(String fullname, String username, String password, int kodeJabatan, int kodeGender) {
        this(0, username, password, fullname, null, null, null, null, null, kodeJabatan, kodeGender, 0, false);
    }

    public User(int id, String fullname, String username, String email, String noHp, String alamat, int kodeJabatan, int kodeStatus) {
        this(id, username, null, fullname, email, noHp, null, alamat, null, kodeJabatan, 0, kodeStatus, false);
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username) {
        this.username = username;
    }

    public User(int id) {
        this.id = id;
    }

    public User() {
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

    public Status getStatus() {
        return status;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }

    public boolean isIsAuthenticated() {
        return isAuthenticated;
    }

    public void setIsAuthenticated(boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }

    public Gender getGender() {
        return gender;
    }

    public Jabatan getJabatan() {
        return jabatan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    @Override
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
