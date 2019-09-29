@Configuration
public class MyConfiguration {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

restTemplate调用需先注入
HystrixCommand注解默认开启熔断，降级及线程池隔离机制【服务隔离】
1：commandKey：配置全局唯一标识服务的名称，比如，库存系统有一个获取库存服务，那么就可以为这个服务起一个名字来唯一识别该服务，如果不配置，则默认是@HystrixCommand注解修饰的函数的函数名。
2：groupKey：一个比较重要的注解，配置全局唯一标识服务分组的名称，比如，库存系统就是一个服务分组。通过设置分组，Hystrix会根据组来组织和统计命令的告、仪表盘等信息。Hystrix命令默认的线程划分也是根据命令组来实现。默认情况下，Hystrix会让相同组名的命令使用同一个线程池，所以我们需要在创建Hystrix命令时为其指定命令组来实现默认的线程池划分。此外，Hystrix还提供了通过设置threadPoolKey来对线程池进行设置。建议最好设置该参数，使用threadPoolKey来控制线程池组。
3：threadPoolKey：对线程池进行设定，细粒度的配置，相当于对单个服务的线程池信息进行设置，也可多个服务设置同一个threadPoolKey构成线程组。
4：fallbackMethod：@HystrixCommand注解修饰的函数的回调函数，@HystrixCommand修饰的函数必须和这个回调函数定义在同一个类中，因为定义在了同一个类中，所以fackback method可以是public/private均可。
5：commandProperties：配置该命令的一些参数，如executionIsolationStrategy配置执行隔离策略，默认是使用线程隔离，此处我们配置为THREAD，即线程池隔离。参见：com.netflix.hystrix.HystrixCommandProperties中各个参数的定义。
6：threadPoolProperties：线程池相关参数设置，具体可以设置哪些参数请见：com.netflix.hystrix.HystrixThreadPoolProperties
7：ignoreExceptions：调用服务时，除了HystrixBadRequestException之外，其他@HystrixCommand修饰的函数抛出的异常均会被Hystrix认为命令执行失败而触发服务降级的处理逻辑（调用fallbackMethod指定的回调函数），所以当需要在命令执行中抛出不触发降级的异常时来使用它，通过这个参数指定，哪些异常抛出时不触发降级（不去调用fallbackMethod），而是将异常向上抛出。
8：observableExecutionMode：定义hystrix observable command的模式；
9：raiseHystrixExceptions：任何不可忽略的异常都包含在HystrixRuntimeException中；
10：defaultFallback：默认的回调函数，该函数的函数体不能有入参，返回值类型与@HystrixCommand修饰的函数体的返回值一致。如果指定了fallbackMethod，则fallbackMethod优先级更高。


        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!--<dependency>-->
            <!--<groupId>org.springframework.cloud</groupId>-->
            <!--<artifactId>spring-cloud-starter-openfeign</artifactId>-->
            <!--<version>2.0.0.RELEASE</version>-->
        <!--</dependency>-->

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
            <version>2.1.0.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
            <version>2.1.0.RELEASE</version>
        </dependency>

         <dependency>
             <groupId>org.springframework.cloud</groupId>
             <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
             <version>2.1.0.RELEASE</version>
         </dependency>



如果hystrix.command.default.execution.timeout.enabled为true,则会有两个执行方法超时的配置,一个就是ribbon的ReadTimeout,一个就是熔断器hystrix的timeoutInMilliseconds, 此时谁的值小谁生效
如果hystrix.command.default.execution.timeout.enabled为false,则熔断器不进行超时熔断,而是根据ribbon的ReadTimeout抛出的异常而熔断,也就是取决于ribbon
ribbon的ConnectTimeout,配置的是请求服务的超时时间,除非服务找不到,或者网络原因,这个时间才会生效
ribbon还有MaxAutoRetries对当前实例的重试次数,MaxAutoRetriesNextServer对切换实例的重试次数, 如果ribbon的ReadTimeout超时,或者ConnectTimeout连接超时,会进行重试操作
通常熔断的超时时间需要配置的比ReadTimeout长,ReadTimeout比ConnectTimeout长



ribbon:
  OkToRetryOnAllOperations: false #对所有操作请求都进行重试,默认false
  ReadTimeout: 10000   #负载均衡超时时间，默认值5000
  ConnectTimeout: 2000 #ribbon请求连接的超时时间，默认值2000
  MaxAutoRetries: 0     #对当前实例的重试次数，默认0
  MaxAutoRetriesNextServer: 1 #对切换实例的重试次数，默认1

hystrix:
  command:
    default:  #default全局有效，service id指定应用有效
      execution:
        timeout:
          enabled: true
        isolation:
          thread:
            timeoutInMilliseconds: 10000 #断路器超时时间，默认1000ms


hystrix 配置方式 1：rest和service开启不同线程，
//@FeignClient("compute-service")
@FeignClient(value = "compute-service", fallback = ComputeClientHystrix.class)
public interface ComputeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}

@Component
public class ComputeClientHystrix implements ComputeClient {
    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -9999;
    }
}



hystrix 配置方式 2： 同一个线程  rest和service共享同一个线程
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