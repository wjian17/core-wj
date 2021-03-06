package knowledge.accumulation.springcloud.config;

import knowledge.accumulation.springcloud.NettyBeanScanner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Netty相关的初始化入口
 * <p>
 *
 * @author wangjian contact by wangjian@supplyfintech.com
 * @date 2018/7/9 - 上午9:32
 */
@Configuration
public class NettyConfiguration {

    /**
     * 初始化加载Netty相关bean的配置方法
     *
     * @param basePackage 配置的包名
     * @param clientName  配置的Netty实例对象名
     * @return NettyBeanScanner
     */
    @Bean
    public static NettyBeanScanner initNettyBeanScanner(@Value("${netty.basePackage}") String basePackage,
                                                        @Value("${netty.clientName}") String clientName) {
        // 创建对象
        return new NettyBeanScanner(basePackage, clientName);
    }
}
