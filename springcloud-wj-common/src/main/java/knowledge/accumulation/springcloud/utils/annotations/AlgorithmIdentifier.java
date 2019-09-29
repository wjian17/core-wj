package knowledge.accumulation.springcloud.utils.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wj on 2017/7/14.
 * 声明一个方法为算法调用方法，方便对算法的执行时间、效率等熟悉进行监控
 */
@Target({ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AlgorithmIdentifier {

    String value();

}
