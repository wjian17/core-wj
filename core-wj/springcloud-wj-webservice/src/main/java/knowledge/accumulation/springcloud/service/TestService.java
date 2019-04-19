package knowledge.accumulation.springcloud.service;

import knowledge.accumulation.springcloud.request.RequestBean;
import knowledge.accumulation.springcloud.response.ResponseBean;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
@WebService(name = "TestService", // 暴露服务名称
        targetNamespace = "http://knowledge.accumulation.springcloud/"// 命名空间,一般是接口的包名倒序
)
public interface TestService {

    @WebMethod
    @WebResult(name = "String", targetNamespace = "")
    String sendMessage(@WebParam(name = "username") String username);

    @WebMethod
    @WebResult(name = "String", targetNamespace = "")
    ResponseBean jsonPost(@WebParam(name = "jsonbody") RequestBean requestBean);
}