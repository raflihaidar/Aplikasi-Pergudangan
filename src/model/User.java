package model;

public class User {

    private int id;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String noHp;
    private String tglLahir;
    private String alamat;
    private String tglAktif;
    private Jabatan jabatan = new Jabatan();
    private Gender gender = new Gender();
    private Status status = new Status();
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
        return status.getStatus();
    }

    public int getKodeStatus() {
        return status.getKode();
    }

    public void setStatus(String status) {
        this.status.setStatus(status);
    }
    
    public void setKodeStatus(int kode) {
        this.status.setKode(kode);
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
        return gender.getGender();
    }

    public int getKodeGender() {
        return gender.getKode();
    }

    public void setGender(String gender) {
        this.gender.setGender(gender);
    }

    public void setGender(int gender) {
        this.gender.setKode(gender);
    }

    public String getJabatan() {
        return jabatan.getJabatan();
    }

    public int getKodeJabatan() {
        return jabatan.getKode();
    }

    public void setJabatan(String jabatan) {
        this.jabatan.setJabatan(jabatan);
    }

    public void setKodeJabatan(int jabatan) {
        this.jabatan.setKode(jabatan);
    }

    public boolean isIsAuthenticated() {
        return isAuthenticated;
    }

    public void setIsAuthenticated(boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }

    public User(String fullname, String username, String password, int kode_gender, int kode_jabatan) {
        this.fullName = fullname;
        this.username = username;
        this.password = password;
        this.gender.setKode(kode_gender);
        this.jabatan.setKode(kode_jabatan);
    }

    public User(int id, String fullname, String username, String email, String noHp, String alamat, int kode_jabatan, int kode_status) {
        this.id = id;
        this.fullName = fullname;
        this.username = username;
        this.email = email;
        this.noHp = noHp;
        this.alamat = alamat;
        this.status.setKode(kode_status);
        this.jabatan.setKode(kode_jabatan);
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
