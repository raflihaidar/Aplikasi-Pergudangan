package controller;

import Form.ListBarang;
import javax.swing.JButton;
import javax.swing.JTable;

public class TableController {

    private JTable table;
    private ListBarang listBarang;
    private BarangKeluarController bkController;
    private DetailBarangKeluarController detailController;

    public TableController(ListBarang listBarang, JTable table, JTable tableParent, JButton button) {
        this.table = table;
        bkController = new BarangKeluarController(tableParent);
        detailController = new DetailBarangKeluarController(table);
        this.listBarang = listBarang;
    }

    public void updateSubtotal(int kolomKuantitas, int kolomHarga, int kolomSubtotal) {
        int selectedRow = table.getSelectedRow();
        Object kuantitasObj = table.getValueAt(selectedRow, kolomKuantitas);
        Object hargaObj = table.getValueAt(selectedRow, kolomHarga);

        if (kuantitasObj != null && hargaObj != null) {
            try {
                int kuantitas = Integer.parseInt(kuantitasObj.toString());
                int harga = Integer.parseInt(hargaObj.toString());
                int subTotal = kuantitas * harga;
                table.setValueAt(subTotal, selectedRow, kolomSubtotal);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void updateTotal() {
        int total = 0;
        int jumlah = 0;

        for (int i = 0; i < table.getRowCount(); i++) {
            Boolean currentChecked = (Boolean) table.getValueAt(i, 8);

            Object value = table.getValueAt(i, 7);
            if (currentChecked != null && currentChecked && value != null) {
                int subtotal = Integer.parseInt(value.toString());
                if (subtotal != 0) {
                    total += subtotal;
                    jumlah++;
                }
            }

            listBarang.setJumlahBarang(String.valueOf(jumlah));
            listBarang.setTotal("Rp " + String.valueOf(total));
        }
    }

    public void addData() {
        int total = 0;
        int jumlah = 0;
        boolean isChecked = false;
        
        for (int i = 0; i < table.getRowCount(); i++) {
            Boolean currentChecked = (Boolean) table.getValueAt(i, 8);
            if (currentChecked != null && currentChecked) {
                isChecked = true;
                total += Integer.parseInt(table.getValueAt(i, 7).toString());
                jumlah++;
            }
        }
        
        if (isChecked) {
            bkController.addData(total, jumlah);
            bkController.getData();
            detailController.addDataBarang();
            listBarang.dispose();
        }
    }
}
