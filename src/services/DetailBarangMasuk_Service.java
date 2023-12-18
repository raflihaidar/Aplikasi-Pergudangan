package services;

import java.sql.ResultSet;
import model.DetailBarangMasuk;

public interface DetailBarangMasuk_Service {
    public void addData(DetailBarangMasuk detail);
    public ResultSet getSingleData(int kode_barang_masuk);
}
