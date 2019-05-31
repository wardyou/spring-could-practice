package practice.wyadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("practice.wyadmin.mapper")
@EnableScheduling
public class WyAdminApplication{
    public static void main(String[] args) {
        SpringApplication.run(WyAdminApplication.class, args);
    }
}
