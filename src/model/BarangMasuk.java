package model;

public class BarangMasuk extends Transaksi {

    public BarangMasuk(int idUser, int idDistributor, String tanggal, int jumlah) {
        super(idUser, idDistributor, tanggal, jumlah);
    }

    public BarangMasuk() {
    }
}
