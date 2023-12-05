package Components;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Button extends JButton {

  private boolean mousePress;

  public Button() {
    addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent me) {
        mousePress = true;
      }

      @Override
      public void mouseReleased(MouseEvent me) {
        mousePress = false;
      }
    });
  }
}
