package model;

public class Transaksi {

    private Pemesanan pemesanan = new Pemesanan();
    private int jumlah;
    private String keterangan;

    public Transaksi(Pemesanan pemesanan, int jumlah) {
        this.pemesanan = pemesanan;
        this.jumlah = jumlah;
    }

    public Transaksi(int idUser, int idDistributor, String tgl_masuk, int jumlah) {
        pemesanan.setIdUser(idUser);
        pemesanan.setIdDistributor(idDistributor);
        pemesanan.setTanggal(tgl_masuk);
        this.jumlah = jumlah;
    }

    public Transaksi(int idUser, int total, int jumlah) {
        pemesanan.setIdUser(idUser);
        pemesanan.setTotal(total);
        this.jumlah = jumlah;
    }

    public Transaksi() {
    }

    public int getIdPemesanan() {
        return pemesanan.getId();
    }

    public void setIdPemesanan(int id) {
        pemesanan.setId(id);
    }

    public String getStatusPemesanan() {
        return pemesanan.getStatus();
    }

    public void setStatusPemesanan(String status) {
        pemesanan.setStatus(status);
    }

    public int getKodeStatusPemesanan() {
        return pemesanan.getkodeStatus();
    }

    public void setKodeStatusPemesanan(int kode) {
        pemesanan.setKodeStatus(kode);
    }

    public int getTotalPemesanan() {
        return pemesanan.getTotal();
    }

    public void setTotalPemesanan(int total) {
        pemesanan.setTotal(total);
    }

    public int getIdUser() {
        return pemesanan.getIdUser();
    }

    public String getUsername() {
        return pemesanan.getUser();
    }

    public void setUsername(String nama) {
        pemesanan.setUser(nama);
    }

    public void setIdUser(int id) {
        pemesanan.setIdUser(id);
    }

    public int getIdDistributor() {
        return pemesanan.getIdDistributor();
    }

    public void setIdDistributor(int id) {
        pemesanan.setIdDistributor(id);
    }

    public String getDistributor() {
        return pemesanan.getDistributor();
    }

    public void setDistributor(String nama) {
        pemesanan.setDistributor(nama);
    }

    public String getAlamatDistributor() {
        return pemesanan.getAlamatDistributor();
    }

    public void setAlamatDistributor(String alamat) {
        pemesanan.setAlamatDistributor(alamat);
    }

    public String getTanggalMasuk() {
        return pemesanan.getTanggal();
    }

    public void setTanggalMasuk(String tanggal) {
        pemesanan.setTanggal(tanggal);
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
