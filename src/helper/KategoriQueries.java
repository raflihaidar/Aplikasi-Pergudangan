package helper;

public class KategoriQueries {
     public final static String SELECT_ALL_KATEGORI = "SELECT * FROM kategori";
     public final static String INSERT_KATEGORI = "INSERT INTO kategori(kategori) VALUES (?)";
     public final static String DELETE_KATEGORI = "DELETE FROM kategori WHERE kode = ?";
     public final static String SELECT_SINGLE_DATA = "SELECT * FROM kategori WHERE kode = ?";
     public final static String SELECT_ID = "SELECT kode FROM kategori WHERE kategori = ?";
     public final static String UPDATE_KATEGORI = "UPDATE kategori SET kategori = ? WHERE kode = ?";
     public static final String GET_REFRENCE = "SELECT kategori FROM kategori WHERE kode = ?";
}
