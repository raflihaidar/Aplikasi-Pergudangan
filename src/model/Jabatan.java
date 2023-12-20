package model;

public class Jabatan {

    private int kode;
    private String jabatan;

    public Jabatan(int kode) {
        this.kode = kode;
    }

    public Jabatan() {
    }

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
}
