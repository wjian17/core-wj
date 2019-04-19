package knowledge.accumulation.springcloud.demo;// 记录元方法信息的实体类
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.management.MBeanServer;
import java.util.Scanner;

/**
 * 客户端发送类
 * Created by wj on 2017/6/16-16:58
 * Concat wangjian@supplyfintech.com
 */
public class NettyClient {

    private Logger logger = LoggerFactory.getLogger(MBeanServer.class);
    private Bootstrap bootstrap;
    private EventLoopGroup worker;
    private int port;
    private String url;
    private int MAX_RETRY_TIMES = 10;

    public NettyClient(String url, int port) {
        this.url = url;
        this.port = port;
        bootstrap = new Bootstrap();
        worker = new NioEventLoopGroup();
        bootstrap.group(worker);
        bootstrap.channel(NioSocketChannel.class);
    }

    public void close() {
        logger.info("关闭资源");
        worker.shutdownGracefully();
    }

    public ChannelFuture remoteCall(int retry) {
        try {
            CustomChannelInitializerClient customChannelInitializer = new CustomChannelInitializerClient();
            bootstrap.handler(customChannelInitializer);
            ChannelFuture sync = bootstrap.connect(url, port).sync();
            return sync;
        } catch (InterruptedException e) {
            retry++;
            if (retry > MAX_RETRY_TIMES) {
                throw new RuntimeException("调用Wrong");
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                logger.info("第{}次尝试....失败", retry);
                return remoteCall(retry);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        NettyClient nettyClient = new NettyClient("localhost",11111);
        ChannelFuture future = nettyClient.remoteCall(3);
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("hystrix input   to client");
            String line = sc.nextLine();
            TestPojo testPojo = new TestPojo();
            testPojo.setName("***************88");
            future.channel().writeAndFlush(testPojo);
            if("exit".equals(line)){
                future.channel().writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8"))).addListener(ChannelFutureListener.CLOSE);
                break;
            }
            future.channel().writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
        }
    }
}