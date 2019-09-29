package knowledge.accumulation.springcloud.keyword;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * synchronized
 * 锁对象： this 和 方法 锁当前对象【SynchronizedLock的实例对象】
 * 静态方法中加synchronized 对当前类的Class加锁
 */
public class SynchronizedLock {

    AtomicInteger atomicInteger = new AtomicInteger(0);

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    private int count = 0;

    private Object o = new Object();

    private static int staticCount = 0;

    public static synchronized void testSync4(){
        System.out.println(Thread.currentThread().getName()+"count="+staticCount++);
    }

    public static void testSync5(){
        synchronized (SynchronizedLock.class){
            System.out.println(Thread.currentThread().getName()+"count="+staticCount++);
        }
    }

    public void testSync1(){
        synchronized (o){
            System.out.println(Thread.currentThread().getName()+"count="+count++);
        }
    }

    public void testSync2(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+"count="+count++);
        }
    }

    public synchronized void testSync3(){
            System.out.println(Thread.currentThread().getName()+"count="+count++);
    }

}
