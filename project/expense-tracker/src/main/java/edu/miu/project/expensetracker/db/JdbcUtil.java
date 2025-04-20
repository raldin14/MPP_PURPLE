package edu.miu.project.expensetracker.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcUtil {
    private static final String DB_PROPERTIES = "db/db.properties";

    private static String url;

    private static String username;

    private static String password;

    static {
        try {
            Properties props = new Properties();
            InputStream fis = JdbcUtil.class.getClassLoader().getResourceAsStream(DB_PROPERTIES);

            if (fis == null) {
                throw new RuntimeException("Properties file not found: " + DB_PROPERTIES);
            }

            props.load(fis);
            url = props.getProperty("url");
            username = props.getProperty("username");
            password = props.getProperty("password");
        } catch (Exception e) {
//            e.printStackTrace(); // change this line
            throw new RuntimeException("Database connection failed", e);

        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }
}
