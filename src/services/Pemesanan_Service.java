package services;

import java.util.List;
import model.Pemesanan;

public interface Pemesanan_Service {

    public List<Pemesanan> getSingleData(int Kode);
    
     public int getLastId();

    public void addData(Pemesanan pemesanan);

    public void updateData(Pemesanan pemesanan);
    
    public void updateDetailData(int kodeStatus, int idPemesanan);

    public void deleteData(int kode);
    
    public void terminateOrder(int id);
}
