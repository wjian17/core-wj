package knowledge.accumulation.springcloud.controller;

import knowledge.accumulation.springcloud.response.ResponseBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "test",method = RequestMethod.POST)
    public ResponseBean test(){

        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
        ResponseBean responseBean = new ResponseBean();
        System.out.println("00000000000000000");
        return responseBean;
    }
    @RequestMapping(value = "test1",method = RequestMethod.POST)
    public ResponseBean test1(){

        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
        ResponseBean responseBean = new ResponseBean();
        System.out.println("11111111");
        return responseBean;
    }
}
