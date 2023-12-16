package dao;

import java.sql.*;
import config.Config;
import helper.DistributorQueries;
import java.util.ArrayList;
import java.util.List;
import model.Distributor;
import services.Distributor_Service;

public class Distributor_Dao implements Distributor_Service {

    private Connection con;
    private Distributor distributor;

    public Distributor_Dao() {
        con = Config.connectDB();
        distributor = new Distributor();
    }

    @Override
    public List<Distributor> getSingleData(String username) {
        List<Distributor> data = new ArrayList<>();
        ResultSet result = null;
        try (PreparedStatement ps = con.prepareStatement(DistributorQueries.SELECT_SINGLE_DATA)) {
            ps.setString(1, username);
            result = ps.executeQuery();
            while (result.next()) {
                distributor.setId(result.getInt("id"));
                distributor.setNama(result.getString("nama"));
                distributor.setAlamat(result.getString("alamat"));
                distributor.setTelepon(result.getString("no_hp"));
                distributor.setTanggalDaftar(result.getString("tgl_daftar"));
                data.add(distributor);
            }
        } catch (SQLException e) {
            System.out.println("Error getSingle: " + e.getMessage());
        }
        return data;
    }

    @Override
    public int addData(Distributor distributor) {
        ResultSet generatedKeys = null;
        int id = 0;
        try (PreparedStatement ps = con.prepareStatement(DistributorQueries.INSERT_DISTRIBUTOR)) {
            ps.setString(1, distributor.getNama());
            ps.setString(2, distributor.getAlamat());
            ps.setString(3, distributor.getTelepon());
            ps.execute();
            
            generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return id;
    }

    @Override
    public void updateData(Distributor distributor) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(DistributorQueries.UPDATE_DATA);
            ps.setString(1, distributor.getNama());
            ps.setString(2, distributor.getTelepon());
            ps.setString(3, distributor.getAlamat());
            ps.setInt(4, distributor.getId());

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Update successful!");
            } else {
                System.out.println("No rows updated.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteData(int id) {
        try {
            PreparedStatement ps = con.prepareStatement(DistributorQueries.DELETE_DATA);
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error delete : " + e.getMessage());
        }
    }

}
