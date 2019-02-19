package knowledge.accumulation.springcloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    @Qualifier("domeRepository")
    private knowledge.accumulation.springcloud.hystrix.domain.DomeRepository domeRepository;

    @Autowired
    @Qualifier("logDomeRepository")
    private knowledge.accumulation.springcloud.hystrix.log.DomeRepository logDomeRepository;

    @RequestMapping
    @ResponseBody
    public knowledge.accumulation.springcloud.module.jpa.pojo.Test test(@RequestBody knowledge.accumulation.springcloud.module.jpa.pojo.Test test){
        List<knowledge.accumulation.springcloud.module.jpa.pojo.Test> tests =domeRepository.findAll();
        List<knowledge.accumulation.springcloud.module.jpa.logpojo.Log> logs =logDomeRepository.findAll();
//        HandlerInterceptor
        return tests.get(0);
    }


}
