package knowledge.accumulation.springcloud.config;

import org.springframework.stereotype.Component;

/**
 * Netty服务器常量
 * Created by wj on 2017/10/31 - 17:47
 * Concat wangjian@supplyfintech.com
 */
@Component
public class NettyConstant {

    /**
     * 最大线程量
     */
    private static final int MAX_THREADS = 1024;
    /**
     * 数据包最大长度
     */
    private static final int MAX_FRAME_LENGTH = 65535;

    public static int getMaxFrameLength() {
        return MAX_FRAME_LENGTH;
    }

    public static int getMaxThreads() {
        return MAX_THREADS;
    }
}