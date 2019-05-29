package practice.wyadmin;

import io.netty.channel.ChannelFuture;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import practice.wyadmin.config.NettySever;

import java.net.InetSocketAddress;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("practice.wyadmin.mapper")
public class WyAdminApplication implements CommandLineRunner {
    @Value("${netty.port}")
    private int port;

    @Value("${netty.url}")
    private String url;

    @Autowired
    private NettySever socketServer;
    public static void main(String[] args) {
        SpringApplication.run(WyAdminApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        InetSocketAddress address = new InetSocketAddress(url, port);
        ChannelFuture future = socketServer.run(address);
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                socketServer.destroy();
            }
        });
        future.channel().closeFuture().syncUninterruptibly();
    }
}
