/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import javax.swing.ImageIcon;

/**
 *
 * @author rafli
 */
public class MyIcon {
    private static ImageIcon icon;
    
    public static ImageIcon getIcon(String name){
        return icon = new javax.swing.ImageIcon(System.getProperty("user.dir") + "/src/image/" + name + ".png");
    }
}
