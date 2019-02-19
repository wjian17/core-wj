package knowledge.accumulation.springcloud.dao;

import knowledge.accumulation.springcloud.response.ResponseBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("springcloud-wj-configServer")
public interface TestMapper {
    @RequestMapping(value = "test", method = RequestMethod.POST)
    ResponseBean test();

}
