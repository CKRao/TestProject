package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: ClarkRao
 * @Date: 2019/6/4 22:33
 * @Description:
 */

@Data
@Builder(toBuilder = true)
public class Product {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 分类id
     */
    private String categoryId;

    /**
     * 创建时间
     */
    private Date createTime;
}
