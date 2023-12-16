package helper;

public class DetailPesananQueries {
    public static final String SELECT_ALL_DETAIL = "SELECT * FROM detail_pemesanan";
    public static final String INSERT_DATA = "INSERT INTO detail_pemesanan(id_pemesanan, kode_barang, kuantitas, subtotal) VALUES(?,?,?,?)";
}
