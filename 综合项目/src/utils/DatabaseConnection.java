package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/JavaWeb?usrSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "123456789";
    private Connection conn = null;

    public DatabaseConnection() throws Exception {
        try {
            Class.forName(JDBC_DRIVER);
            this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }catch (Exception e) {
            throw e;
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void close() throws Exception {
        if (this.conn != null) {
            try {
                this.conn.close();
            }catch (Exception e) {
                throw e;
            }
        }
    }
}
