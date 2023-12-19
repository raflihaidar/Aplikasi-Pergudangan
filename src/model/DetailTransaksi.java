package model;

public class DetailTransaksi {

    private int idTransaksi;
    private Barang barang = new Barang();
    private int kuantitas;
    private int subTotal;

    public DetailTransaksi(int id, int kodeBarang, int kuantitas, int subTotal) {
        this.idTransaksi = id;
        barang.setKode(kodeBarang);
        this.kuantitas = kuantitas;
        this.subTotal = subTotal;
    }

    public DetailTransaksi(int kodeBarang, int kuantitas, int subTotal) {
        barang.setKode(kodeBarang);
        this.kuantitas = kuantitas;
        this.subTotal = subTotal;
    }

    public DetailTransaksi() {
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int id) {
        idTransaksi = id;
    }

    public int getBarang() {
        return barang.getKode();
    }

    public void setBarang(int kode) {
        this.barang.setKode(kode);
    }

    public String getNamaBarang() {
        return barang.getNama();
    }

    public void setNamaBarang(String nama) {
        this.barang.setNama(nama);
    }

    public int getKodeBarang() {
        return barang.getKode();
    }

    public void setKodeBarang(int id) {
        this.barang.setKode(id);
    }

    public int getHargaBarang() {
        return barang.getHarga();
    }

    public void setHargaBarang(int nama) {
        this.barang.setHarga(nama);
    }

    public int getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }
}
