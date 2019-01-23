package knowledge.accumulation.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import knowledge.accumulation.springcloud.ErrorCode;
import knowledge.accumulation.springcloud.RestResponse;
import knowledge.accumulation.springcloud.dao.TestMapper;
import knowledge.accumulation.springcloud.response.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestService {

    @Autowired
    @Qualifier("testMapper")
    private TestMapper testMapper;

    @HystrixCommand(groupKey = "aibeeFaceRecognitionGroup", fallbackMethod = "fallBackCall")
    public ResponseBean test() {
        return testMapper.test();
    }

    public RestResponse fallBackCall() {
        return returnHystrixError();
    }

    public RestResponse returnHystrixError(){
        RestResponse restResponse = new RestResponse();
        restResponse.getResponseHeader().setErrorCode(ErrorCode.EXCEPTION);
        restResponse.getResponseHeader().setMessage("FAILED SERVICE CALL! - FALLING BACK");
        return restResponse;
    }
}