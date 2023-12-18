package controller;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TableController implements ListSelectionListener{
   private JTable table;
   private JButton button;
  
   public TableController(JTable table, JButton button){
       this.table = table;
       this.button = button;
   }
   
   public void getSelectedRows() {
    for (int i = 0; i < table.getRowCount(); i++) {
        Boolean isChecked = (Boolean) table.getValueAt(i, 6);
        if (isChecked != null && isChecked) {
           System.out.println("Baris yang diceklis : " + i);
        }
    }
}

    @Override
    public void valueChanged(ListSelectionEvent e) {
        getSelectedRows();
    }
}
