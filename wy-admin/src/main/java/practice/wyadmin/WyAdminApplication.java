package practice.wyadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("practice.wyadmin.mapper")
public class WyAdminApplication{
    public static void main(String[] args) {
        SpringApplication.run(WyAdminApplication.class, args);
    }
}
