package entity;

import lombok.Data;

/**
 * @Author: ClarkRao
 * @Date: 2019/10/20 21:35
 * @Description: 用户角色关联表
 */
@Data
public class SysUserRole {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;

}
