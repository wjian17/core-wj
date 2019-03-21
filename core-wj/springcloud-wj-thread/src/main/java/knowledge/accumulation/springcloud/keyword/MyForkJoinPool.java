package knowledge.accumulation.springcloud.keyword;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class MyForkJoinPool extends ForkJoinPool {
    int MAX_SIZE=30000;
    int[] numbers = new int[400000];
    ForkJoinTask forkJoinTask;

    class AddTask extends RecursiveTask<Long>{

        int begin,end;

        public AddTask(int begin,int end){
            this.begin=begin;
            this.end=end;
        }
        @Override
        protected Long compute() {
            if((end-begin)<MAX_SIZE){
                long sum = 0l;
                for(int i=begin;i<end;i++){
                    sum+=numbers[i];
                }
                return sum;
            }else{
                int middle=begin+(end-begin)/2;
                AddTask task1=new AddTask(end,middle);
                AddTask task2=new AddTask(middle,end);
                task1.fork();//开启分支工作，【新启线程任务】
                task2.fork();
                return task1.join()+task2.join();//合并任务结果阻塞方法
            }
        }
    }
}

