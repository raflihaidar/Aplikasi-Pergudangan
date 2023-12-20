package model;

public class Satuan {

    private int kode;
    private String satuan;

    public Satuan(int kode) {
        this.kode = kode;
    }

    public Satuan() {
    }

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }
}
