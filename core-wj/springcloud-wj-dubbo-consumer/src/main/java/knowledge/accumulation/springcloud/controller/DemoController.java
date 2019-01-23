package knowledge.accumulation.springcloud.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Reference(version = "1.0.0",timeout = 60000)
    private com.knowledge.accumulation.service.DemoService demoService;

    @RequestMapping("/test")
    public String testDemo(){
        System.out.println("1111");
        demoService.testDubbo();
        return "1111";
    }
}
