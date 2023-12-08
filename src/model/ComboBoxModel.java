package model;

import config.Config;
import java.sql.*;
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
    
    // Fungsi untuk mendapatkan nama referensi (kategori atau satuan) sesuai ID
    public static String getRefrence(String tabelReferensi, String kolomNama, int id) {
        Connection con = Config.connectDB();
        String namaReferensi = "";
        try {
            String query = "SELECT nama" + " FROM " + tabelReferensi + " WHERE kode"+ " = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                namaReferensi = resultSet.getString(kolomNama);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return namaReferensi;
    }

}
