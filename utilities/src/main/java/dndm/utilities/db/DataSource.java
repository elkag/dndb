package dndm.utilities.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {
    private static final HikariConfig config;
    private static final HikariDataSource ds;

    static {

        //config = new HikariConfig("/datasource.properties");
        config = new HikariConfig();
        config.setJdbcUrl("jdbc:h2:file:~/dndb/resources/db1;DB_CLOSE_ON_EXIT=TRUE;FILE_LOCK=NO;INIT=runscript from 'classpath:/db.sql'");
        config.setUsername(null);
        config.setPassword(null);
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
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
