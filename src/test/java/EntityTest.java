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

        log.info(product.toString());
    }
}
