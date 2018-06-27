package experiment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @description: 测试Semaphore用于流量控制（数据库连接数量的控制）
 * @author: han
 * @create: 2018-06-26 10:54
 **/
public class SemaphoreTest {
    private static final int THREAD_COUNT=30;
    private static ExecutorService threadPool= Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s=new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i <THREAD_COUNT ; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        System.out.println("save data");
                        s.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
        threadPool.shutdown();
    }
}
