package view;

import Page.Dashboard;
import Components.MenuItem;
import Components.MyIcon;
import Components.ScrollBar;
import Page.Barang;
import Page.BarangKeluar;
import Page.BarangMasuk;
import Page.Distributor;
import Page.Kategori;
import Page.DaftarPemesanan;
import Page.Satuan;
import Page.User;
import controller.UserController;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;

public class MainMenus extends javax.swing.JFrame {

    /**
     * Creates new form MainMenus
     */
    UserController controller;

    public MainMenus(String username) {
        initComponents();
        execute();
        controller = new UserController(MainMenus.this, username);
        listMenu.setPreferredSize(new Dimension(350, 0));
        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        sidebar.setBorder(new EmptyBorder(0, 10, 0, 0));
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        txtUsernameMain.setText(username);
    }

    public MainMenus() {
        initComponents();
        execute();
        listMenu.setPreferredSize(new Dimension(350, 0));
        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        sidebar.setBorder(new EmptyBorder(0, 10, 0, 0));
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navbar = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        txtUsernameMain = new javax.swing.JLabel();
        profileImage = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        sidebar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listMenu = new javax.swing.JPanel();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIMAG");
        setBackground(new java.awt.Color(204, 204, 204));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        navbar.setBackground(new java.awt.Color(0, 51, 102));
        navbar.setPreferredSize(new java.awt.Dimension(669, 90));
        navbar.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                navbarAncestorAdded(evt);
            }

            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }

            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        title.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("SIMAG");

        txtUsernameMain.setBackground(new java.awt.Color(255, 255, 255));
        txtUsernameMain.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        txtUsernameMain.setForeground(new java.awt.Color(255, 255, 255));
        txtUsernameMain.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtUsernameMain.setText("Admin");
        txtUsernameMain.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtUsernameMainAncestorAdded(evt);
            }

            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }

            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        profileImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/profile.png"))); // NOI18N
        profileImage.setPreferredSize(new java.awt.Dimension(35, 35));

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/close.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo-simag.png"))); // NOI18N

        javax.swing.GroupLayout navbarLayout = new javax.swing.GroupLayout(navbar);
        navbar.setLayout(navbarLayout);
        navbarLayout.setHorizontalGroup(
                navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(navbarLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 83,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(721, 721, 721)
                                .addGroup(navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(navbarLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtUsernameMain, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(profileImage, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(navbarLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))));
        navbarLayout.setVerticalGroup(
                navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(navbarLayout.createSequentialGroup()
                                .addGroup(navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(navbarLayout.createSequentialGroup()
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(navbarLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(profileImage,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 41,
                                                                Short.MAX_VALUE)
                                                        .addComponent(txtUsernameMain,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(0, 4, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                navbarLayout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navbarLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)));

        getContentPane().add(navbar, java.awt.BorderLayout.PAGE_START);

        sidebar.setBackground(new java.awt.Color(0, 20, 64));
        sidebar.setPreferredSize(new java.awt.Dimension(180, 369));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        listMenu.setBackground(new java.awt.Color(0, 20, 64));
        listMenu.setPreferredSize(new java.awt.Dimension(0, 200));
        listMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listMenuMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                listMenuMouseExited(evt);
            }
        });
        listMenu.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                listMenuComponentShown(evt);
            }
        });
        listMenu.setLayout(new javax.swing.BoxLayout(listMenu, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(listMenu);

        javax.swing.GroupLayout sidebarLayout = new javax.swing.GroupLayout(sidebar);
        sidebar.setLayout(sidebarLayout);
        sidebarLayout.setHorizontalGroup(
                sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE));
        sidebarLayout.setVerticalGroup(
                sidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE));

        getContentPane().add(sidebar, java.awt.BorderLayout.LINE_START);

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setLayout(new java.awt.BorderLayout());
        getContentPane().add(content, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1210, 649));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void navbarAncestorAdded(javax.swing.event.AncestorEvent evt) {// GEN-FIRST:event_navbarAncestorAdded
        // TODO add your handling code here:

    }// GEN-LAST:event_navbarAncestorAdded

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }// GEN-LAST:event_jButton1MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        content.add(new Dashboard());
        content.repaint();
        content.revalidate();
    }// GEN-LAST:event_formWindowOpened

    private void listMenuMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_listMenuMouseExited
        // TODO add your handling code here:
    }// GEN-LAST:event_listMenuMouseExited

    private void listMenuMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_listMenuMouseEntered
        // TODO add your handling code here:
    }// GEN-LAST:event_listMenuMouseEntered

    private void listMenuComponentShown(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_listMenuComponentShown
        // TODO add your handling code here:
    }// GEN-LAST:event_listMenuComponentShown

    private void formComponentShown(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
    }// GEN-LAST:event_formComponentShown

    private void txtUsernameMainAncestorAdded(javax.swing.event.AncestorEvent evt) {// GEN-FIRST:event_txtUsernameMainAncestorAdded
        // TODO add your handling code here:
        // txtUsernameMain.setText(Register.username + "");
    }// GEN-LAST:event_txtUsernameMainAncestorAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenus().setVisible(true);
            }
        });
    }

    public JPanel getContent() {
        return content;
    }

    public void setContent(Component c) {
        this.content.add(c);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel content;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel listMenu;
    private javax.swing.JPanel navbar;
    private javax.swing.JLabel profileImage;
    private javax.swing.JPanel sidebar;
    private javax.swing.JLabel title;
    private javax.swing.JLabel txtUsernameMain;
    // End of variables declaration//GEN-END:variables

    private void execute() {

        ImageIcon iconMaster = new javax.swing.ImageIcon(getClass().getResource("/resources/master.png"));
        ImageIcon iconTransaction = new javax.swing.ImageIcon(getClass().getResource("/resources/transaction.png"));
        ImageIcon iconDashboard = new javax.swing.ImageIcon(getClass().getResource("/resources/dashboard.png"));
        // ImageIcon iconReport = MyIcon.getIcon("report");
        ImageIcon iconItem = new javax.swing.ImageIcon(getClass().getResource("/resources/item.png"));
        ImageIcon iconDistributor = new javax.swing.ImageIcon(getClass().getResource("/resources/distributor-2.png"));
        ImageIcon iconSettings = new javax.swing.ImageIcon(getClass().getResource("/resources/settings.png"));
        ImageIcon iconIncome = new javax.swing.ImageIcon(getClass().getResource("/resources/income.png"));
        ImageIcon iconOutbound = new javax.swing.ImageIcon(getClass().getResource("/resources/outbound.png"));
        ImageIcon iconOrder = new javax.swing.ImageIcon(getClass().getResource("/resources/order.png"));
        // ImageIcon iconTransactionReport = MyIcon.getIcon("transaction-report");
        ImageIcon iconCategory = new javax.swing.ImageIcon(getClass().getResource("/resources/category.png"));
        ImageIcon iconSatuan = new javax.swing.ImageIcon(getClass().getResource("/resources/satuan.png"));
        ImageIcon iconUser = new javax.swing.ImageIcon(getClass().getResource("/resources/manage-user.png"));
        ImageIcon iconHakAkses = new javax.swing.ImageIcon(getClass().getResource("/resources/hak-akses.png"));
        ImageIcon iconLogout = new javax.swing.ImageIcon(getClass().getResource("/resources/logout.png"));

        MenuItem menuDashboard = new MenuItem(iconDashboard, false, "Dashboard", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                content.removeAll();
                content.add(new Dashboard());
                content.repaint();
                content.revalidate();
            }
        });

        MenuItem menuDistributor = new MenuItem(iconDistributor, false, "Distributor", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                content.removeAll();
                content.add(new Distributor());
                content.repaint();
                content.revalidate();
            }
        });

        MenuItem menuBarang = new MenuItem(iconItem, true, "Barang", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                content.removeAll();
                content.add(new Barang());
                content.repaint();
                content.revalidate();
            }
        });
        MenuItem menuBarang2 = new MenuItem(iconCategory, true, "Kategori", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                content.removeAll();
                content.add(new Kategori());
                content.repaint();
                content.revalidate();
            }
        });
        MenuItem menuBarang3 = new MenuItem(iconSatuan, true, "Satuan", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                content.removeAll();
                content.add(new Satuan());
                content.repaint();
                content.revalidate();
            }
        });

        MenuItem menuMaster = new MenuItem(iconMaster, false, "Master barang", null, menuBarang, menuBarang2,
                menuBarang3);

        MenuItem menuTransaction1 = new MenuItem(iconIncome, true, "Barang Masuk", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                content.removeAll();
                content.add(new BarangMasuk(MainMenus.this));
                content.repaint();
                content.revalidate();
            }
        });

        MenuItem menuTransaction2 = new MenuItem(iconOutbound, true, "Barang Keluar", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                content.removeAll();
                content.add(new BarangKeluar(MainMenus.this));
                content.repaint();
                content.revalidate();
            }
        });

        MenuItem menuTransaction3 = new MenuItem(iconOrder, true, "Pemesanan", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                content.removeAll();
                content.add(new DaftarPemesanan(MainMenus.this));
                content.repaint();
                content.revalidate();
            }
        });
        MenuItem menuTransaction = new MenuItem(iconTransaction, false, "Transaksi", null, menuTransaction1,
                menuTransaction2,
                menuTransaction3);

        // MenuItem menuReport1 = new MenuItem(iconTransactionReport, true, "Transaksi",
        // null);
        // MenuItem menuReport = new MenuItem(iconReport, false, "Laporan", null,
        // menuReport1);

        MenuItem menuSettings1 = new MenuItem(iconUser, true, "User", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                content.removeAll();
                content.add(new User());
                content.repaint();
                content.revalidate();
            }
        });
        MenuItem menuSettings2 = new MenuItem(iconHakAkses, true, "Hak Akses", null);
        MenuItem logOut = new MenuItem(iconLogout, false, "Log Out", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                controller.logOutConfirm();
            }
        });
        MenuItem menuSettings = new MenuItem(iconSettings, false, "Pengaturan", null, menuSettings1, menuSettings2);

        addMenu(menuDashboard, menuMaster, menuDistributor, menuTransaction, menuSettings, logOut);
    }

    private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            listMenu.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem item : subMenu) {
                addMenu(item);
            }
        }
        listMenu.revalidate();
    }
}
