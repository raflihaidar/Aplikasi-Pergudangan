package services;

import java.sql.*;
import model.DetailTransaksi;


public interface DetailTransaksi_Service {
    public void addData(DetailTransaksi detail);
    public ResultSet getSingleData(int kode_barang_keluar);
}
