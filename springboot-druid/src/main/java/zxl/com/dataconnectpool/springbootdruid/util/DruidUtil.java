package zxl.com.dataconnectpool.springbootdruid.util;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class DruidUtil {
    @Autowired
    private DataSource dataSource;

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }


}
