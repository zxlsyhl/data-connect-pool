package zxl.com.dataconnectpool.springbootdruid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import zxl.com.dataconnectpool.springbootdruid.util.DruidUtil;

@SpringBootApplication
public class SpringbootDruidApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDruidApplication.class);
    }

    @Bean
    public DruidUtil getDruidUtil(){
        return new DruidUtil();
    }
}
