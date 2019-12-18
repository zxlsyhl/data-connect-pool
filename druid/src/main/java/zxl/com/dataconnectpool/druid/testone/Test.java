package zxl.com.dataconnectpool.druid.testone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,10,0, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
        for(int i=0;i<100;i++){
            poolExecutor.execute(new DbClient(i));
        }
        poolExecutor.shutdown();
    }


    static class DbClient implements Runnable{
        int index;
        DbClient(int threadIndex){
            index = threadIndex;
        }
        @Override
        public void run() {
            try {
                Thread.currentThread().setName("DbClient-"+index);
                System.out.println(Thread.currentThread().getName()+":start!!!!!");
                Connection connection = DruidUtil.getConnection();
                String sql = "select * from student";
                PreparedStatement pst = connection.prepareStatement(sql);
                ResultSet resultSet = pst.executeQuery();
//                while (resultSet.next()){
//                    System.out.println("resultSet.getString(1):"+resultSet.getString(1));
//                }
                System.out.println(Thread.currentThread().getName()+":done!!!!!");
                Thread.sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
