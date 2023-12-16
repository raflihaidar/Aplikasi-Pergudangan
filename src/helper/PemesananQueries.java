package helper;

public class PemesananQueries {
   public final static String GET_ALL_PESANAN = "SELECT p.id, p.id_distributor, p.id_user, p.tanggal, p.total, s.status AS status "
                                                 + "FROM pemesanan AS P JOIN status_pemesanan AS s ON s.kode = p.status";
   public final static String GET_LAST_ID = "SELECT id FROM pemesanan ORDER BY id DESC LIMIT 1";
   public final static String INSERT_PESANAN = "INSERT INTO pemesanan(id_user) VALUES (?)";
   public final static String UPDATE_PESANAN = "UPDATE pemesanan SET id_distributor = ?, total = ? WHERE id = ?";
   public final static String DELETE_PESANAN = "DELETE FROM pemesanan WHERE id = ?";
}
