package threadtest;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Author: ClarkRao
 * @Date: 2019/5/15 22:21
 * @Description: ForkJoin测试
 */
@Slf4j
public class ForkJoinExample extends RecursiveTask<Integer> {
    private int first;
    private int last;

    public ForkJoinExample(int first, int last) {
        this.first = first;
        this.last = last;
    }

    @Override
    protected Integer compute() {
        int result = 0;
        int threshold = 5;
        if ((last - first) <= threshold) {
            //任务量足够小则直接计算
            for (int i = first; i <= last; i++) {
                result += i;
            }
        } else {
            //拆分成小任务
            int middle = first + (last - first) / 2;
            ForkJoinExample leftTask = new ForkJoinExample(first, middle);
            ForkJoinExample rightTask = new ForkJoinExample(middle + 1, last);

            leftTask.fork();
            rightTask.fork();
            //合并结果
            result = leftTask.join() + rightTask.join();
        }
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinExample forkJoinExample = new ForkJoinExample(1, 1000000);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> result = forkJoinPool.submit(forkJoinExample);

        log.info("result -> " + result.get());
    }
}
