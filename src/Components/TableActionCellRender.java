package Components;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author rafli
 */
public class TableActionCellRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSeleted, boolean bln1, int row, int column) {
//        Component com = super.getTableCellRendererComponent(jtable, o, isSeleted, bln1, row, column);
        ActionPanel action = new ActionPanel();
        action.setBackground(Color.WHITE);
//        action.setBackground(com.getBackground());
        return action;
    }
}

