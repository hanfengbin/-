package experiment;

import java.util.concurrent.locks.Lock;

public class TwinsLockTest {
    public static void main(String[] args) throws InterruptedException {
        final Lock lock=new TwinsLock();
        class Worker extends Thread{
            @Override
            public void run() {
                while(true){
                    lock.lock();
                    try{
                        sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        sleep(1000);
                        lock.unlock();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        for (int i = 0; i <10 ; i++) {
            Worker w=new Worker();
            w.setDaemon(true);
            w.start();
        }
        for (int i = 0; i <10 ; i++) {
            Thread.sleep(1000);
            System.out.println();
        }
    }
    
}
