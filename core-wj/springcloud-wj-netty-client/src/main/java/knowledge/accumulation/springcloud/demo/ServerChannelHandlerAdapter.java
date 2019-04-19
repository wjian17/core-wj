package knowledge.accumulation.springcloud.demo;// 记录调用方法的元信息的类

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 多线程共享  sharable handler可以被多个客户端共享,避免定义可写的实例变量，不添加每次都得重新创建handler
 */
//@Component
//@Sharable
public class ServerChannelHandlerAdapter extends ChannelHandlerAdapter {
    /**
     * 日志处理
     */
    private Logger logger = LoggerFactory.getLogger(ServerChannelHandlerAdapter.class);

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(msg.getClass());
        ByteBuf readBuffer = (ByteBuf)msg;
        byte[] tempDatas = new byte[readBuffer.readableBytes()];
        readBuffer.readBytes(tempDatas);
        String message = new String(tempDatas,"UTF-8");
        if("exit".equals(message)){
            ctx.close();
            return;
        }
        String line = "client message to server!=========="+message;
        System.out.println(line);
        line = "backtoclient message======"+message;
        //写操作自动释放缓存，避免内存溢出  write单独调用不会刷新缓存，再次调用flush
        ctx.writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
    }
}