package br.com.fiap.soap.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactoryConfig {

    private static final String URL = "jdbc:postgresql://localhost:5432/convocation";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Database connection error", e);
        }
    }
}
