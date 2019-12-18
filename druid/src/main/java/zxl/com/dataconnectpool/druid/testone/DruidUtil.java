package zxl.com.dataconnectpool.druid.testone;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUtil {
    private static Properties prop = new Properties();
    private static DataSource dataSource;

    static {
        FileInputStream fis = null;
        try {
            String path = DruidUtil.class.getResource("/").getPath();
            System.out.println("path:"+path);
            fis = new FileInputStream(path+"/druid.properties");
            prop.load(fis);
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
