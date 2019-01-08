package knowledge.accumulation.springcloud.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerLog {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String SERVICE_POINT_CUT = "execution(* knowledge.accumulation.springcloud.controller..*(..))";

    @Pointcut(SERVICE_POINT_CUT)
    public void ServicePointCut(){

    }
    @Around(value = "ServicePointCut()")
    public Object aspectLog(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("11111");
        Object proceed = pjp.proceed();

        return proceed;
    }

}
