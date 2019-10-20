package entity;

import lombok.Data;

/**
 * @Author: ClarkRao
 * @Date: 2019/10/20 19:03
 * @Description:
 */
@Data
public class Country {
    private Long id;

    private String countryName;

    private String countryCode;
}
