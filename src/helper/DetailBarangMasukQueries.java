package helper;

public class DetailBarangMasukQueries {
    public final static String GET_ALL_DATA = "SELECT * FROM detail_barang_masuk";
    public final static String ADD_DATA = "INSERT INTO detail_barang_masuk(kode_barang, kode_barang_masuk, kuantitas, subtotal)"
                                        + "VALUES (?,?,?,?)";
    public final static String GET_SINGLE_DATA = "SELECT db.kode_barang AS kode, b.nama AS nama, b.harga AS harga,"
                                                + " db.kuantitas AS kuantitas, db.subtotal AS subtotal, u.nama AS nama"
                                                + " FROM detail_barang_masuk AS db"
                                                + " JOIN barang AS b ON b.kode= db.kode_barang"
                                                + " JOIN barang_masuk AS bm ON bm.id = db.kode_barang_masuk"
                                                + " JOIN distributor AS d ON d.id = bm.id_distributor"
                                                + " JOIN user AS u ON u.id = bm.id_user"
                                                + " WHERE db.kode_barang_masuk = ?";
}
