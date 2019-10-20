package mapper;

import entity.Country;

/**
 * @Author: ClarkRao
 * @Date: 2019/10/20 19:11
 * @Description:
 */
public interface CountryMapper {
    /**
     * 根据ID查找
     * @param id
     * @return
     */
    Country selectOne(Long id);

    /**
     * 插入实体
     * @param country
     * @return
     */
    int insertOne(Country country);
}
