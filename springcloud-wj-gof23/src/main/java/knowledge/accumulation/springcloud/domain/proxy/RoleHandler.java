package knowledge.accumulation.springcloud.domain.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RoleHandler implements InvocationHandler {

    private VisualRole visualRole;

    public RoleHandler(VisualRole visualRole){
        this.visualRole = visualRole;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(visualRole,args);
    }

    public static void main(String[] args) {
        VisualRole visualRole = new RealRole();
        InvocationHandler roleHanlder = new RoleHandler(visualRole);
        VisualRole proxy = (VisualRole)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{VisualRole.class},roleHanlder);
        proxy.bussiness();
    }
}
