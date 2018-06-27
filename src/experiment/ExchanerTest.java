package experiment;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 测试线程间交换数据的Exchanger
 * @author: han
 * @create: 2018-06-26 11:06
 **/
public class ExchanerTest {
    private static final Exchanger<String> exgr=new Exchanger<String>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A="银行流水A";
                    exgr.exchange(A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B="银行流水B";
                    String A=exgr.exchange("B");
                    System.out.println("A和B数据是否一致："+A.equals(B)+",A录入的是："+A+",B录入的是："+B);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.shutdown();
    }
}
