package knowledge.accumulation.springcloud.config;

import knowledge.accumulation.springcloud.service.TestService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class CxfConfig {

    @Autowired
    private Bus bus;

    @Autowired
    private TestService testService;

    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus, testService);
        endpoint.publish("/TestService");
        return endpoint;
    }
}