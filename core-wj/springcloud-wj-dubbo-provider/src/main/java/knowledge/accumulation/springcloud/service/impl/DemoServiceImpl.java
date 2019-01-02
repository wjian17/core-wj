package knowledge.accumulation.springcloud.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import knowledge.accumulation.springcloud.service.DemoService;
import org.springframework.stereotype.Component;

@Component
@Service(version = "1.0.0",timeout = 50000)
public class DemoServiceImpl implements DemoService {
    @Override
    public void testDubbo() {
        System.out.println("testDubbo success.........");
    }
}
