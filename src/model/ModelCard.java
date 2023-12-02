package model;

import javax.swing.Icon;

/**
 *
 * @author rafli
 */
public class ModelCard {
    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public ModelCard(String title, String values) {
//        this.icon = icon;
        this.title = title;
        this.values = values;
    }

    public ModelCard() {
    }

    private Icon icon;
    private String title;
    private String values;
}
