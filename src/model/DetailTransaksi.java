package model;

public class DetailTransaksi {

    private Pemesanan pemesanan = new Pemesanan();
    Barang barang = new Barang();
    private int kuantitas;
    private int subTotal;

    public DetailTransaksi(int idPesanan, int kodeBarang, int kuantitas, int subTotal) {
        pemesanan.setId(idPesanan);
        barang.setKode(kodeBarang);
        this.kuantitas = kuantitas;
        this.subTotal = subTotal;
    }

    public DetailTransaksi(int kodeBarang, int kuantitas, int subTotal) {
        barang.setKode(kodeBarang);
        this.kuantitas = kuantitas;
        this.subTotal = subTotal;
    }

    public DetailTransaksi() {
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

    public String getNamaBarang() {
        return barang.getNama();
    }

    public void setNamaBarang(String nama) {
        this.barang.setNama(nama);
    }

    public int getKodeBarang() {
        return barang.getKode();
    }

    public void setKodeBarang(int id) {
        this.barang.setKode(id);
    }

    public int getHargaBarang() {
        return barang.getHarga();
    }

    public void setHargaBarang(int nama) {
        this.barang.setHarga(nama);
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
