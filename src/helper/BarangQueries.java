package helper;

public class BarangQueries {
    public final static String SELECT_ALL_DATA = "SELECT b.kode, b.nama, b.harga, b.stok, k.nama AS kategori, s.nama AS satuan "
                                                    +
                                                    "FROM barang AS b " +
                                                    "JOIN kategori AS k ON k.kode = b.kode_kategori " +
                                                    "JOIN satuan AS s ON s.kode = b.kode_satuan";

    public final static String INSERT_BARANG = "INSERT INTO barang(nama, harga, stok, kode_kategori, kode_satuan) VALUES (?,?,?,?,?)";
    public final static String DELETE_BARANG = "DELETE FROM barang WHERE kode = ?";
    public final static String SELECT_SINGLE_DATA = "SELECT b.kode, b.nama, b.harga, b.stok, k.nama AS kategori, s.nama AS satuan "
                                                    +
                                                    "FROM barang AS b " +
                                                    "JOIN kategori AS k ON k.kode = b.kode_kategori " +
                                                    "JOIN satuan AS s ON s.kode = b.kode_satuan " + 
                                                    "WHERE b.kode = ?";
    public final static String UPDATE_BARANG = "UPDATE barang SET nama = ?, harga = ?, stok = ?, kode_kategori = ?, kode_satuan = ? WHERE kode = ?";
    public final static String GET_TOTAL_BARANG = "SELECT COUNT(*) FROM barang";


}
