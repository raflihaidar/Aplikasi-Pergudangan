package helper;

public class StatusQueries {
     public static final String SELECT_ALL_STATUS = "SELECT * FROM status";
     public static final String SELECT_ALL_STATUS_PEMESANAN = "SELECT * FROM status_pemesanan WHERE status NOT IN ('Dibatalkan', 'Disimpan'))";
}
