package knowledge.accumulation.springcloud.service;

import knowledge.accumulation.springcloud.TestApi;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("sayHelloHessian")
public class TestApiImpl implements TestApi {
    @Override
    public Object testMethod(Object request) {
        System.out.println("testMethod service is running");
        return "test";
    }

    @Override
    public List<?> testList(List<Map> lists) {
        System.out.println("testMethod service is running");
        System.out.println(lists.get(0).get("key"));
        return lists;
    }
}
