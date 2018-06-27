package experiment;

import java.util.concurrent.CountDownLatch;

/**
 * @description: 测试CountDownLatch
 * @author: han
 * @create: 2018-06-26 09:57
 **/
public class CountDownLatchTest {
    static CountDownLatch c=new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        c.await();
        System.out.println("3");
    }

}
