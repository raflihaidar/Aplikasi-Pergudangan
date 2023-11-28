package Page;

import javax.swing.JOptionPane;

public class Register extends javax.swing.JFrame {

    public static String username;
    public static String password;
    private static String fullname;

    public Register() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        txtUsernameRegis = new javax.swing.JTextField();
        txtPasswordRegis = new javax.swing.JPasswordField();
        btnRegisterNow = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnLoginback = new javax.swing.JButton();
        txtWarningregis = new javax.swing.JLabel();
        txtRepass = new javax.swing.JPasswordField();
        cbGender = new javax.swing.JComboBox<>();
        cbRole = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Don't have an account?");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Full Name");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Re-Password");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Gender");

        txtFullName.setBackground(new java.awt.Color(255, 255, 255));
        txtFullName.setForeground(new java.awt.Color(0, 0, 0));
        txtFullName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFullName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtFullName.setSelectedTextColor(new java.awt.Color(0, 0, 0));

        txtUsernameRegis.setBackground(new java.awt.Color(255, 255, 255));
        txtUsernameRegis.setForeground(new java.awt.Color(0, 0, 0));
        txtUsernameRegis.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtPasswordRegis.setBackground(new java.awt.Color(255, 255, 255));
        txtPasswordRegis.setForeground(new java.awt.Color(0, 0, 0));
        txtPasswordRegis.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPasswordRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordRegisActionPerformed(evt);
            }
        });

        btnRegisterNow.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnRegisterNow.setText("REGISTER");
        btnRegisterNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterNowActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Already Have an Account?");

        btnLoginback.setBackground(new java.awt.Color(255, 255, 255));
        btnLoginback.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnLoginback.setForeground(new java.awt.Color(0, 204, 102));
        btnLoginback.setText("LOGIN");
        btnLoginback.setBorder(null);
        btnLoginback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginbackActionPerformed(evt);
            }
        });

        txtWarningregis.setBackground(new java.awt.Color(255, 255, 255));
        txtWarningregis.setForeground(new java.awt.Color(204, 0, 51));

        txtRepass.setBackground(new java.awt.Color(255, 255, 255));
        txtRepass.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtRepass.setForeground(new java.awt.Color(0, 0, 0));
        txtRepass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbGender.setBackground(new java.awt.Color(255, 255, 255));
        cbGender.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbGender.setForeground(new java.awt.Color(0, 0, 0));
        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        cbGender.setMinimumSize(new java.awt.Dimension(58, 20));
        cbGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGenderActionPerformed(evt);
            }
        });

        cbRole.setBackground(new java.awt.Color(255, 255, 255));
        cbRole.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbRole.setForeground(new java.awt.Color(0, 0, 0));
        cbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Staff" }));
        cbRole.setPreferredSize(new java.awt.Dimension(58, 20));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Role");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegisterNow)
                            .addComponent(jLabel7))
                        .addGap(4, 4, 4)
                        .addComponent(btnLoginback))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addGap(88, 88, 88)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbGender, 0, 206, Short.MAX_VALUE)
                                    .addComponent(cbRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(213, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtWarningregis, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRepass, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPasswordRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsernameRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(213, 213, 213))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(276, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsernameRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPasswordRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRepass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(2, 2, 2)
                .addComponent(txtWarningregis, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(45, 45, 45)
                .addComponent(btnRegisterNow)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnLoginback))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginbackActionPerformed
        // TODO add your handling code here:
        dispose();
        Login l = new Login();
        l.setVisible(true);
    }//GEN-LAST:event_btnLoginbackActionPerformed


    private void btnRegisterNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterNowActionPerformed
        // TODO add your handling code here:

        try {
            fullname = txtFullName.getText();
            username = txtUsernameRegis.getText();
            password = txtPasswordRegis.getText();

            if (fullname.isEmpty() || username.isEmpty() || password.isEmpty()) {
                // Tampilkan pesan kesalahan jika tidak diisi
                JOptionPane.showMessageDialog(this, "Please fill in the whole field!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (txtPasswordRegis.getText().equals(txtRepass.getText())) {
                    validationPassword();
                } else {
                    txtWarningregis.setText("Password Not Match");
                    txtPasswordRegis.setText("");
                    txtRepass.setText("");

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "There is an error!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnRegisterNowActionPerformed

    private void validationPassword() {

        String Passvalidation = txtPasswordRegis.getText();

        if (isValidPassword(Passvalidation)) {
            txtWarningregis.setText("Password valid!");
            JOptionPane.showMessageDialog(this, "Registration Successful!");
            dispose();
            Login l = new Login();
            l.setVisible(true);

        } else {
            txtWarningregis.setText("Invalid use 8 characters and uppercase");
            txtPasswordRegis.setText("");
            txtRepass.setText("");
        }
    }

    private boolean isValidPassword(String password) {
        // Memeriksa panjang minimal
        if (password.length() < 8) {
            return false;
        }

        // Memeriksa keberadaan angka
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Memeriksa keberadaan huruf besar
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        return true;
    }
    
    private void txtPasswordRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordRegisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordRegisActionPerformed

    private void cbGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbGenderActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginback;
    private javax.swing.JButton btnRegisterNow;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JComboBox<String> cbRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JPasswordField txtPasswordRegis;
    private javax.swing.JPasswordField txtRepass;
    private javax.swing.JTextField txtUsernameRegis;
    private javax.swing.JLabel txtWarningregis;
    // End of variables declaration//GEN-END:variables
}
