package org.dndm.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {
    private static final HikariConfig config;
    private static final HikariDataSource ds;

    static {
        config = new HikariConfig("/datasource.properties");
        ds = new HikariDataSource(config);
    }

    private DataSource() {}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void close() {
        ds.close();
    }
}
