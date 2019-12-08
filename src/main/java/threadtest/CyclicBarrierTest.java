package threadtest;

import io.netty.util.concurrent.DefaultThreadFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author : ClarkRao
 * @date : 19-4-27
 * @description : CyclicBarrier测试类
 */
@Slf4j
public class CyclicBarrierTest {
    private static final int TOTAL_THREAD = 10;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(TOTAL_THREAD);
        DefaultThreadFactory threadFactory = new DefaultThreadFactory("CyclicBarrierTest");

        ExecutorService executorService = new ThreadPoolExecutor(10, 10,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                threadFactory);

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                log.info("Thread :"+ Thread.currentThread().getName() + "before...");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                log.info("Thread :"+ Thread.currentThread().getName() + "after...");
            });
        }

        executorService.shutdown();
    }
}
