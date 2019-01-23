package knowledge.accumulation.springcloud.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
@Service(version = "1.0.0",timeout = 50000)
public class DemoServiceImpl implements com.knowledge.accumulation.service.DemoService {
    @Override
    public void testDubbo() {
        System.out.println("testDubbo success.........");
    }
}
