package knowledge.accumulation.springcloud;

import knowledge.accumulation.springcloud.config.netty.NettyServerListener;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * Hello world!
 */
@SpringBootApplication
public class NettyApplication implements CommandLineRunner {

    @Resource
    private NettyServerListener nettyServerListener;

    public static void main(String[] args) {
        SpringApplication.run(NettyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        nettyServerListener.start();
    }

}
