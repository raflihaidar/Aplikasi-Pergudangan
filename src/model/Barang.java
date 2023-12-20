package model;

public class Barang {

    private int kode;
    private String nama;
    private int harga;
    private int stok;
    private Satuan satuan = new Satuan();
    private Kategori kategori = new Kategori();

    public Barang(int kode, String nama, int harga, int stok, int kodekategori, int kodeSatuan) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.kategori.setKode(kodekategori);
        this.satuan.setKode(kodeSatuan);
    }

    public Barang(int kode) {
        this.kode = kode;
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

    public Satuan getSatuan() {
        return satuan;
    }

    public Kategori getKategori() {
        return kategori;
    }
}
