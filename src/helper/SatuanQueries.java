package helper;

public class SatuanQueries {
    public final static String SELECT_ALL_SATUAN = "SELECT * FROM satuan";
    public final static String INSERT_SATUAN = "INSERT INTO satuan(satuan) VALUES (?)";
    public final static String DELETE_SATUAN = "DELETE FROM satuan WHERE kode = ?";
    public final static String SELECT_SINGLE_DATA = "SELECT * FROM satuan WHERE kode = ?";
    public final static String SELECT_ID = "SELECT kode FROM satuan WHERE satuan = ?";
    public final static String UPDATE_SATUAN = "UPDATE satuan SET satuan = ? WHERE kode = ?";
    public final static String GET_TOTAL_SATUAN = "SELECT COUNT(*) FROM satuan";
    public static final String GET_REFRENCE = "SELECT satuan FROM satuan WHERE kode = ?";
}
