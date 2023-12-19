package helper;

public class BarangKeluarQueries {

    public static final String INSERT_DATA = "INSERT INTO barang_keluar(id_user, total, jumlah, keterangan) "
            + "VALUES(?,?,?,?)";
    public final static String GET_DATA = "SELECT bk.id, u.username AS user, bk.tanggal, bk.jumlah, bk.total, s.status AS status FROM barang_keluar AS bk"
                                        + " JOIN user AS u ON u.id = bk.id_user"
                                        + " JOIN status_pemesanan AS s ON s.kode = bk.status";
    public final static String GET_SINGLE_DATA = "SELECT bk.id, bk.tanggal AS tanggal, bk.jumlah AS jumlah, u.nama AS user, "
                                                + "s.status AS status, bk.keterangan AS keterangan FROM barang_keluar AS bk "
                                                + "JOIN user AS u ON u.id = bk.id_user "
                                                + "JOIN status_pemesanan AS s ON s.kode = bk.status "
                                                + "WHERE bk.id = ?";
    public final static String GET_LAST_ID = "SELECT id FROM barang_keluar ORDER BY id DESC LIMIT 1";
    public final static String UPDATE_DATA = "UPDATE barang_keluar SET status = ?, keterangan = ? WHERE id = ?";
}
