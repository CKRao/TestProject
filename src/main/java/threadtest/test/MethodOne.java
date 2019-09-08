package threadtest.test;

import lombok.extern.slf4j.Slf4j;
import threadtest.Helper;

/**
 * @Author: ClarkRao
 * @Date: 2019/9/8 19:12
 * @Description: 编写两个线程，一个线程打印1~25，另一个线程打印字母A~Z，打印顺序为12A34B56C……5152Z，要求使用线程间的通信。
 */
@Slf4j
public class MethodOne {

    private final ThreadToGo threadToGo;

    public MethodOne() {
        this.threadToGo = new ThreadToGo();
    }

    /**
     * 打印数字的线程
     *
     * @return
     */
    public Runnable newThreadOne() {
        final String[] inputArr = Helper.buildNoArr(52);
        return new Runnable() {
            private String[] arr = inputArr;

            @Override
            public void run() {
                try {
                    for (int i = 0; i < arr.length; i += 2) {
                        synchronized (threadToGo) {
                            while (threadToGo.value == 2) {
                                threadToGo.wait();
                            }
                            Helper.print(arr[i], arr[i + 1]);
                            threadToGo.value = 2;
                            threadToGo.notify();
                        }
                    }
                } catch (InterruptedException e) {
                    log.error("newThreadOne InterruptedException {}",e.getMessage());
                    e.printStackTrace();
                }
            }
        };
    }

    /**
     * 打印字母的线程
     *
     * @return
     */
    public Runnable newThreadTwo() {
        final String[] inputArr = Helper.buildCharArr(26);
        return new Runnable() {
            private String[] arr = inputArr;

            @Override
            public void run() {
                try {
                    for (int i = 0; i < arr.length; i++) {
                        synchronized (threadToGo) {
                            while (threadToGo.value == 1) {
                                threadToGo.wait();
                            }
                            Helper.print(arr[i]);
                            threadToGo.value = 1;
                            threadToGo.notify();
                        }
                    }
                } catch (InterruptedException e) {
                    log.error("newThreadTwo InterruptedException {}",e.getMessage());
                    e.printStackTrace();
                }
            }
        };
    }

    class ThreadToGo {
        int value = 1;
    }

    public static void main(String[] args) {
        MethodOne methodOne = new MethodOne();
        Helper.instance.run(methodOne.newThreadOne());
        Helper.instance.run(methodOne.newThreadTwo());
        Helper.instance.shutdown();
    }
}
