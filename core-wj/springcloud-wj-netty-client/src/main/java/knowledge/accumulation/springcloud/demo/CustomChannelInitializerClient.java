package knowledge.accumulation.springcloud.demo;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

/**
Created by wj on 2017/6/16-15:01
Concat wangjian@supplyfintech.com
*/
public class CustomChannelInitializerClient extends ChannelInitializer {
    private Logger logger = LoggerFactory.getLogger(CustomChannelInitializerClient.class);

    ClientChannelHandlerAdapter clientChannelHandlerAdapter = new ClientChannelHandlerAdapter();

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(clientChannelHandlerAdapter);
        //定长处理器
        ChannelHandler channelHandler = new FixedLengthFrameDecoder(3);
        //解码处理器
        ChannelHandler channelHandler2 = new StringDecoder(Charset.forName("UTF-8"));
        ChannelHandler channelHandler3 = new DelimiterBasedFrameDecoder(1025, Unpooled.copiedBuffer("$_$".getBytes("UTF-8")));

        pipeline.addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
        pipeline.addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
        pipeline.addLast(channelHandler);
        pipeline.addLast(channelHandler2);
        pipeline.addLast(channelHandler3);
    }

}