/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author RavenPC
 */
public class MenuItem extends javax.swing.JPanel {

    public void setShowing(boolean showing) {
        this.showing = showing;
    }

    public ArrayList<MenuItem> getSubMenu() {
        return subMenu;
    }

    /**
     * Creates new form MenuItem
     */
    private final ArrayList<MenuItem> subMenu = new ArrayList<>();
    private ActionListener act;
    
    private final Color normalBackgroundColor = new Color(255,255,255);
    private final Color hoverBackgroundColor = new Color(220,220,220);

    public MenuItem(Icon icon, boolean submenu, String menuName, ActionListener act, MenuItem... subMenu) {
        initComponents();
        lbIcon.setIcon(icon);
        lbName.setText(menuName);
        if (act != null) {
            this.act = act;
        }
        
        if(submenu){
            this.setBorder(new EmptyBorder(0, 35, 0, 0));
        }
        this.setSize(new Dimension(Integer.MAX_VALUE, 45));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        this.setMinimumSize(new Dimension(Integer.MAX_VALUE, 45));
        for (int i = 0; i < subMenu.length; i++) {
            this.subMenu.add(subMenu[i]);
            subMenu[i].setVisible(false);
        }
        
                addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }

            // Menangani perubahan warna latar belakang saat mouse masuk (hover)
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(hoverBackgroundColor);
            }

            // Menangani perubahan warna latar belakang saat mouse keluar dari menu
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(normalBackgroundColor);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">                          
    private void initComponents() {
        lbIcon = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255,255,255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        lbName.setText("Menu Name Here ...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap()));
    }

    private boolean showing = false;

    private void formMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_formMousePressed
        if (showing) {
            hideMenu();
        } else {
            showMenu();
        }
        if (act != null) {
            act.actionPerformed(null);
        }
    }// GEN-LAST:event_formMousePressed

    private void showMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < subMenu.size(); i++) {
                    sleep();
                    subMenu.get(i).setVisible(true);
                }
                showing = true;
                getParent().repaint();
                getParent().revalidate();
            }
        }).start();
    }

    private void hideMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = subMenu.size() - 1; i >= 0; i--) {
                    sleep();
                    subMenu.get(i).setVisible(false);
                    subMenu.get(i).hideMenu();
                }
                getParent().repaint();
                getParent().revalidate();
                showing = false;
            }
        }).start();
    }

    private void sleep() {
        try {
            Thread.sleep(20);
        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbName;
    // End of variables declaration//GEN-END:variables
}
