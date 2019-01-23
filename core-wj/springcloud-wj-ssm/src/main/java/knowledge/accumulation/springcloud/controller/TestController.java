package knowledge.accumulation.springcloud.controller;

import knowledge.accumulation.springcloud.domain.TestP;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController{

    @RequestMapping("/")
    public void test(@RequestParam(value = "11",defaultValue = "2",required = false) int pageSize){
//        ApplicationContext

    }

    //路径占位符  demo8/abc/1  注意路径问题【返回页面相对于demo8.abc】 return main.jsp;  /main.jsp
    //produces 设置响应头中的head属性
    @RequestMapping(value = "/demo/{name1}/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void test(@PathVariable(value = "name1")String name,int id){
    }

    @RequestMapping("/test")
    public void test(HttpServletRequest request){
//        ApplicationContext
        Object object = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext()).getBean("testP");
        Object object1 = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext()).getBean("children");
        TestP testP = (TestP)object;
        testP.process();
//        InvocationHandler
//        DispatcherServlet
//        AopAutoConfiguration.JdkDynamicAutoProxyConfiguration
        System.out.println("111");
//        TransactionAutoConfiguration.EnableTransactionManagementConfiguration.JdkDynamicAutoProxyConfiguration
    }

//    @Pointcut(argNames = "",value = "")
}
