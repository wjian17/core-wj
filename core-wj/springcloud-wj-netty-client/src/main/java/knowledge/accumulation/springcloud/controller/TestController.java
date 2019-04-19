package knowledge.accumulation.springcloud.controller;

import knowledge.accumulation.springcloud.config.MethodInvokeMeta;
import knowledge.accumulation.springcloud.config.NettyClient;
import knowledge.accumulation.springcloud.config.WrapMethodUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping(value = "/test")
    public void test() throws Exception{
        NettyClient nettyClient = new NettyClient("127.0.0.1:11111",8011);
        Class c = TestController.class;
        MethodInvokeMeta methodInvokeMeta = WrapMethodUtils.readMethod(c,c.getMethod("test",new Class[]{}),new Object[]{});
        nettyClient.remoteCall(methodInvokeMeta,0);
    }
}
