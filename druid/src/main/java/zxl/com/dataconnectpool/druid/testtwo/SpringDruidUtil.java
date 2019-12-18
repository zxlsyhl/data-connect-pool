package zxl.com.dataconnectpool.druid.testtwo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springapplication.xml")
public class SpringDruidUtil {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test1(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from student");
        System.out.println(list.size());
    }

    @Test
    public void test2(){
        List<Integer> students = jdbcTemplate.queryForList("select id from student", Integer.class);
        for (Integer stuId:students
             ) {
            System.out.println(stuId);
        }
    }

    @Test
    public void test3(){
        jdbcTemplate.execute("insert into student value(7,'list',3,'pudong','sdkfk')");
//        jdbcTemplate.execute("insert into student value(7,'list',3,'pudong','sdkfk')");
    }


    @Test
    public void test4(){
        List<Student> students = jdbcTemplate.query("select * from student", new BeanPropertyRowMapper(Student.class));
        for (Student stu:students
        ) {
            System.out.println(stu.getId());
        }
    }

}
