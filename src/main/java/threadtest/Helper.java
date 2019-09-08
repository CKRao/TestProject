package threadtest;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Author: ClarkRao
 * @Date: 2019/9/8 18:47
 * @Description:
 */
@Slf4j
public enum Helper {
    /**
     * 实例
     */
    instance;

    private static final int CORE_THREADS = 2;

    private static final ThreadFactory THREAD_FACTORY = new ThreadFactoryBuilder().setNameFormat("Helper-runner-%d").build();

    private static final ExecutorService SERVICE = new ThreadPoolExecutor(CORE_THREADS, CORE_THREADS,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(), THREAD_FACTORY);

    /**
     * 数字数组
     *
     * @param max
     * @return
     */
    public static String[] buildNoArr(int max) {
        String[] noArr = new String[max];
        for (int i = 0; i < max; i++) {
            noArr[i] = Integer.toString(i + 1);
        }
        return noArr;
    }

    /**
     * 字母数组
     *
     * @param max
     * @return
     */
    public static String[] buildCharArr(int max) {
        String[] charArr = new String[max];
        int tmp = 65;
        for (int i = 0; i < max; i++) {
            charArr[i] = String.valueOf((char) (tmp + i));
        }
        return charArr;
    }

    /**
     * 打印方法
     *
     * @param input
     */
    public static void print(String... input) {
        if (input == null) {
            return;
        }
        for (String each : input) {
            System.out.print(each);
        }
    }

    /**
     * 启动线程的方法
     *
     * @param runnable
     */
    public void run(Runnable runnable) {
        SERVICE.submit(runnable);
    }

    /**
     * 关闭线程池
     */
    public void shutdown() {
        SERVICE.shutdown();
    }
}
