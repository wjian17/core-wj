package knowledge.accumulation.springcloud.controller;

import knowledge.accumulation.springcloud.response.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/TestController")
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/test")
//    @RequiresPermissions("TestController")
    @ResponseBody
    public ResponseBean test() {
        logger.info("test is running");
        ResponseBean responseBean = new ResponseBean();
        int i = 1 / 0;
        try {

        } catch (Exception e) {
            logger.error("test logger error:{}", e.getMessage());
            e.printStackTrace();
        }
        return responseBean;
    }

    @ExceptionHandler(value = ArithmeticException.class)
    public String handleException(ArithmeticException arithmeticException) {
//        e.printStackTrace();
        System.out.println("exception ............................");
        System.out.println("exception ............................");
        System.out.println("exception ............................");
        return "134134";
    }

}
