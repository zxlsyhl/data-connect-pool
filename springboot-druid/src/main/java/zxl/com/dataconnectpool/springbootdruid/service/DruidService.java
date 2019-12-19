package zxl.com.dataconnectpool.springbootdruid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxl.com.dataconnectpool.springbootdruid.util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
@Service
public class DruidService {
    @Autowired
    private DruidUtil druidUtil;

    public void get() {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,10,0, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
        for(int i=0;i<100;i++){
            poolExecutor.execute(new DbClient(i,druidUtil));
        }
        poolExecutor.shutdown();
    }


    static class DbClient implements Runnable{
        DruidUtil druidUtil2;
        int index;
        DbClient(int threadIndex, DruidUtil druidUtil){
            index = threadIndex;
            druidUtil2 = druidUtil;
        }
        @Override
        public void run() {
            try {
                Thread.currentThread().setName("DbClient-"+index);
                System.out.println(Thread.currentThread().getName()+":start!!!!!");
                Connection connection = druidUtil2.getConnection();
                String sql = "select * from student";
                PreparedStatement pst = connection.prepareStatement(sql);
                ResultSet resultSet = pst.executeQuery();
//                while (resultSet.next()){
//                    System.out.println("resultSet.getString(1):"+resultSet.getString(1));
//                }
                resultSet.close();
                pst.close();
                connection.close();
                System.out.println(Thread.currentThread().getName()+":done!!!!!");
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
