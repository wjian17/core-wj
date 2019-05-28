package knowledge.accumulation.springcloud.exception.controllerException;

import cn.stylefeng.roses.core.exception.DefaultExceptionHandler;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerAop extends DefaultExceptionHandler {

    @ExceptionHandler(value = ArithmeticException.class)
    @ResponseBody
    public ModelAndView handleException(ArithmeticException e){
//        e.printStackTrace();
        System.out.println("exception ............................");
        System.out.println("exception ............................");
        System.out.println("exception ............................");
        return new ModelAndView("userLogin/error");
    }

    public ControllerAop(){
        System.out.println("实例化");
    }

    @ResponseBody
    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String AuthorizationExceptionHandle(Exception e){
        e.printStackTrace();
        return "userLogin/error";
    }

}