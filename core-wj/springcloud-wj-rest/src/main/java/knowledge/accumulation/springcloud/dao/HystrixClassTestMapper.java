package knowledge.accumulation.springcloud.dao;

import knowledge.accumulation.springcloud.hystrix.HystrixClassFeign;
import knowledge.accumulation.springcloud.response.ResponseBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "springcloud-wj-configServer",fallback = HystrixClassFeign.class)
public interface HystrixClassTestMapper {

    @RequestMapping(value = "test1", method = RequestMethod.POST)
    ResponseBean test();
}
