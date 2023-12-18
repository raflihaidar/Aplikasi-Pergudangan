package Form;

import controller.DistributorController;
import helper.TimeStampGenerate;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class PopUpDistributor extends javax.swing.JDialog {

    /**
     * Creates new form PopUpDistributor
     */
    private JTable table;
    private boolean isEdit;
    private int row;

    public PopUpDistributor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public PopUpDistributor(JTable table, boolean isEdit, int row) {
        initComponents();
        this.isEdit = isEdit;
        this.row = row;
        this.table = table;
        if (table.getModel().getRowCount() <= 0) {
            txtIdDistributor.setText(String.valueOf(1));
        } else {
            int lastRow = (int) table.getValueAt(table.getModel().getRowCount() - 1, 0);
            int id = lastRow + 1;
            txtIdDistributor.setText(String.valueOf(id));
        }
        txtTanggalDistributor.setText(TimeStampGenerate.generateTimeStamp());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTanggalDistributor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSubmitDsitributor = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtIdDistributor = new javax.swing.JTextField();
        txtAlamatDistributor = new javax.swing.JTextField();
        txtTeleponDistributor = new javax.swing.JTextField();
        txtNamaDistributor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        txtTanggalDistributor.setBackground(new java.awt.Color(255, 255, 255));
        txtTanggalDistributor.setForeground(new java.awt.Color(0, 0, 0));
        txtTanggalDistributor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTanggalDistributor.setEnabled(false);
        txtTanggalDistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTanggalDistributorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("FORM PENDAFTARAN DISTRIBUTOR");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nama          ");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("No Telepon ");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Alamat        ");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tanggal      ");

        btnSubmitDsitributor.setText("SUBMIT");
        btnSubmitDsitributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitDsitributorActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Id                 ");

        txtIdDistributor.setBackground(new java.awt.Color(255, 255, 255));
        txtIdDistributor.setForeground(new java.awt.Color(0, 0, 0));
        txtIdDistributor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtIdDistributor.setEnabled(false);
        txtIdDistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdDistributorActionPerformed(evt);
            }
        });

        txtAlamatDistributor.setBackground(new java.awt.Color(255, 255, 255));
        txtAlamatDistributor.setForeground(new java.awt.Color(0, 0, 0));
        txtAlamatDistributor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtAlamatDistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlamatDistributorActionPerformed(evt);
            }
        });

        txtTeleponDistributor.setBackground(new java.awt.Color(255, 255, 255));
        txtTeleponDistributor.setForeground(new java.awt.Color(0, 0, 0));
        txtTeleponDistributor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTeleponDistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTeleponDistributorActionPerformed(evt);
            }
        });

        txtNamaDistributor.setBackground(new java.awt.Color(255, 255, 255));
        txtNamaDistributor.setForeground(new java.awt.Color(0, 0, 0));
        txtNamaDistributor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNamaDistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaDistributorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSubmitDsitributor)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtIdDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtAlamatDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNamaDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5))
                                    .addGap(35, 35, 35)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(txtTeleponDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtTanggalDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))))))))
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtIdDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTeleponDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlamatDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTanggalDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btnSubmitDsitributor)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTanggalDistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTanggalDistributorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTanggalDistributorActionPerformed

    private void btnSubmitDsitributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitDsitributorActionPerformed
        // TODO add your handling code here:
        DistributorController distrib = new DistributorController(this, table);
        if (txtNamaDistributor.getText().isEmpty() || txtTanggalDistributor.getText().isEmpty() || txtTanggalDistributor.getText().isEmpty() || txtTeleponDistributor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in the whole field!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (isEdit) {
                distrib.updateDataDistributor(row);
            } else {
                distrib.addDataDistributor(table);
            }
        }

        this.setVisible(false);
    }//GEN-LAST:event_btnSubmitDsitributorActionPerformed

    private void txtIdDistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdDistributorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdDistributorActionPerformed

    private void txtAlamatDistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlamatDistributorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlamatDistributorActionPerformed

    private void txtTeleponDistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTeleponDistributorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTeleponDistributorActionPerformed

    private void txtNamaDistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaDistributorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaDistributorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmitDsitributor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAlamatDistributor;
    private javax.swing.JTextField txtIdDistributor;
    private javax.swing.JTextField txtNamaDistributor;
    private javax.swing.JTextField txtTanggalDistributor;
    private javax.swing.JTextField txtTeleponDistributor;
    // End of variables declaration//GEN-END:variables

    public String getTxtAlamatDistributor() {
        return txtAlamatDistributor.getText();
    }

    public void setTxtAlamatDistributor(String txtAlamatDistributor) {
        this.txtAlamatDistributor.setText(txtAlamatDistributor);
    }

    public String getTxtIdDistributor() {
        return txtIdDistributor.getText();
    }

    public void setTxtIdDistributor(String txtIdDistributor) {
        this.txtIdDistributor.setText(txtIdDistributor);
    }

    public String getTxtNamaDistributor() {
        return txtNamaDistributor.getText();
    }

    public void setTxtNamaDistributor(String txtNamaDistributor) {
        this.txtNamaDistributor.setText(txtNamaDistributor);
    }

    public String getTxtTanggalDistributor() {
        return txtTanggalDistributor.getText();
    }

    public void setTxtTanggalDistributor(String txtTanggalDistributor) {
        this.txtTanggalDistributor.setText(txtTanggalDistributor);
    }

    public String getTxtTeleponDistributor() {
        return txtTeleponDistributor.getText();
    }

    public void setTxtTeleponDistributor(String txtTeleponDistributor) {
        this.txtTeleponDistributor.setText(txtTeleponDistributor);
    }
}
