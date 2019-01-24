package knowledge.accumulation.springcloud.dao;

import knowledge.accumulation.springcloud.response.ResponseBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("service-provider")
@Service("testMapper")
public interface TestMapper {
    @RequestMapping(value = "service/test", method = RequestMethod.POST)
    public ResponseBean test();

}
