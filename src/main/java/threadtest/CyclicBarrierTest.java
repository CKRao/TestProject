package threadtest;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : ClarkRao
 * @date : 19-4-27
 * @description : CyclicBarrier测试类
 */
@Slf4j
public class CyclicBarrierTest {
    public static final int TOTAL_THREAD = 10;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(TOTAL_THREAD);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                log.info("Thread :"+ Thread.currentThread().getName() + "before...");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                log.info("Thread :"+ Thread.currentThread().getName() + "after...");
            });
        }

        executorService.shutdown();
    }
}
