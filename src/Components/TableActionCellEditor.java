package Components;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author rafli
 */
public class TableActionCellEditor extends DefaultCellEditor {

  private TableActionEvent event;

  public TableActionCellEditor(TableActionEvent event) {
    super(new JCheckBox());
    this.event = event;
  }

  @Override
  public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
    ActionPanel action = new ActionPanel();
    action.initEvent(event, row);
    action.setBackground(Color.WHITE);
    return action;
  }
}
