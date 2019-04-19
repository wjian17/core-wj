package knowledge.accumulation.springcloud.config;

import java.io.Serializable;

/**
* 服务器可能返回空的处理
* Created by wj on 2017/6/16-16:46
* Concat wangjian@supplyfintech.com
*/
public class NullWritable implements Serializable {

   private static final long serialVersionUID = -8191640400484155111L;
   private static NullWritable instance = new NullWritable();

   private NullWritable() {
   }

   public static NullWritable nullWritable() {
       return instance;
   }
}

