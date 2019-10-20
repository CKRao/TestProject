package entity;

import lombok.Data;

/**
 * @Author: ClarkRao
 * @Date: 2019/10/20 21:49
 * @Description: 角色权限表
 */
@Data
public class SysRolePrivilege {
    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 权限ID
     */
    private Long privilegeId;
}
