package model;

public class BarangKeluar extends Transaksi {

    public BarangKeluar(int idUser, int total, int jumlah) {
        super(0, idUser, 0, null, total, jumlah, null, 0);
    }

    public BarangKeluar() {
    }
}
