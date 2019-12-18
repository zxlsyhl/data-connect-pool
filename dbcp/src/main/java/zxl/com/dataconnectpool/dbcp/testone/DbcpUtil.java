package zxl.com.dataconnectpool.dbcp.testone;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DbcpUtil {
    private static Properties properties = new Properties();
    private static DataSource dataSource;

    static {
        FileInputStream fis = null;
        try {
            String path = DbcpUtil.class.getResource("/").getPath();
            System.out.println("path:"+path);
            fis = new FileInputStream(path+"/dbcp.properties");
            properties.load(fis);
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
