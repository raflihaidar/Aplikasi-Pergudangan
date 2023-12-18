package model;

public class DetailPesanan extends DetailTransaksi {

    private int id;

    public DetailPesanan(int idPesanan, int kodeBarang, int kuantitas, int subTotal) {
        super(idPesanan, kodeBarang, kuantitas, subTotal);
    }

    public DetailPesanan() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
