package knowledge.accumulation.springcloud.exception.controllerException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAop {

    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e){
        e.printStackTrace();
        return "userLogin/error";
    }

}