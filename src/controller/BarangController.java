package controller;

import Form.PopUpBarang;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.BarangModel;
import model.ComboBoxModel;

public class BarangController {
    private JTable table;
    private JTextField namaBarang;
    private JTextField hargaBarang;
    private JTextField stokBarang;
    private JComboBox<String> kategoriBarang;
    private JComboBox<String> satuanBarang;
    private BarangModel barang;

    public BarangController(JTable table) {
        this.table = table;
        barang = new BarangModel();
    }

    public BarangController(JTextField namaBarang, JTextField hargaBarang, JTextField stokBarang, JComboBox<String> kategoriBarang, JComboBox<String> satuanBarang,JTable table) {
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.stokBarang = stokBarang;
        this.kategoriBarang = kategoriBarang;
        this.satuanBarang = satuanBarang;
        barang = new BarangModel(namaBarang.getText(),
                                Integer.parseInt(hargaBarang.getText()),
                                Integer.parseInt(stokBarang.getText()),
                                satuanBarang.getSelectedIndex() + 1,
                                kategoriBarang.getSelectedIndex() + 1
                                );
        this.table = table;
    }

    public void showAllData(DefaultTableModel model) {
        table.setModel(barang.getData(model));
    }

    public void deleteBarang() {
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int row = table.getSelectedRow();
            int kode = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
            barang.deleteData(kode);
            if (table.isEditing()) {
                table.getCellEditor().stopCellEditing();
            }
            model = (DefaultTableModel) table.getModel();
            model.removeRow(row);
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void addDataBarang(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String namaBarang = this.namaBarang.getText();
        int hargaBarang = Integer.parseInt(this.hargaBarang.getText());
        int stokBarang = Integer.parseInt(this.stokBarang.getText());
        int kode_kategori = kategoriBarang.getSelectedIndex() + 1;
        int kode_satuan = satuanBarang.getSelectedIndex() + 1;
        int kodeBarang = barang.addData(namaBarang, hargaBarang, stokBarang, kode_kategori, kode_satuan);
        
        String kategori = ComboBoxModel.getRefrence("kategori", "nama", kode_kategori);
        String satuan = ComboBoxModel.getRefrence("satuan", "nama", kode_satuan);
        model.addRow(new Object[] { kodeBarang, namaBarang, hargaBarang, stokBarang, kategori, satuan });
        table.setModel(model);
    }
    
    public void getSingleData(int row, JTable table, PopUpBarang modal){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int kodeBarang = (int) model.getValueAt(row, 0);
        ResultSet rs = barang.getSingleData(kodeBarang);
        try{
            if(rs.next()){
                modal.setName(rs.getString("nama"));
                modal.setHarga(String.valueOf(rs.getInt("harga")));
                modal.setStok(String.valueOf(rs.getInt("stok")));
                modal.setKategori(rs.getString("kategori"));
                modal.setSatuan(rs.getString("satuan"));
            }
            rs.close();
        }catch(Exception e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public void updateDataBarang(int row){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int kodeBarang = (int) table.getValueAt(row, 0);
        barang.updateData(kodeBarang);
        model.setRowCount(0);
        table.setModel(barang.getData(model));
    }
}
