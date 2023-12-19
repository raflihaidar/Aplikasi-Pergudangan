package services;

import java.util.List;
import model.Transaksi;

public interface BarangKeluar_Service {
    public void addData(Transaksi transaksi);
    
    public List<Transaksi> getSingleData(int id);
    
    public void updateData(int idStatus, String keterangan, int id);
     
    public void deleteData(int id);
}
