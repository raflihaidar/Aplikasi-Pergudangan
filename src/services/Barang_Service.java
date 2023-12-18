package services;

import model.Barang;
import java.util.List;

public interface Barang_Service {
    public List<Barang> getSingleData(String username);
    public int addData(Barang barang);
    public void updateData(Barang barang);
    public void deleteData(int kode);
    public void updateStok(int kuantitas, int kode);
}
