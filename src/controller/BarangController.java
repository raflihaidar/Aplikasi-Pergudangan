package controller;

import Form.PopUpBarang;
import dao.Barang_Dao;
import dao.Getter_Dao;
import helper.BarangQueries;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.Barang;

public class BarangController {

    private JTable table;
    private PopUpBarang popUp;
    private Barang barang;
    private List<Barang> data;
    private Barang_Dao barangDao;
    private Getter_Dao getterDao;

    public BarangController() {
        barang = new Barang();
        getterDao = new Getter_Dao();
    }

    public BarangController(JTable table) {
        this.table = table;
        barang = new Barang();
        barangDao = new Barang_Dao();
        getterDao = new Getter_Dao();
    }

    public BarangController(PopUpBarang popUp, JTable table) {
        this.popUp = popUp;
        this.table = table;
        barang = new Barang();
        barangDao = new Barang_Dao();
        getterDao = new Getter_Dao();
    }

    public void getData(DefaultTableModel model) {
        ResultSet result = getterDao.getData(BarangQueries.SELECT_ALL_DATA);
        try {
            while (result.next()) {
                Barang barang = new Barang();
                barang.setKode(result.getInt("kode"));
                barang.setNama(result.getString("nama"));
                barang.setHarga(result.getInt("harga"));
                barang.setStok(result.getInt("stok"));
                barang.setKategori(result.getString("kategori"));
                barang.setSatuan(result.getString("satuan"));
                model.addRow(new Object[]{barang.getKode(), barang.getNama(), barang.getHarga(), barang.getStok(), barang.getKategori(), barang.getSatuan()});
            }
            table.setModel(model);
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBarang() {
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int row = table.getSelectedRow();
            int kode = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
            barangDao.deleteData(kode);
            if (table.isEditing()) {
                table.getCellEditor().stopCellEditing();
            }
            model = (DefaultTableModel) table.getModel();
            model.removeRow(row);
            System.out.println("delete data berhasil");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void addDataBarang(JTable table) {
        int kode = popUp.getKode();
        String nama = popUp.getName();
        int harga = popUp.getHarga();
        int stok = popUp.getStok();
        int kode_kategori = popUp.getKodeKategori();
        int kode_satuan = popUp.getKodeSatuan();
        String kategori = popUp.getKategori();
        String satuan = popUp.getSatuan();
        System.out.println(harga);
        System.out.println(stok);
        this.barang = new Barang(kode, nama, harga, stok, kode_kategori, kode_satuan);
        int kodeBarang = barangDao.addData(barang);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{kodeBarang, nama, harga, stok, kategori, satuan});
        table.setModel(model);
    }

    public void getSingleData(int row, JTable table, PopUpBarang popUp) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String username = model.getValueAt(row, 0).toString();
        data = barangDao.getSingleData(username);
        for (Barang barang : data) {
            popUp.setKode(String.valueOf(barang.getKode()));
            popUp.setName(barang.getNama());
            popUp.setHarga(String.valueOf(barang.getHarga()));
            popUp.setStok(String.valueOf(barang.getStok()));
            popUp.setKategori(barang.getKodeKategori() - 1);
            popUp.setSatuan(barang.getKodeSatuan() - 1);
        }
    }

    public void updateDataBarang(int row) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        barang = new Barang(popUp.getKode(), popUp.getName(), popUp.getHarga(), popUp.getStok(), popUp.getKodeKategori(), popUp.getKodeSatuan());
        System.out.println(popUp.getStok());
        barangDao.updateData(barang);
        JOptionPane.showMessageDialog(null, "Berhasil Update Data");
        model.setRowCount(0);
        getData(model);
    }

    public String getTotalBarang() {
        ResultSet result = getterDao.getData(BarangQueries.GET_TOTAL_BARANG);
        int total = 0;
        try {
            while (result.next()) {
                total = result.getInt(1);
            }
            result.close();
            return String.valueOf(total);
        } catch (SQLException e) {
            e.printStackTrace();
            return String.valueOf(total);
        }
    }
}
