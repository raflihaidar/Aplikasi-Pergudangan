package model;

public class DetailBarangKeluar extends DetailTransaksi {

    public DetailBarangKeluar(int kodeBarangKeluar, int kodeBarang, int kuantitas, int subtotal) {
        super(kodeBarangKeluar, kodeBarang, kuantitas, subtotal);
    }

    public DetailBarangKeluar() {
    }
}
