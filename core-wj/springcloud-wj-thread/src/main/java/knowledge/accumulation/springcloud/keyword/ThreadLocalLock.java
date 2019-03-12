package knowledge.accumulation.springcloud.keyword;

public class ThreadLocalLock {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void test(){
//        Collections.synchronizedCollection()
        threadLocal.set("111");
        threadLocal.remove();
    }
}
