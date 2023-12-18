package helper;

public class UserQueries {

    public static final String SELECT_ALL_USERS = "SELECT u.username AS username, j.jabatan AS jabatan, s.status AS status FROM user AS u JOIN jabatan AS j ON j.kode = u.kode_jabatan JOIN status AS s ON s.kode = u.status";
    public static final String SELECT_SINGLE_USER = "SELECT u.id, u.username, "
                                               + "u.nama, u.email, u.no_hp, u.tgl_lahir, "
                                               + "u.alamat, u.tgl_aktif, u.foto, j.kode AS kode_jabatan, "
                                               + "j.jabatan AS jabatan, s.kode AS status_kode, "
                                               + "s.status AS status, g.kode AS gender_kode, g.gender "
                                               + "FROM user AS u "
                                               + "JOIN jabatan AS j ON j.kode = u.kode_jabatan "
                                               + "JOIN status AS s ON s.kode = u.status "
                                               + "JOIN gender AS g ON g.kode = u.gender "
                                               + "WHERE u.username = ?";
    public static final String SELECT_DATA_BY_STATUS = "SELECT id FROM user WHERE isAuthenticated = 1";
    public static final String SELECT_ID_BY_NAME = "SELECT id FROM user WHERE nama = ?";
    public static final String INSERT_USER = "INSERT INTO user(nama, username, password, gender, kode_jabatan, status) VALUES (?,?,?,?,?,?)";
    public static final String SEARCH_USER = "SELECT * FROM user WHERE username = ? AND password = ?";
    public static final String DELETE_USER = "DELETE FROM user WHERE username = ?";
    public static final String IS_AUTHENTICATED = "UPDATE user SET isAuthenticated = ? WHERE username = ?";
    public static final String UPDATE_USER = "UPDATE user SET nama = ?, username = ?, email = ?, "
                                           + "no_hp = ?, alamat = ?,  status = ?, kode_jabatan = ? WHERE id = ?";
}
