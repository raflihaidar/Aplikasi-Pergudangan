package services;

import java.util.List;
import model.User;

public interface User_Service {
    public List<User> getAllData();
    public List<User> getSingleData(String username);
    public void addData(User user);
    public void updateData(User user);
    public void deleteData(String username);
}
