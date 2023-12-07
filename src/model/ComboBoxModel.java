package model;

import config.Config;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;

public class ComboBoxModel {
    private int kode;
    private String nama;

    public int getKode() {
        return kode;
    }

    public String getName() {
        return nama;
    }

    public DefaultComboBoxModel<String> getData(String query) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        Connection con = Config.connectDB();
        try {
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                model.addElement(result.getString("nama"));
            }

            con.close();
            return model;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

}
