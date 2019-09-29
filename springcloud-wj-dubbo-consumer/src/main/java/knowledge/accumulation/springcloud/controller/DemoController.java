package knowledge.accumulation.springcloud.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import knowledge.accumulation.springcloud.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Reference(version = "1.0.0",timeout = 60000)
    private DemoService demoService;

    @RequestMapping("/test")
    public String testDemo(@RequestParam("id") long id){
        System.out.println("1111");
        demoService.testDubbo(id);
        return "1111";
    }
}
