package services;

import java.sql.ResultSet;

public interface Getter_Service {

    public ResultSet getData(String query);

    public ResultSet getTotalData(String query);
}
