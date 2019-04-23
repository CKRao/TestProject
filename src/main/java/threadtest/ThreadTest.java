package threadtest;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程测试类
 */
@Slf4j
public class ThreadTest {

    /**
     * 固定线程池的数量
     */
    private static final int THREAD_SIZE = 3;

    public static void main(String[] args) {
        //测试缓存线程池
        cachedThreadPoolTest();
        //测试固定数量线程池
        fixedThreadPoolTest();
        //测试单个数量的线程池
        singleThreadExecutorTest();
    }

    /**
     * CachedThreadPool 一个任务创建一个线程
     * 可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
     */
    private static void cachedThreadPoolTest() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            cachedThreadPool.execute(() ->
                    log.info("CachedThreadPool->Thread Now: "
                            + Thread.currentThread().getName()));
        }

        cachedThreadPool.shutdown();
    }

    /**
     * FixedThreadPool 所有任务只能使用固定大小的线程；
     */
    private static void fixedThreadPoolTest() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(THREAD_SIZE);
        final int length = THREAD_SIZE * 2;

        for (int i = 0; i < length; i++) {
            fixedThreadPool.execute(() ->
                    log.info("FixedThreadPool->Thread Now: "
                            + Thread.currentThread().getName()));
        }

        fixedThreadPool.shutdown();
    }

    /**
     * SingleThreadExecutor 相当于大小为 1 的 FixedThreadPool
     */
    private static void singleThreadExecutorTest() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < THREAD_SIZE; i++) {
            singleThreadExecutor.execute(() ->
                    log.info("SingleThreadExecutor->Thread Now: "
                            + Thread.currentThread().getName()));
        }
        singleThreadExecutor.shutdown();
    }
}
