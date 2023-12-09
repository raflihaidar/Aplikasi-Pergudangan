package helper;

public class KategoriQueries {
     public final static String SELECT_ALL_KATEGORI = "SELECT * FROM kategori";
     public final static String INSERT_KATEGORI = "INSERT INTO kategori(nama) VALUES (?)";
     public final static String DELETE_KATEGORI = "DELETE FROM kategori WHERE kode = ?";
     public final static String SELECT_SINGLE_DATA = "SELECT * FROM kategori WHERE kode = ?";
     public final static String UPDATE_KATEGORI = "UPDATE kategori SET nama = ? WHERE kode = ?";
}
