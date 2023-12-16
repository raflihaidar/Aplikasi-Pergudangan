package services;

import java.util.List;
import model.Distributor;

public interface Distributor_Service {

    public List<Distributor> getSingleData(String username);

    public int addData(Distributor distributor);

    public void updateData(Distributor distributor);

    public void deleteData(int id);
}
