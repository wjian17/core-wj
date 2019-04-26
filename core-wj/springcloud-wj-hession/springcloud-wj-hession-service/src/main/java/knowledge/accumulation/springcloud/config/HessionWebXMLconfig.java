package knowledge.accumulation.springcloud.config;

import knowledge.accumulation.springcloud.TestApi;
import knowledge.accumulation.springcloud.service.TestApiImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

import javax.annotation.Resource;

@Configuration
public class HessionWebXMLconfig {

    @Resource
    private TestApiImpl testApi;

    /**
     * 1. HessianServiceExporter是由Spring.web框架提供的Hessian工具类，能够将bean转化为Hessian服务
     * 2. @Bean(name = "/helloHessian.do")加斜杠方式会被spring暴露服务路径,发布服务。
     * @return
     */
    @Bean("/exporterTestApi")
    public HessianServiceExporter exporterTestApi()
    {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(testApi);
        exporter.setServiceInterface(TestApi.class);
        return exporter;
    }
}
