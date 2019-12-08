package threadtest;

import io.netty.util.concurrent.DefaultThreadFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ClarkRao
 * @Date: 2019/12/8 16:09
 * @Description:
 */
@Slf4j
public class ThreadLocalTest {

    ThreadLocal<String> name = new ThreadLocal<>();

    public static void main(String[] args) {
        DefaultThreadFactory threadFactory = new DefaultThreadFactory("ThreadLocalTest");

        ExecutorService executorService = new ThreadPoolExecutor(2, 2,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                threadFactory);
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();

        executorService.execute(() -> {
            threadLocalTest.setName("11111");
            try {
                Thread.sleep(1000);
                log.info(Thread.currentThread().getName()+ " : " + threadLocalTest.getName().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                threadLocalTest.getName().remove();
            }
        });

        executorService.execute(() -> {
            threadLocalTest.setName("2222");
            try {
                Thread.sleep(1000);
                log.info(Thread.currentThread().getName()+ " : " + threadLocalTest.getName().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                threadLocalTest.getName().remove();
            }
        });
    }

    public ThreadLocal<String> getName() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
