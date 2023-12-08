package Form;

import controller.UserController;
import Components.MyIcon;
import Components.ScrollBar;
import Components.TableActionCellEditor;
import Components.TableActionCellRender;
import Components.TableActionEvent;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import model.ModelCard;
import model.UserModel;

public class Dashboard extends javax.swing.JPanel {

        ImageIcon iconStaff = MyIcon.getIcon("staff-2");
        ImageIcon iconTotal = MyIcon.getIcon("summarize");
        ImageIcon iconProfit = MyIcon.getIcon("profit");
        ImageIcon iconDistributor = MyIcon.getIcon("distributor-2");

        public Dashboard() {
                initComponents();
                UserModel user = new UserModel();
                UserController controller = new UserController(table2, user);
                card1.setData(new ModelCard(iconTotal, "Total Stock", "20.0000"));
                card2.setData(new ModelCard(iconStaff, "Total Profit", "Rp. 15.000.000"));
                card3.setData(new ModelCard(iconProfit, "Jumlah Staff", "150"));
                card4.setData(new ModelCard(iconDistributor, "Jumlah Distributor", "20"));

                scrollTable.setVerticalScrollBar(new ScrollBar());
                scrollTable2.setVerticalScrollBar(new ScrollBar());

                controller.showAllData((DefaultTableModel) table2.getModel());
                TableActionEvent event = new TableActionEvent() {
                        @Override
                        public void onEdit(int row) {
                                System.out.println("Edit row : " + row);
                        }

                        @Override
                        public void onDelete(int row) {
                            try{
                                controller.deleteDataUser();
                            }catch(Exception e){
                                System.out.println("Error : " + e.getMessage());
                            }
                        }

                        @Override
                        public void onView(int row) {
                                System.out.println("View row : " + row);
                        }
                };
                table2.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
                table2.getColumnModel().getColumn(3).setCellEditor(new TableActionCellEditor(event));
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jLabel1 = new javax.swing.JLabel();
                cardContainer = new javax.swing.JLayeredPane();
                card1 = new Components.Card();
                card2 = new Components.Card();
                card3 = new Components.Card();
                card4 = new Components.Card();
                tableContainer = new javax.swing.JPanel();
                scrollTable = new javax.swing.JScrollPane();
                table2 = new Components.Table();
                scrollTable2 = new javax.swing.JScrollPane();
                table1 = new Components.Table();

                setBackground(new java.awt.Color(255, 255, 255));

                jLabel1.setFont(new java.awt.Font("SimSun", 1, 14)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(0, 0, 0));
                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel1.setText("Dashboard");

                cardContainer.setLayout(new java.awt.GridLayout(1, 3, 15, 0));

                card1.setColor1(new java.awt.Color(0, 204, 204));
                card1.setColor2(new java.awt.Color(51, 255, 204));
                cardContainer.add(card1);

                card2.setColor1(new java.awt.Color(255, 204, 102));
                card2.setColor2(new java.awt.Color(255, 204, 0));
                cardContainer.add(card2);

                card3.setColor1(new java.awt.Color(51, 204, 0));
                card3.setColor2(new java.awt.Color(51, 255, 0));
                cardContainer.add(card3);

                card4.setColor1(new java.awt.Color(255, 153, 51));
                card4.setColor2(new java.awt.Color(255, 153, 51));
                cardContainer.add(card4);

                tableContainer.setBackground(new java.awt.Color(255, 255, 255));
                tableContainer.setLayout(new java.awt.CardLayout());

                scrollTable.setBorder(null);
                scrollTable.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

                table2.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {

                                },
                                new String[] {
                                                "Username", "Jabatan", "Status", "Action"
                                }));
                table2.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyReleased(java.awt.event.KeyEvent evt) {
                                table2KeyReleased(evt);
                        }
                });
                scrollTable.setViewportView(table2);

                tableContainer.add(scrollTable, "card2");

                scrollTable2.setBackground(new java.awt.Color(255, 255, 255));
                scrollTable2.setBorder(null);
                scrollTable2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                scrollTable2.setOpaque(false);

                table1.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                { null },
                                                { null },
                                                { null },
                                                { null }
                                },
                                new String[] {
                                                "Aktifitas Pengguna"
                                }));
                scrollTable2.setViewportView(table1);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addContainerGap()
                                                                                                .addComponent(scrollTable2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                337,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGap(30, 30, 30)
                                                                                                                .addGroup(layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(jLabel1,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                94,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(cardContainer,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                991,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addContainerGap(19, Short.MAX_VALUE))
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                layout.createSequentialGroup()
                                                                                                .addContainerGap(30,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(tableContainer,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                637,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addContainerGap(373,
                                                                                                                Short.MAX_VALUE))));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(40, 40, 40)
                                                                .addComponent(jLabel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                34,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(cardContainer,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                125,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(scrollTable2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                317,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(21, Short.MAX_VALUE))
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                layout.createSequentialGroup()
                                                                                                .addContainerGap(225,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(tableContainer,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                317,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addContainerGap(19,
                                                                                                                Short.MAX_VALUE))));
        }// </editor-fold>//GEN-END:initComponents

        private void table2KeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_table2KeyReleased
                // TODO add your handling code here:
        }// GEN-LAST:event_table2KeyReleased

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private Components.Card card1;
        private Components.Card card2;
        private Components.Card card3;
        private Components.Card card4;
        private javax.swing.JLayeredPane cardContainer;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JScrollPane scrollTable;
        private javax.swing.JScrollPane scrollTable2;
        private Components.Table table1;
        private Components.Table table2;
        private javax.swing.JPanel tableContainer;
        // End of variables declaration//GEN-END:variables
}
