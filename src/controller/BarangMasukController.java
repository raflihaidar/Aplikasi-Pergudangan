package controller;

import Page.DetailPemesanan;
import dao.BarangMasuk_Dao;
import dao.ComboBox_Dao;
import model.BarangMasuk;
import dao.Getter_Dao;
import helper.BarangMasukQueries;
import helper.DistributorQueries;
import helper.UserQueries;
import javax.swing.JTable;
import model.Pemesanan;
import java.sql.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Page.DetailBarangMasuk_Page;

public class BarangMasukController {

    private JTable table;
    private Getter_Dao getterDao;
    private BarangMasuk_Dao barangMasukDao;
    private BarangMasuk barang;
    private Pemesanan pemesanan;
    private DetailPemesanan detail;
    private ComboBox_Dao cb;
    private List<BarangMasuk> data;

    public BarangMasukController(DetailPemesanan detail) {
        this.detail = detail;
        getterDao = new Getter_Dao();
        barang = new BarangMasuk();
        barangMasukDao = new BarangMasuk_Dao();
        cb = new ComboBox_Dao();
    }

    public BarangMasukController(JTable table) {
        this.table = table;
        getterDao = new Getter_Dao();
        barang = new BarangMasuk();
        barangMasukDao = new BarangMasuk_Dao();
        cb = new ComboBox_Dao();
    }

    public void getData() {
        ResultSet result = getterDao.getData(BarangMasukQueries.GET_DATA_BARANG_MASUK);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        try {
            while (result.next()) {
                BarangMasuk barang = new BarangMasuk();
                barang.setIdPemesanan(result.getInt("id"));
                barang.setUsername(result.getString("user"));
                barang.setDistributor(result.getString("distributor"));
                barang.setTanggalMasuk(result.getString("tgl_masuk"));
                barang.setStatusPemesanan(result.getString("status"));
                barang.setJumlah(result.getInt("jumlah"));
                model.addRow(new Object[]{barang.getIdPemesanan(), barang.getUsername(), barang.getDistributor(), barang.getTanggalMasuk(), barang.getJumlah(), barang.getStatusPemesanan()});
            }
            table.setModel(model);
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getSingleData(int row, DetailBarangMasuk_Page detail) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int id = Integer.parseInt(model.getValueAt(row, 0).toString());
        data = barangMasukDao.getSingleData(id);
        for (BarangMasuk barang : data) {
            detail.setTxtUser(String.valueOf(barang.getUsername()));
            detail.setTxtTglPemesanan(String.valueOf(barang.getTanggalMasuk()));
            detail.setTxtDistributor(String.valueOf(barang.getDistributor()));
            detail.setTxtAlamatDistributor(barang.getAlamatDistributor());
            detail.setTxtIdPemesanan(String.valueOf(barang.getIdPemesanan()));
            detail.setTxtStatus(barang.getStatusPemesanan());
            detail.setTxtKeterangan(barang.getKeterangan());
        }
    }

    public void addDataBarang() {
        int idUser = cb.getDataById(UserQueries.SELECT_ID_BY_NAME, "id", detail.getTxtUser());
        int idDistributor = cb.getDataById(DistributorQueries.SELECT_ID, "id", detail.getDistributor());
        System.out.println("id user " + idUser);
        System.out.println("id distributor " + idDistributor);
        System.out.println("nama dsitributor " + detail.getDistributor());
        String tanggal = detail.getTxtTglPemesanan();
        int jumlah = detail.getJumlahBarang();
        this.barang = new BarangMasuk(idUser, idDistributor, tanggal, jumlah);
        barangMasukDao.addData(barang);
    }
}