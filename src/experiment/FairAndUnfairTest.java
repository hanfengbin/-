package experiment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
* 测试公平锁和非公平锁
* */
public class FairAndUnfairTest {
    private static class ReentrantLock2 extends ReentrantLock{
        public ReentrantLock2(boolean fair) {
            super(fair);
        }
        public Collection<Thread> getQueuedThreads(){
            List<Thread> arrayList=new ArrayList<Thread>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }
    private static class Job extends Thread{
        private Lock lock;
        public Job(Lock lock){
            this.lock=lock;
        }

        @Override
        public void run() {

        }
    }
    private static Lock fairLock=new ReentrantLock2(true);
    private static Lock unfairLock=new ReentrantLock2(false);

    private static void testLock(Lock lock){

    }

    public static void main(String[] args) {
        testLock(fairLock);
        testLock(unfairLock);
    }

}
