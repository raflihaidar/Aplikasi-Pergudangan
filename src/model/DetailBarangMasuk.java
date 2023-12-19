package model;

/**
 *
 * @author rafli
 */
public class DetailBarangMasuk extends DetailTransaksi {

    public DetailBarangMasuk(int kodeBarangMasuk, int kodeBarang, int kuantitas, int subtotal) {
        super(kodeBarangMasuk, kodeBarang, kuantitas, subtotal);
    }

    public DetailBarangMasuk() {
    }
}
