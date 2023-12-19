package Page;

import Form.PopUpDistributor;
import Components.TableActionCellEditor;
import Components.TableActionCellRender;
import Components.TableActionEvent;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import controller.DistributorController;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author rafli
 */
public class Distributor extends javax.swing.JPanel {

    /**
     * Creates new form Distributor
     */
    Font font = new Font("Poppins", Font.BOLD,18);
    public Distributor() {
        initComponents();
        title.setFont(font);
        DistributorController controller = new DistributorController(table1);
        controller.getData((DefaultTableModel) table1.getModel());
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                PopUpDistributor dialog = new PopUpDistributor(table1, true, row);
                controller.getSingleData(row, table1, dialog);
                dialog.setLocationRelativeTo(Distributor.this);
                dialog.setModal(true);
                dialog.getContentPane().setBackground(Color.WHITE);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                if (table1.isEditing()) {
                    table1.getCellEditor().stopCellEditing();
                }
                controller.deleteData();
            }

            @Override
            public void onAdd(int row) {
                System.out.println("View row : " + row);
            }
        };
        table1.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        table1.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new Components.Table();
        btnAdd = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        title.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 0));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("DISTRIBUTOR");

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Distributor", "Nama Distributor", "No Telepon", "Alamat Distributor", "Tanggal Daftar", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                table1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(table1);

        btnAdd.setBackground(new java.awt.Color(51, 153, 255));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        btnAdd.setText("Tambah Distributor");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 956, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnAdd)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        PopUpDistributor dialog = new PopUpDistributor(table1, false, 0);
        dialog.setLocationRelativeTo(this); // Center the dialog relative to the Distributor panel

        dialog.setModal(true);
        dialog.getContentPane().setBackground(Color.WHITE);

        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        dialog.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void table1AncestorAdded(javax.swing.event.AncestorEvent evt) {// GEN-FIRST:event_table1AncestorAdded
        // TODO add your handling code here:

    }// GEN-LAST:event_table1AncestorAdded

    private void btnAdddistribActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAdddistribActionPerformed
        // TODO add your handling code here:
        try {
            // Create a JDialog as the parent for the PopUpDistributor panel
            JDialog dialog = new JDialog();

            // Create an instance of PopUpDistributor
            PopUpDistributor addDistributorPanel = new PopUpDistributor(table1, false, 0);

            // Add the PopUpDistributor panel to the dialog
            dialog.getContentPane().add(addDistributorPanel);

            // Set properties for the dialog (adjust as needed)
            dialog.setSize(465, 450);
            dialog.setLocationRelativeTo(this); // Center the dialog relative to the Distributor panel

            // Make the dialog modal, blocking input to other windows
            dialog.setModal(true);

            // Set the default close operation to dispose the dialog
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            // Set the dialog visible
            dialog.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
        }
    }// GEN-LAST:event_btnAdddistribActionPerformed

    private void btnAdddistribMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnAdddistribMouseClicked
        // TODO add your handling code here:

    }// GEN-LAST:event_btnAdddistribMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.Table table1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

}