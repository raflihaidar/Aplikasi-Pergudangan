package helper;

import javax.swing.JPanel;
import view.MainMenus;

public class Util {
    public static void changePage(JPanel panel, MainMenus mainMenu) {
        mainMenu.getContent().removeAll();
        mainMenu.setContent(panel);
        mainMenu.getContent().repaint();
        mainMenu.getContent().revalidate();
    }
}
