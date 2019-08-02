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
        HelloScala.sayHello("Clark Rao");
        System.out.println(HelloScala.testMe("Clark Rao"));
        log.info("-------Test End-------");
    }
}
