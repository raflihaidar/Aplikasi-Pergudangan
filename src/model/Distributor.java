package model;

public class Distributor {

    private int id;
    private String nama;
    private String no_tlp;
    private String email;
    private String alamat;
    private String tanggalDaftar;

    public Distributor(String nama, String alamat, String no_tlp) {
        this.nama = nama;
        this.alamat = alamat;
        this.no_tlp = no_tlp;
    }

    public Distributor() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTanggalDaftar() {
        return tanggalDaftar;
    }

    public void setTanggalDaftar(String tanggalDaftar) {
        this.tanggalDaftar = tanggalDaftar;
    }

    public String getNama() {
        return nama;
    }

    public String getTelepon() {
        return no_tlp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setNama(String Nama) {
        this.nama = Nama;
    }

    public void setTelepon(String Telepon) {
        this.no_tlp = Telepon;
    }

    public void setAlamat(String Alamat) {
        this.alamat = Alamat;
    }
}
