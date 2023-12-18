package model;

/**
 *
 * @author rafli
 */
public class DetailBarangMasuk extends DetailTransaksi {

    private BarangMasuk barangMasuk = new BarangMasuk();

    public DetailBarangMasuk(int kodeBarang, int kodeBarangMasuk, int kuantitas, int subtotal) {
        super(kodeBarang, kuantitas, subtotal);
        barangMasuk.setIdPemesanan(kodeBarangMasuk);
    }

    public DetailBarangMasuk() {
    }

    public int getKodeBarangMasuk() {
        return barangMasuk.getIdPemesanan();
    }

    public void setKodeBarangMasuk(int id) {
        barangMasuk.setIdPemesanan(id);
    }
}
