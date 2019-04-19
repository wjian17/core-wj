package knowledge.accumulation.springcloud.config;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
Created by wj on 2017/6/16-15:01
Concat wangjian@supplyfintech.com
*/
public class CustomChannelInitializerClient extends ChannelInitializer {
    private Logger logger = LoggerFactory.getLogger(CustomChannelInitializerClient.class);

    private MethodInvokeMeta methodInvokeMeta;

    private Object response;

    public CustomChannelInitializerClient(MethodInvokeMeta methodInvokeMeta) {
        if (!"toString".equals(methodInvokeMeta.getMethodName())) {
            logger.info("[CustomChannelInitializerClient] 调用方法名：{}，入参：{},参数类型：{}，返回值类型{}"
                    , methodInvokeMeta.getMethodName()
                    , methodInvokeMeta.getArgs()
                    , methodInvokeMeta.getParameterTypes()
                    , methodInvokeMeta.getReturnType());
        }
        this.methodInvokeMeta = methodInvokeMeta;
    }

    public Object getResponse() {
        if (response instanceof NullWritable) {
            return null;
        }
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new LengthFieldPrepender(2));
        pipeline.addLast(new LengthFieldBasedFrameDecoder(1024 * 1024, 0, 2, 0, 2));
        pipeline.addLast(new ObjectCodec());
        pipeline.addLast(new ClientChannelHandlerAdapter(methodInvokeMeta, this));
    }

}