package knowledge.accumulation.springcloud.controller;

import knowledge.accumulation.springcloud.dao.HystrixClassTestMapper;
import knowledge.accumulation.springcloud.hystrix.HystrixTest;
import knowledge.accumulation.springcloud.response.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

    @Autowired
    private HystrixTest testService;
    @Autowired
    private HystrixClassTestMapper hystrixClassTestMapper;

    @Value("${name}")
    private String name;

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public ResponseBean test(){
        System.out.println(name);
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
//        return testService.test();
        ResponseBean responseBean = new ResponseBean();
        responseBean.setData(name);
        return responseBean;
    }

    @RequestMapping(value = "/test1",method = RequestMethod.POST)
    public ResponseBean test1(){

        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
        ResponseBean responseBean = new ResponseBean();
        responseBean = hystrixClassTestMapper.test();
        return responseBean;
    }
}
