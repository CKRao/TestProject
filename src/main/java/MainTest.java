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
        arr.addLast(666);
        arr.addLast(666);
        arr.addLast(666);
        arr.addLast(9);
        arr.addFirst(9);
        log.info(arr.toString());

        log.info(arr.findAll(666).toString());

        log.info("remove all element = 9");

        arr.removeAllElements(9);
        log.info(arr.findAll(9).toString());
        log.info(arr.toString());
//
//        log.info("-----remove Start-----");
//
//        log.info("-----remove index = 3 element-----");
//        arr.remove(3);
//        log.info(arr.toString());
//        log.info("-----remove first element-----");
//        arr.removeFirst();
//        log.info(arr.toString());
//
//        log.info("-----remove last element-----");
//        arr.removeLast();
//        log.info(arr.toString());
//
//        log.info("-----remove element = 8-----");
//        arr.removeElement(8);
//        log.info(arr.toString());
//
//


        log.info("-------Test End-------");
    }
}
