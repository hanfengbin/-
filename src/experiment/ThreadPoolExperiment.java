package experiment;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.xml.bind.SchemaOutputResolver;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExperiment {
    public static void main(String[] args) {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(5,10,200, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));
        for(int i=0;i<15;i++){
            Mytask mytask=new Mytask(i);
            executor.execute(mytask);
            System.out.println("线程池中的线程数目"+executor.getPoolSize()+",队列中等待执行的任务数目："+executor.getQueue().size()+"已执行完的线程数目"+executor.getCompletedTaskCount());
            executor.shutdown();
        }
    }
    static class Mytask implements Runnable{
        private int taskNum;

        public Mytask(int taskNum) {
            this.taskNum = taskNum;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
