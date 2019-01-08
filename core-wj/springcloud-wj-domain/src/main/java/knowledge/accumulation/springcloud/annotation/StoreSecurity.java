package knowledge.accumulation.springcloud.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wj on 2017/10/26.
 * 标识某个字段为存储安全字段，也就是说需要自动加密解密的过程
 */
@Target({ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface StoreSecurity {

}
