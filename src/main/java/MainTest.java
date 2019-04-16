import lombok.extern.slf4j.Slf4j;
import mystruct.array.Array;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/14 16:30
 * @Description: 主要测试主程序
 */
@Slf4j
public class MainTest {
    public static void main(String[] args) {
       log.info("-------Test Start-------");
        Array arr = new Array(20);

        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }

        log.info(arr.toString());

        log.info("-----add-----");

        arr.add(1,100);
        arr.addFirst(-1);
        log.info(arr.toString());

        arr.set(0, 666);
        log.info(arr.toString());
    }
}
