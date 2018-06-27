package experiment;

import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:ConditionUseCase
 * @author: han
 * @create:2018-06-25 14:44
 **/
public class ConditionUseCase {
    Lock lock=new ReentrantLock();
    Condition condition=lock.newCondition();

    public void conditionWait() throws InterruptedException {
        lock.lock();
        try{
            condition.await();
        }finally {
            lock.unlock();
        }
    }

    public void conditionSignal(){
        lock.lock();
        try{
            condition.signal();
        }finally {
            lock.unlock();
        }
    }

}
