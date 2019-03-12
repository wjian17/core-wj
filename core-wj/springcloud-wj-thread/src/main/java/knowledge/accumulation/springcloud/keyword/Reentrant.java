package knowledge.accumulation.springcloud.keyword;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Reentrant {

    Lock lock = new ReentrantLock();

    boolean isLocked = false;

    void m1() throws Exception{
        try {
            lock.lock();
            isLocked = lock.tryLock();//尝试锁机制
            isLocked = lock.tryLock(10, TimeUnit.SECONDS);
            lock.lockInterruptibly();//尝试打断
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
            if(isLocked){
                lock.unlock();
            }
        }
    }

    private static ReentrantLock static_lock = new ReentrantLock(true);//定义公平锁，公平分配cpu资源，sync非公平锁

}
