package helper;

public class UserQueries {

    public static final String SELECT_ALL_USERS = "SELECT * FROM user";
    public static final String SELECT_SINGLE_USER = "SELECT u.id, u.username, "
                                                   + "u.nama, u.email, u.no_hp, u.tgl_lahir, "
                                                   + "u.alamat, u.tgl_aktif, u.foto, j.nama AS jabatan, "
                                                   + "s.status AS status, g.gender FROM user AS u "
                                                   + "JOIN jabatan AS j ON j.nama = u.kode_jabatan "
                                                   + "JOIN status AS s ON s.status = u.status "
                                                   + "JOIN gender AS g ON g.gender = u.gender "
                                                   + "WHERE username = ?";
    public static final String INSERT_USER = "INSERT INTO user(nama, username, password, gender, kode_jabatan) VALUES (?,?,?,?,?)";
    public static final String SEARCH_USER = "SELECT * FROM user WHERE username = ? AND password = ?";
    public static final String DELETE_USER = "DELETE FROM user WHERE username = ?";
    public static final String IS_AUTHENTICATED = "UPDATE user SET isAuthenticated = ? WHERE username = ?";
    public static final String UPDATE_USER = "UPDATE user SET nama = ?, username = ?, email = ?, "
                                           + "no_hp = ?, alamat = ?,  status = ?, jabatan = ? WHERE id = ?";
}
