package services;

import java.util.List;
import model.Transaksi;

public interface Pemesanan_Service {

    public List<Transaksi> getSingleData(int Kode);
    
     public int getLastId();

    public void addData(Transaksi transaksi);

    public void updateData(Transaksi transaksi);
    
    public void updateDetailData(int kodeStatus, int idPemesanan);

    public void deleteData(int kode);
    
    public void terminateOrder(int id);
}
