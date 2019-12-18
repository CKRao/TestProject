import entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;

/**
 * @Author: ClarkRao
 * @Date: 2019/12/19 0:06
 * @Description:
 */
@Slf4j
public class EntityTest {

    @Test
    public void testProduct() {
        Product product = Product.builder()
                .name("product")
                .createTime(new Date())
                .categoryId("1")
                .build();

        log.info("1. {}",product.toString());

        log.info("after toBuilder");

        product = product.toBuilder()
                .id(1L)
                .name("product change")
                .build();

        log.info("2. {}",product.toString());
    }
}
