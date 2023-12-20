package model;

public class DetailBarangKeluar extends DetailTransaksi {

    public DetailBarangKeluar(int idBarangKeluar, int kodeBarang, int kuantitas, int subtotal) {
        super(idBarangKeluar, kodeBarang, kuantitas, subtotal);
    }

    public DetailBarangKeluar() {
    }
}
