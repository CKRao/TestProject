package threadtest;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 唤醒线程测试
 */
@Slf4j
public class AwaitSignalTest {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void before() {
        lock.lock();
        try{
            log.info("before");
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void after() {
        lock.lock();
        try {
            condition.await();
            log.info("after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AwaitSignalTest awaitSignalTest = new AwaitSignalTest();

        //先调用after方法，再调用before方法
        executorService.execute(() -> awaitSignalTest.after());
        executorService.execute(() -> awaitSignalTest.before());

        /**
         * Result:
         *      before
         *      after
         */
    }
}
