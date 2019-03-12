package knowledge.accumulation.springcloud.keyword;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class ExecutorThread {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        AtomicLong count = new AtomicLong(0);
        for (int j = 0; j < 6; j++) {
//            executorService.execute(() -> {
//                for (int i = 0; i < 10000; i++) {
//                    System.out.println("【"+j+"】,thread:【" + Thread.currentThread().getName() + "】,i=" + i);
//                }
//            });
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        System.out.println(count.incrementAndGet());
                        System.out.println("thread:【" + Thread.currentThread().getName() + "】,i=" + i);
                    }
                }
            });
            executorService.shutdown();
        }
    }
}
