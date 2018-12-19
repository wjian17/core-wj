package com.knowledge.accumulation.utils.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wj on 2017/8/7.
 * 使用此注解将一个普通方法标识成为一个服务
 * value属性声明服务名称
 * 服务名称命名规则：ES-服务描述-T
 * 如:
 *      登录服务可以命名为：ES-login-T
 *      获取算法列表服务可以命名为：ES-AlgorithmList-T
 *
 *
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EService {

    String value();

}
