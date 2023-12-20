package model;

public class DetailPesanan extends DetailTransaksi {

    public DetailPesanan(int idTransaksi, int kodeBarang, int kuantitas, int subTotal) {
        super(idTransaksi, kodeBarang, kuantitas, subTotal);
    }

    public DetailPesanan() {

    }
}
