package knowledge.accumulation.springcloud.hystrix.impl;

import com.alibaba.dubbo.config.annotation.Service;
import knowledge.accumulation.springcloud.domain.Client;
import knowledge.accumulation.springcloud.mapper.ClientMapper;
import knowledge.accumulation.springcloud.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Service(version = "1.0.0",timeout = 50000,interfaceClass = DemoService.class )
@Transactional(rollbackFor = Exception.class)
public class DemoServiceImpl implements DemoService {

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public void testDubbo(long id) {
        Client client = new Client();
        client.setId(id);
        client.setClientName("cname");
        client.setClientSecret("secret");
        clientMapper.insertSelective(client);
        if(id==10) {
            int i = 1 / 0;
        }
        System.out.println("testDubbo success.........");
    }
}
