package zxl.com.dataconnectpool.c3p0.testone;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Util {
    //cofigName不指定时使用默认配置
    private static ComboPooledDataSource dataSource = null;

    public static Connection getConnection() throws Exception {
        if(dataSource == null){
            dataSource = new ComboPooledDataSource("mysql");
        }
        try {
            return dataSource.getConnection();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("get connection failed", e);
        }
    }
}
