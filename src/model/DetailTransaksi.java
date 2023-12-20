package model;

public class DetailTransaksi {

    private int idTransaksi;
    private Barang barang = new Barang();
    private int kuantitas;
    private int subTotal;

    public DetailTransaksi(int id, int kodeBarang, int kuantitas, int subTotal) {
        this.idTransaksi = id;
        this.barang.setKode(kodeBarang);
        this.kuantitas = kuantitas;
        this.subTotal = subTotal;
    }

    public DetailTransaksi(int kodeBarang, int kuantitas, int subTotal) {
        this(0, kodeBarang, kuantitas, subTotal);
    }

    public DetailTransaksi() {
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int id) {
        idTransaksi = id;
    }

    public Barang getBarang() {
        return barang;
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
