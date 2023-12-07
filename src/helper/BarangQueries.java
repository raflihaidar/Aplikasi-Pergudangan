package helper;

public class BarangQueries {
    public final static String SELECT_ALL_DATA = "SELECT b.kode, b.nama, b.harga, b.stok, k.nama AS kategori, s.nama AS satuan "
                                                    +
                                                    "FROM barang AS b " +
                                                    "JOIN kategori AS k ON k.kode = b.kode_kategori " +
                                                    "JOIN satuan AS s ON s.kode = b.kode_satuan";

    public final static String INSERT_BARANG = "INSERT INTO barang(nama, harga, stok, kode_kategori, kode_satuan) VALUES (?,?,?,?,?)";
    public static final String DELETE_BARANG = "DELETE FROM barang WHERE kode = ?";
}
