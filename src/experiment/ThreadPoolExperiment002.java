package experiment;

import java.util.concurrent.*;

public class ThreadPoolExperiment002 {
    public static void main(String[] args) {
       // ExecutorService executor=Executors.newFixedThreadPool(10);
        ThreadPoolExecutor executor1=new ThreadPoolExecutor(5,10,200,TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));

        for(int i=0;i<15;i++){
            ThreadPoolExperiment.Mytask mytask=new ThreadPoolExperiment.Mytask(i);
            executor1.execute(mytask);
            //System.out.println("线程池中的线程数目"+executor.getPoolSize()+",队列中等待执行的任务数目："+executor.getQueue().size()+"已执行完的线程数目"+executor.getCompletedTaskCount());
            //executor.shutdown();
        }
        System.out.println(executor1);
        executor1.shutdown();
        System.out.println(executor1.isTerminated());
        System.out.println(executor1.isShutdown());
        System.out.println(executor1);
    }
}
