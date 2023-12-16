package helper;

public class DistributorQueries {
    public final static  String SELECT_ALL_DISTRIBUTOR = "SELECT * FROM distributor";
    public final static String INSERT_DISTRIBUTOR = "INSERT INTO distributor (nama, alamat, no_hp) VALUES (?,?,?)";
    public final static String SELECT_ID = "SELECT id FROM distributor WHERE nama = ?";
    public final static String SELECT_SINGLE_DATA = "SELECT * FROM distributor WHERE id = ?";
    public final static String UPDATE_DATA = "UPDATE distributor SET nama = ?, no_hp = ?, alamat = ? WHERE id = ?";
    public final static String DELETE_DATA = "DELETE FROM distributor WHERE id = ?";
    public final static String GET_TOTAL_DISTRIBUTOR = "SELECT COUNT(*) FROM distributor";
}
