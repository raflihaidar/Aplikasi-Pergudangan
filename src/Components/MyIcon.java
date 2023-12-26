package Components;

import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author rafli
 */
public class MyIcon extends ImageIcon {

    private static ImageIcon icon;
    private URL url;
    private BufferedImage img = null;

    public MyIcon(String name) {
        try {
            this.url = getClass().getResource(name + ".png");
            this.img = ImageIO.read(url);
        } catch (Exception e) {
            
        }

//        return icon = new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/resources/" + name + ".png");
    }
}
