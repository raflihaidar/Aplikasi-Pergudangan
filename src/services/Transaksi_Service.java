package services;

import java.util.List;
import model.Transaksi;

public interface Transaksi_Service {
    
    public int addData(Transaksi transaksi);

    public List<Transaksi> getSingleData(int Kode);
    
    public void updateData(int status, String keterangan, int id);
    
    public void deleteData(int id);
    
}
