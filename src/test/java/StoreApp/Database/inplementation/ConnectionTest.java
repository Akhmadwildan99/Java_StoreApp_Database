package StoreApp.Database.inplementation;

import StoreApp.Database.inplementation.util.ConnectionUtil;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class ConnectionTest {
    private HikariDataSource dataSource;

    @BeforeEach
    void setUp() {
        dataSource = ConnectionUtil.getDataSource();
    }

    @Test
    void testConnection() throws SQLException {
        dataSource.getConnection();
        dataSource.close();
    }
}
