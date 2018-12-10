package com.knowledge.accumulation.config;

import java.io.Serializable;

/**
* 服务器可能返回空的处理
* Created by 叶云轩 on 2017/6/16-16:46
* Concat tdg_yyx@foxmail.com
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

