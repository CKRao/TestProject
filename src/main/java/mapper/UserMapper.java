package mapper;

import entity.SysRole;
import entity.SysUser;
import entity.model.SysRoleExtend;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 根据UserId查找角色
     * @param userId
     * @return
     */
    List<SysRole> selectRolesByUserId(Long userId);


    /**
     * 根据UserId查找角色
     * 通过SysRoleExtend扩展角色对象，增加用户名和用户邮箱的值得接收
     * @param userId
     * @return
     */
    List<SysRoleExtend> selectRolesByUserId2(Long userId);

    /**
     * 根据UserId查找角色 SysRole中增加SysUser作为属性，以此来接收额外的用户信息返回值
     * @param userId
     * @return
     */
    List<SysRole> selectRolesByUserId3(Long userId);

    /**
     * 插入数据
     * @param user
     * @return
     */
    int insert(SysUser user);

    /**
     * 插入数据
     * @param user
     * @return
     */
    int insert2(SysUser user);

    /**
     * 插入数据 使用selectKey方式
     * @param user
     * @return
     */
    int insert3(SysUser user);

    /**
     * 更新数据
     * @param user
     * @return
     */
    int updateById(SysUser user);

    /**
     * 根据id删除记录
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 根据用户信息查找
     * @param userName
     * @param userEmail
     * @return
     */
    SysUser selectByUser(@Param("userName") String userName, @Param("userEmail") String userEmail);
}
