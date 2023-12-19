package model;

public class BarangMasuk extends Transaksi {

    public BarangMasuk(Pemesanan pemesanan, int jumlah) {
        super(pemesanan, jumlah);
    }

    public BarangMasuk(int idUser, int idDistributor, String tgl_masuk, int jumlah) {
        super(idUser, idDistributor, tgl_masuk, jumlah);
    }

    public BarangMasuk() {
    }
}
