package knowledge.accumulation.springcloud.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class GlobalExceptionHandler {

    @ExceptionHandler(value = ArithmeticException.class)
    @ResponseBody
    public String handleException(ArithmeticException e){
//        e.printStackTrace();
        System.out.println("exception ............................");
        System.out.println("exception ............................");
        System.out.println("exception ............................");
        return "134134";
    }

}