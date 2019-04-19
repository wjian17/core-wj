package knowledge.accumulation.springcloud.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RemoteMethodInvokeUtil implements ApplicationContextAware {

   private ApplicationContext applicationContext;

   public Object processMethod(MethodInvokeMeta methodInvokeMeta) throws InvocationTargetException, IllegalAccessException {
       Class interfaceClass = methodInvokeMeta.getInterfaceClass();
       Object bean = applicationContext.getBean(interfaceClass);
       Method[] declaredMethods = interfaceClass.getDeclaredMethods();
       Method method = null;
       for (Method declaredMethod : declaredMethods) {
           if (methodInvokeMeta.getMethodName().equals(declaredMethod.getName())) {
               method = declaredMethod;
           }
       }
       Object invoke = method.invoke(bean, methodInvokeMeta.getArgs());
       return invoke;
   }

   @Override
   public void setApplicationContext(ApplicationContext app) throws BeansException {
       applicationContext = app;
   }
}