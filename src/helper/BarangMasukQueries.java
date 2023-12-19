package helper;

public class BarangMasukQueries {

    public final static String GET_DATA_BARANG_MASUK = "SELECT bm.id, u.username AS user, d.nama AS distributor, bm.tanggal, bm.jumlah, s.status AS status FROM barang_masuk AS bm"
                                                    + " JOIN user AS u ON u.id = bm.id_user"
                                                    + " JOIN distributor AS d ON d.id = bm.id_distributor"
                                                    + " JOIN status_pemesanan AS s ON s.kode = bm.status";
    public final static String ADD_BARANG_MASUK = "INSERT INTO barang_masuk (id_user, id_distributor, tanggal, jumlah)"
                                                + "VALUES (?,?,?,?)";
    public final static String GET_SINGLE_DATA = "SELECT bm.id, bm.tanggal AS tanggal, bm.jumlah AS jumlah, u.nama AS user, "
                                                + "s.status AS status, bm.keterangan AS keterangan, d.nama AS distributor, d.alamat AS alamat FROM barang_masuk AS bm "
                                                + "JOIN user AS u ON u.id = bm.id_user "
                                                + "JOIN distributor AS d ON d.id = bm.id_distributor "
                                                + "JOIN status_pemesanan AS s ON s.kode = bm.status "
                                                + "WHERE bm.id = ? AND s.status NOT IN ('Dikirim', 'Sedang di Proses')";
    public final static String GET_LAST_ID = "SELECT id FROM barang_masuk ORDER BY id DESC LIMIT 1";
    public final static String UPDATE_DATA = "UPDATE barang_masuk SET status = ?, keterangan = ? WHERE id = ?";
}
