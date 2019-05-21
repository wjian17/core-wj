package knowledge.accumulation.springcloud.controller;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice(basePackages = "knowledge.accumulation.springcloud.controller")
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ArithmeticException.class)
    public String handleException(ArithmeticException e){
//        e.printStackTrace();
        System.out.println("exception ............................");
        System.out.println("exception ............................");
        System.out.println("exception ............................");
        return "134134";
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String UnauthorizedExceptionHandler(UnauthorizedException e){
        e.printStackTrace();
        return "userLogin/error";
    }

    @ExceptionHandler(value = AuthenticationException.class)
    public String AuthenticationExceptionHandler(AuthenticationException e){
        e.printStackTrace();
        return "userLogin/error";
    }

}