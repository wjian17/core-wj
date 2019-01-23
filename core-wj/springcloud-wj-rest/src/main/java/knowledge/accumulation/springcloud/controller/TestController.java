package knowledge.accumulation.springcloud.controller;

import knowledge.accumulation.springcloud.response.ResponseBean;
import knowledge.accumulation.springcloud.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public ResponseBean test(){
        return testService.test();
    }
}
