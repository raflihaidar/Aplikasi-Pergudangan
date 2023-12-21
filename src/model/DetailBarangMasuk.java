package model;
public class DetailBarangMasuk extends DetailTransaksi {

    public DetailBarangMasuk(int idBarangMasuk, int kodeBarang, int kuantitas, int subtotal) {
        super(idBarangMasuk, kodeBarang, kuantitas, subtotal);
    }

    public DetailBarangMasuk() {
    }
}
