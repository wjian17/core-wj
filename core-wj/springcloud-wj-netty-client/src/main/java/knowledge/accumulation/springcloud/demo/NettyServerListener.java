package knowledge.accumulation.springcloud.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import knowledge.accumulation.springcloud.config.NettyConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * 服务启动监听器
 *
 * @author wj
 */
//@Component
public class NettyServerListener {
    /**
     * NettyServerListener 日志输出器
     *
     * @author wj create by 2017/10/31 18:05
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(NettyServerListener.class);
    /**
     * 创建bootstrap
     */
    ServerBootstrap serverBootstrap = new ServerBootstrap();
    /**
     * BOSS  传递参数为1为单线程 模式为cpu数
     */
    EventLoopGroup boss = new NioEventLoopGroup();
    /**
     * Worker 传递参数为1为单线程  默认为cpu数
     */
    EventLoopGroup work = new NioEventLoopGroup();
    /**
     * 通道适配器
     */
    private ServerChannelHandlerAdapter channelHandlerAdapter = new ServerChannelHandlerAdapter();
    /**
     * NETT服务器配置类
     */
    @Resource
    private NettyConfig nettyConfig;

    /**
     * 关闭服务器方法
     */
    @PreDestroy
    public void close() {
        LOGGER.info("关闭服务器....");
        //优雅退出
        boss.shutdownGracefully();
        work.shutdownGracefully();
    }

    /**
     * 开启及服务线程
     */
    public ChannelFuture start() {
        // 从配置文件中(application.yml)获取服务端监听端口号
//        int port = nettyConfig.getPort();
        int port = 11111;
        serverBootstrap.group(boss, work)
                //设置通讯模式为NIO
                .channel(NioServerSocketChannel.class)
                //缓冲区单位，大小
                .option(ChannelOption.SO_BACKLOG, 1024)
                //SO_SNDBUF 发送缓冲区，SO_RCVBUF接收缓冲区，SO_KEEPALIVE心跳检测保障链接有效
                .option(ChannelOption.SO_SNDBUF,16*1024)
                .option(ChannelOption.SO_RCVBUF,16*1024)
                .option(ChannelOption.SO_KEEPALIVE,true)
                .handler(new LoggingHandler(LogLevel.INFO));
        try {
            //设置事件处理 ,处理逻辑，责任链依次处理
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast(channelHandlerAdapter);
                    //定长处理器
                    ChannelHandler channelHandler = new FixedLengthFrameDecoder(3);
                    //解码处理器
                    ChannelHandler channelHandler2 = new StringDecoder(Charset.forName("UTF-8"));
                    ChannelHandler channelHandler3 = new DelimiterBasedFrameDecoder(1025,Unpooled.copiedBuffer("$_$".getBytes("UTF-8")));

                    pipeline.addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
                    pipeline.addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
                    pipeline.addLast(channelHandler);
                    pipeline.addLast(channelHandler2);
                    pipeline.addLast(channelHandler3);
                }
            });
            LOGGER.info("netty服务器在[{}]端口启动监听", port);
            //ServerBootStrap可以绑定多个port  sync启动
            ChannelFuture f = serverBootstrap.bind(port).sync();
            return f;
        } catch (InterruptedException e) {
            LOGGER.info("[出现异常] 释放资源");
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        NettyServerListener nettyServerListener = new NettyServerListener();
        ChannelFuture future = nettyServerListener.start();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("hystrix input   to client");
            String line = sc.nextLine();
            if("exit".equals(line)){
                future.channel().writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8"))).addListener(ChannelFutureListener.CLOSE);
                break;
            }
            future.channel().writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
            Thread.sleep(1000);
        }
    }
}