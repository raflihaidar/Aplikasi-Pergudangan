package controller;

import javax.swing.JComboBox;
import model.ComboBox;

public class ComboBoxController {
    private JComboBox<String> cmb;
    private ComboBox cmbModel;
    
    public ComboBoxController(JComboBox<String> cmb){
        this.cmb = cmb;
        this.cmbModel = new ComboBox();
    }
    
    public void getData(String query){
       cmb.setModel(cmbModel.getData(query));
    }
}
