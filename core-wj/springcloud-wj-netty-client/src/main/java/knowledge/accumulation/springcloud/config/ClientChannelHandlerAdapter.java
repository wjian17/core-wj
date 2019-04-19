package knowledge.accumulation.springcloud.config;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Concat wangjian@supplyfintech.com
 */
public class ClientChannelHandlerAdapter extends ChannelHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(ClientChannelHandlerAdapter.class);
    private MethodInvokeMeta methodInvokeMeta;
    private CustomChannelInitializerClient channelInitializerClient;

    public ClientChannelHandlerAdapter(MethodInvokeMeta methodInvokeMeta, CustomChannelInitializerClient channelInitializerClient) {
        this.methodInvokeMeta = methodInvokeMeta;
        this.channelInitializerClient = channelInitializerClient;
    }

    @Override
    /**
     * 客户端异常退出的时候也会运行
     */
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.info("客户端出异常了,异常信息:{}", cause.getMessage());
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        if (methodInvokeMeta.getMethodName().endsWith("toString") && !"class java.lang.String".equals(methodInvokeMeta.getReturnType().toString()))
            logger.info("客户端发送信息参数:{},信息返回值类型：{}", methodInvokeMeta.getArgs(), methodInvokeMeta.getReturnType());
        ctx.writeAndFlush(methodInvokeMeta);

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf readBuffer = (ByteBuf)msg;
        byte[] tempDatas = new byte[readBuffer.readableBytes()];
        readBuffer.readBytes(tempDatas);
        String message = new String(tempDatas,"UTF-8");
        if("exit".equals(message)){
            ctx.close();
            return;
        }
        String line = "server message to client!";
        //写操作自动释放缓存，避免内存溢出  write单独调用不会刷新缓存，再次调用flush
        ctx.writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
        channelInitializerClient.setResponse(msg);
    }
}