package com.knowledge.accumulation.config;

import com.edu.hart.rpc.client.RPCProxyFactoryBean;
   import org.springframework.beans.BeansException;
   import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
   import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
   import org.springframework.beans.factory.support.BeanDefinitionBuilder;
   import org.springframework.beans.factory.support.DefaultListableBeanFactory;

   import java.util.List;

   /**
    * 动态加载代理bean到Spring bean工厂
    */
   public class NettyBeanScanner implements BeanFactoryPostProcessor {

       private DefaultListableBeanFactory beanFactory;

       private String basePackage;

       private String clientName;

       public NettyBeanScanner(String basePackage, String clientName) {
           this.basePackage = basePackage;
           this.clientName = clientName;
       }


       /**
        * 注册Bean到Spring的bean工厂
        */
       public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
           this.beanFactory = (DefaultListableBeanFactory) beanFactory;
           // 加载远程服务的接口
           List<String> resolverClass = PackageClassUtils.resolver(basePackage);
           for (String clazz : resolverClass) {
               String simpleName;
               if (clazz.lastIndexOf('.') != -1) {
                   simpleName = clazz.substring(clazz.lastIndexOf('.') + 1);
               } else {
                   simpleName = clazz;
               }
               BeanDefinitionBuilder gd = BeanDefinitionBuilder.genericBeanDefinition(RPCProxyFactoryBean.class);
               gd.addPropertyValue("interfaceClass", clazz);
               gd.addPropertyReference("nettyClient", clientName);
               this.beanFactory.registerBeanDefinition(simpleName, gd.getRawBeanDefinition());
           }
       }
   }
--------------------- 
作者：叶云轩 
来源：CSDN 
原文：https://blog.csdn.net/yuanzhenwei521/article/details/79194275 
版权声明：本文为博主原创文章，转载请附上博文链接！