package com.knowledge.accumulation.demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 叶云轩 on 2017/6/16-17:03
 * Concat tdg_yyx@foxmail.com
 */
public class ClientChannelHandlerAdapter extends ChannelHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(ClientChannelHandlerAdapter.class);

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
        String line = "server message to client!=========" +  message;
        System.out.println(line);
        //写操作自动释放缓存，避免内存溢出  write单独调用不会刷新缓存，再次调用flush
//        ctx.writeAndFlush(Unpooled.copiedBuffer(line.getBytes("UTF-8")));
        //客户端刷新缓存
//        ReferenceCountUtil.release(msg);
    }
}