package helper;

public class UserQueries {

    public static final String SELECT_ALL_USERS = "SELECT * FROM user";
    public static final String INSERT_USER = "INSERT INTO user(nama, username, password, gender, kode_jabatan) VALUES (?,?,?,?,?)";
    public static final String SEARCH_USER = "SELECT * FROM user WHERE username = ? AND password = ?";
    public static final String DELETE_USER = "DELETE FROM user WHERE username = ?";
}
