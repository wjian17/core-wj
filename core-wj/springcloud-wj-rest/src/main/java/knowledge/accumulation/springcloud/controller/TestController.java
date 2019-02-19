package knowledge.accumulation.springcloud.controller;

import knowledge.accumulation.springcloud.dao.HystrixClassTestMapper;
import knowledge.accumulation.springcloud.response.ResponseBean;
import knowledge.accumulation.springcloud.hystrix.HystrixTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private HystrixTest testService;
    @Autowired
    private HystrixClassTestMapper hystrixClassTestMapper;

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public ResponseBean test(){

        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
        return testService.test();
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
