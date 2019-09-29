package knowledge.accumulation.springcloud.keyword;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueConcurrent {


    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        concurrentLinkedQueue.peek();
        concurrentLinkedQueue.poll();
        concurrentLinkedQueue.offer("");

        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
        //<editor-fold desc="Description">
        try {
            blockingQueue.put("");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //</editor-fold>
    }
}
