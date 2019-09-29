package knowledge.accumulation.springcloud.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import knowledge.accumulation.springcloud.hystrix.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Api(value = "测试", description = "测试")
public class TestController extends GlobalExceptionHandler{

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ApiOperation(value="测试", notes="测试")
    @ApiImplicitParam(name = "username",value = "",required = true,defaultValue = "")
    public void test(){
        int i = 1/0;
        testService.test();
    }

//    @ExceptionHandler(value = ArithmeticException.class)
//    public String handleException(ArithmeticException e){
////        e.printStackTrace();
//        System.out.println("exception ............................");
//        System.out.println("exception ............................");
//        System.out.println("exception ............................");
//        return "134134";
//    }

}
