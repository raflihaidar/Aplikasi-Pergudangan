package model;

public class Pemesanan extends Transaksi {

    public Pemesanan(int id, int idDistributor, int total) {
        super(id, idDistributor, total);
    }

    public Pemesanan(int idUser) {
        super(idUser);
    }

    public Pemesanan() {
    }
}
