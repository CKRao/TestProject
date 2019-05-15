package threadtest;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Author: ClarkRao
 * @Date: 2019/5/12 20:37
 * @Description:  FutureTask测试
 */
@Slf4j
public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
            int result = 0;
            for (int i = 0; i < 100; i++) {
                Thread.sleep(10);
                result += i;
            }
            return result;
        });



        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                2,
                TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(1024),
                r -> {
                    Thread thread = new Thread(r);
                    thread.setName("my-Thread");
                    return thread;
                });
        threadPoolExecutor.submit(futureTask);
        threadPoolExecutor.execute(() -> log.info("other thread task"));
        log.info(futureTask.get().toString());
    }
}
