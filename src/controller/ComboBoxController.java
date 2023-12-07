package controller;

import javax.swing.JComboBox;
import model.ComboBoxModel;

public class ComboBoxController {
    private JComboBox<String> cmb;
    private ComboBoxModel cmbModel;
    
    public ComboBoxController(JComboBox<String> cmb){
        this.cmb = cmb;
        this.cmbModel = new ComboBoxModel();
    }
    
    public void getData(String query){
       cmb.setModel(cmbModel.getData(query));
    }
}
