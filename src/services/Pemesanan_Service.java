package services;

import java.util.List;
import model.Pemesanan;

public interface Pemesanan_Service {

    public List<Pemesanan> getSingleData(int Kode);
    
     public int getLastId();

    public void addData(Pemesanan pemesanan);

    public void updateData(Pemesanan pemesanan);

    public void deleteData(int kode);
}
