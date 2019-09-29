package knowledge.accumulation.springcloud.service.impl;
import knowledge.accumulation.springcloud.request.RequestBean;
import knowledge.accumulation.springcloud.response.ResponseBean;
import knowledge.accumulation.springcloud.service.TestService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@WebService(serviceName = "TestService", // 与接口中指定的name一致
        targetNamespace = "http://knowledge.accumulation.springcloud/", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "knowledge.accumulation.springcloud.service.TestService"// 接口地址
)
@Component
public class TestServiceImpl implements TestService {

    @Override
    public String sendMessage(String username) {
        return "hello " + username;
    }

    @Override
    public ResponseBean jsonPost(RequestBean requestBean) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setResponseCode("0000");
        responseBean.setResponseMsg("0000");
        responseBean.setData(requestBean.getData());
        return responseBean;
    }

}