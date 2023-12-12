package helper;

public class SatuanQueries {

    public final static String SELECT_ALL_SATUAN = "SELECT * FROM satuan";
    public final static String INSERT_SATUAN = "INSERT INTO satuan(satuan) VALUES (?)";
    public final static String DELETE_SATUAN = "DELETE FROM satuan WHERE kode = ?";
    public final static String SELECT_SINGLE_DATA = "SELECT * FROM satuan WHERE kode = ?";
    public final static String UPDATE_SATUAN = "UPDATE satuan SET satuan = ? WHERE kode = ?";
    public final static String GET_TOTAL_SATUAN = "SELECT COUNT(*) FROM satuan";
}
