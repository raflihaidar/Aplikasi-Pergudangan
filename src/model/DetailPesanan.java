package model;

public class DetailPesanan extends DetailTransaksi {

    public DetailPesanan(int idPesanan, int kodeBarang, int kuantitas, int subTotal) {
        super(idPesanan, kodeBarang, kuantitas, subTotal);
    }

    public DetailPesanan() {
        
    }
}
