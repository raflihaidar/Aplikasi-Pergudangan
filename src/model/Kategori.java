package model;

public class Kategori {

    private int kode;
    private String kategori;

    public Kategori(int kode) {
        this.kode = kode;
    }

    public Kategori() {
    }

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
