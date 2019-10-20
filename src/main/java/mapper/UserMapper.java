package mapper;

import entity.SysUser;

import java.util.List;

/**
 * @Author: ClarkRao
 * @Date: 2019/10/20 23:07
 * @Description:
 */
public interface UserMapper {

    /**
     * 通过ID查询用户
     * @param id
     * @return
     */
    SysUser selectById(Long id);

    /**
     * 查找所有的用户
     * @return
     */
    List<SysUser> selectAll();
}
