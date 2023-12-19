package helper;

public class DetailBarangKeluar_Queries {

    public static final String ADD_DATA = "INSERT INTO detail_barang_keluar(kode_barang, kode_barang_keluar, kuantitas, subtotal) "
            + "VALUES (?,?,?,?)";
    public final static String GET_SINGLE_DATA = "SELECT db.kode_barang AS kode, b.nama AS nama, b.harga AS harga,"
                                                + " db.kuantitas AS kuantitas, db.subtotal AS subtotal, u.nama AS nama"
                                                + " FROM detail_barang_keluar AS db"
                                                + " JOIN barang AS b ON b.kode= db.kode_barang"
                                                + " JOIN barang_keluar AS bk ON bk.id = db.kode_barang_keluar"
                                                + " JOIN user AS u ON u.id = bk.id_user"
                                                + " WHERE db.kode_barang_keluar = ?";
}
