package knowledge.accumulation.springcloud.hystrix;

import knowledge.accumulation.springcloud.dao.HystrixClassTestMapper;
import knowledge.accumulation.springcloud.response.ResponseBean;
import org.springframework.stereotype.Component;

@Component
public class HystrixClassFeign implements HystrixClassTestMapper {
    @Override
    public ResponseBean test() {
        System.out.println("1111111111111111111111111");
        return null;
    }
}
