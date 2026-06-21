package programadopsihewan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDatabase {

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_USER = "root";
    private static final String DB_PASS = ""; 
    private static final String DB_HOST = "jdbc:mysql://localhost:3306/db_adopsi_hewan";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MySQL tidak ditemukan. Pastikan mysql-connector-j sudah ditambahkan ke library project.", e);
        }
        return DriverManager.getConnection(DB_HOST, DB_USER, DB_PASS);
    }
}
