package threadtest;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * @author : ClarkRao
 * @date : 19-4-27
 * @description :  Semaphore 信号量测试
 */
@Slf4j
public class SemaphoreTest {

    public static void main(String[] args) {
        final int num = 8; //工人数
        Semaphore semaphore = new Semaphore(5);//机器数目
        for (int i = 0; i < num; i++) {
            new Woker(i,semaphore).start();
        }
    }

    static class Woker extends Thread {
        private int num;
        private Semaphore semaphore;


        public Woker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                Thread.sleep(2000);
                log.info("工人"+ this.num + "占用一个机器正在生产...");
                log.info("工人"+ this.num + "释放机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
