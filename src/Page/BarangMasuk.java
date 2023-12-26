package Page;

import Components.TableActionCellEditor;
import Components.TableActionCellRender;
import Components.TableActionEvent;
import controller.BarangMasukController;
import helper.Util;
import java.awt.Font;
import view.MainMenus;

public class BarangMasuk extends javax.swing.JPanel {

    Font font = new Font("Poppins", Font.BOLD, 18);

    public BarangMasuk(MainMenus main) {
        initComponents();
        BarangMasukController controller = new BarangMasukController(table1);
        controller.getData();

        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                DetailBarangMasuk_Page detail = new DetailBarangMasuk_Page(row, table1, "Barang Masuk");
                controller.getSingleData(row, detail);
                Util.changePage(detail, main);
            }

            @Override
            public void onDelete(int row) {
                try {
                    controller.deleteData();
                } catch (Exception e) {
                    System.out.println("Error : " + e.getMessage());
                }
            }

            @Override
            public void onAdd(int row) {
                System.out.println("View row : " + row);
            }
        };
        table1.getColumnModel().getColumn(6).setCellRenderer(new TableActionCellRender());
        table1.getColumnModel().getColumn(6).setCellEditor(new TableActionCellEditor(event));
        title.setFont(font);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tblPesanan = new javax.swing.JScrollPane();
        table1 = new Components.Table();
        title = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setLayout(new java.awt.CardLayout());

        table1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Kode Barang Masuk", "Id User", "Id Distributor", "Tanggal", "Jumlah", "Status", "Action"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tblPesanan.setViewportView(table1);

        jPanel2.add(tblPesanan, "card2");

        title.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 0));
        title.setText("Barang Masuk");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/search.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 168,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                        .createSequentialGroup()
                                                        .addComponent(jTextField1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 239,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 944,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(38, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 336,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(51, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private Components.Table table1;
    private javax.swing.JScrollPane tblPesanan;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
