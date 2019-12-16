import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @Author: ClarkRao
 * @Date: 2019/12/16 22:45
 * @Description:
 */
@Slf4j
public class OtherTest {

    @Test
    public void testOne() {
        List<String> strings = new ArrayList<String>() {
            {
                add("1");
                add("2");
                add("4");
                add("6");
                add("8");
                add("8");
                add("8");
            }
        };

        List<Double> doubleList = strings.stream().mapToDouble(str -> {
            log.info("mapToDouble {}", str);
            return Double.parseDouble(str);
        }).filter(item -> {
            log.info("filter {}", item);
            if (item > 4) {
                return true;
            }
            return false;
        }).mapToObj(Double::new).collect(toList());


    }
}
