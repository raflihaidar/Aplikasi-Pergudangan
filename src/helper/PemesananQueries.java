package helper;

public class PemesananQueries {
   public final static String GET_ALL_PESANAN = "SELECT p.id, p.id_distributor, p.id_user, p.tanggal, p.total, s.status AS status "
                                                 + "FROM pemesanan AS P JOIN status_pemesanan AS s ON s.kode = p.status";
   public final static String GET_SINGLE_PESANAN = "SELECT p.id, p.total, p.tanggal, s.kode AS status, s.status AS nama_status,"
                                                    + " u.nama AS user, d.nama AS distributor, d.alamat AS alamat"
                                                    + " FROM pemesanan AS p"
                                                    + " INNER JOIN status_pemesanan AS s ON s.kode = p.status"
                                                    + " INNER JOIN distributor AS d ON d.id = p.id_distributor"
                                                    + " INNER JOIN user AS u ON u.id = p.id_user WHERE p.id = ?";
   public final static String GET_LAST_ID = "SELECT id FROM pemesanan ORDER BY id DESC LIMIT 1";
   public final static String INSERT_PESANAN = "INSERT INTO pemesanan(id_user) VALUES (?)";
   public final static String UPDATE_PESANAN = "UPDATE pemesanan SET id_distributor = ?, total = ? WHERE id = ?";
   public final static String DELETE_PESANAN = "DELETE FROM pemesanan WHERE id = ?";
   public static final String UPDATE_DETAIL_PEMESANAN = "UPDATE pemesanan"
                                                        + " SET status = ?"
                                                         + " WHERE id = ?";
   public static final String BATALKAN_PEMESANAN = "UPDATE pemesanan set status = 4 WHERE id = ?";
   public static final String TOTAL_PESANAN = "SELECT COUNT(*) FROM pemesanan WHERE status = 3";
}
