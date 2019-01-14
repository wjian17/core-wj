package knowledge.accumulation.springcloud.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @RequestMapping("/")
    public void test(@RequestParam(value = "11",defaultValue = "2",required = false) int pageSize){
//        ClassPathApplicationContext
    }

    //路径占位符  demo8/abc/1  注意路径问题【返回页面相对于demo8.abc】 return main.jsp;  /main.jsp
    //produces 设置响应头中的head属性
    @RequestMapping(value = "/demo/{name1}/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public void test(@PathVariable(value = "name1")String name,int id){

    }
}
