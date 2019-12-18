package threadtest;

import io.netty.util.concurrent.DefaultThreadFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author : ClarkRao
 * @date : 19-4-27
 * @description : CountDownLatch 测试
 */
@Slf4j
public class CountDownLatchTest {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        DefaultThreadFactory threadFactory = new DefaultThreadFactory("CountDownLatchTest");

        ExecutorService executorService = new ThreadPoolExecutor(2, 2,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                threadFactory);

        executorService.execute(new RunTest(latch));
        executorService.execute(new RunTest(latch));
        try {
            log.info("等待两个子线程执行完毕");
            latch.await();
            log.info("两个子线程已经执行完毕");
            log.info("主线程继续执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }

    /**
     * 内部Runnable实现类
     */
    private static class RunTest implements Runnable {

        private CountDownLatch latch;

        RunTest(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                log.info("子线程"+Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                log.info("子线程"+Thread.currentThread().getName() + "执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
