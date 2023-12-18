package services;

import java.sql.ResultSet;
import model.DetailPesanan;

public interface DetailPesanan_Service {
    public void addData(DetailPesanan detail);
    public ResultSet getSingleData(int idPesanan);
}
