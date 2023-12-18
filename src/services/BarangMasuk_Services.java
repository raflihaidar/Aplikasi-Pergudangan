package services;

import java.util.List;
import model.BarangMasuk;

public interface BarangMasuk_Services {

    public int addData(BarangMasuk barang);

    public List<BarangMasuk> getSingleData(int Kode);
    
    public void updateData(int status, String keterangan, int id);
}
