package com.knowledge.accumulation.config;

import io.netty.buffer.ByteBuf;
   import io.netty.buffer.Unpooled;
   import io.netty.channel.ChannelHandlerContext;
   import io.netty.handler.codec.MessageToMessageCodec;

   import java.util.List;

   public class ObjectCodec extends MessageToMessageCodec<ByteBuf, Object> {

       @Override
       protected void encode(ChannelHandlerContext ctx, Object msg, List<Object> out) {
           byte[] data = ObjectSerializerUtils.serilizer(msg);
           ByteBuf buf = Unpooled.buffer();
           buf.writeBytes(data);
           out.add(buf);
       }

       @Override
       protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) {
           byte[] bytes = new byte[msg.readableBytes()];
           msg.readBytes(bytes);
           Object deSerilizer = ObjectSerializerUtils.deSerilizer(bytes);
           out.add(deSerilizer);
       }

   }
--------------------- 
作者：叶云轩 
来源：CSDN 
原文：https://blog.csdn.net/yuanzhenwei521/article/details/79194275 
版权声明：本文为博主原创文章，转载请附上博文链接！