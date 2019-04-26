package knowledge.accumulation.springcloud;

import java.util.List;
import java.util.Map;

public interface TestApi {

    Object testMethod(Object request);

    List<?> testList(List<Map> lists);
}
