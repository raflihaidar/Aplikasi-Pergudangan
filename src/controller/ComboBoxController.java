package controller;

import dao.ComboBox_Dao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import model.ComboBox;

public class ComboBoxController implements ActionListener {

    private JComboBox<String> cmb;
    private JTextField output;
    private ComboBox cmbModel;
    private String query;
    private String queryGetId;
    private String column;
    private ComboBox_Dao comboDao;

    public ComboBoxController(JComboBox<String> cmb, String query) {
        this.cmb = cmb;
        this.cmbModel = new ComboBox();
        this.comboDao = new ComboBox_Dao();
        this.query = query;
    }

    public ComboBoxController(JComboBox<String> cmb, String query, String query2, String column, JTextField output) {
        this.cmb = cmb;
        this.cmbModel = new ComboBox();
        this.query = query;
        this.queryGetId = query2;
        this.column = column;
        this.comboDao = new ComboBox_Dao();
        this.output = output;
    }

    public void getData(String nama) {
        cmb.setModel(cmbModel.getData(query, nama));
    }

    public void getData(String nama, int index) {
        cmb.setModel(cmbModel.getData(query, nama));
        cmb.setSelectedIndex(index);
    }
    
    public int getId(String target){
        int id = comboDao.getDataById(query, target);
        return id;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedItem = (String) cmb.getSelectedItem();
        String id = String.valueOf(comboDao.getDataById(queryGetId, column, selectedItem));
        output.setText(id);
    }
}
