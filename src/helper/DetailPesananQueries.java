package helper;

public class DetailPesananQueries {
    public static final String SELECT_ALL_DETAIL = "SELECT * FROM detail_pemesanan";
    public static final String INSERT_DATA = "INSERT INTO detail_pemesanan(id_pemesanan, kode_barang, kuantitas, subtotal) VALUES(?,?,?,?)";
    public static final String GET_SINGLE_PEMESANAN = "SELECT d.kode_barang AS kode, b.nama AS nama, b.harga AS harga, d.kuantitas AS kuantitas, d.subtotal AS subtotal FROM detail_pemesanan AS d" 
                                                    + " JOIN barang AS b ON d.kode_barang = b.kode" +
                                                      " JOIN pemesanan AS p ON d.id_pemesanan = p.id " +
                                                      " WHERE p.id = ?";
}
