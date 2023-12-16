package model;

public class Barang {

    private int kode;
    private String nama;
    private int harga;
    private int stok;
    private Satuan satuan = new Satuan();
    private Kategori kategori = new Kategori();

    public Barang(int kode, String nama, int harga, int stok, int kategori, int satuan) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.kategori.setKode(kategori);
        this.satuan.setKode(satuan);
    }

    public Barang() {
    }

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getHarga() {
        return harga;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getStok() {
        return stok;
    }

    public String getSatuan() {
        return satuan.getSatuan();
    }

    public int getKodeSatuan() {
        return satuan.getKode();
    }

    public void setSatuan(String satuan) {
        this.satuan.setSatuan(satuan);
    }

    public void setKodeSatuan(int kode) {
        this.satuan.setKode(kode);
    }

    public String getKategori() {
        return kategori.getKategori();
    }

    public int getKodeKategori() {
        return kategori.getKode();
    }

    public void setKategori(String kategori) {
        this.kategori.setKategori(kategori);
    }

    public void setKodeKategori(int kode) {
        this.kategori.setKode(kode);
    }
}
