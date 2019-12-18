import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
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

        String collectStr = strings.stream()
                .mapToDouble(Double::parseDouble)
                .filter(item -> item > 4)
                .boxed()
                .map(String::valueOf)
                .collect(joining(", "));

        log.info("collectStr is {}", collectStr);
    }
}
