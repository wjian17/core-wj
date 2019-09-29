package knowledge.accumulation.springcloud.util;


import knowledge.accumulation.springcloud.domain.MethodInvokeMeta;

import java.lang.reflect.Method;

/**
 * 封装接口调用的工具
 * <p>
 *
 * @author wangjian contact by wangjian@supplyfintech.com
 * @date 2018/8/15 - 12:27
 */
public class WrapMethodUtils {
    /**
     * 封装 method 的元数据信息
     *
     * @param interfaceClass 接口类
     * @param method         方法
     * @param args           参数列表
     * @return 封装的对象
     */
    public static MethodInvokeMeta readMethod(Class interfaceClass, Method method, Object[] args) {
        MethodInvokeMeta methodInvokeMeta = new MethodInvokeMeta();
        methodInvokeMeta.setInterfaceClass(interfaceClass);
        methodInvokeMeta.setArgs(args);
        methodInvokeMeta.setMethodName(method.getName());
        methodInvokeMeta.setReturnType(method.getReturnType());
        Class<?>[] parameterTypes = method.getParameterTypes();
        methodInvokeMeta.setParameterTypes(parameterTypes);
        return methodInvokeMeta;
    }
}
