package model;

public class DetailPesanan {
    
    private int id;
    private Pemesanan pemesanan = new Pemesanan();
    private Barang barang = new Barang();
    private int kuantitas;
    private int subTotal;
    
    public DetailPesanan(int idPesanan, int kodeBarang, int kuantitas, int subTotal) {
        pemesanan.setId(idPesanan);
        barang.setKode(kodeBarang);
        this.kuantitas = kuantitas;
        this.subTotal = subTotal;
    }
        
    public DetailPesanan() {
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getPemesanan() {
        return pemesanan.getId();
    }
    
    public void setPemesanan(int id) {
        this.pemesanan.setId(id);
    }
    
    public int getBarang() {
        return barang.getKode();
    }
    
    public void setBarang(int kode) {
        this.barang.setKode(kode);
    }
    
    public int getKuantitas() {
        return kuantitas;
    }
    
    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }
    
    public int getSubTotal() {
        return subTotal;
    }
    
    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }
    
}
