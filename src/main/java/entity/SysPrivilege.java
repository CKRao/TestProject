package entity;

import lombok.Data;

/**
 * @Author: ClarkRao
 * @Date: 2019/10/20 21:46
 * @Description: 权限表
 */
@Data
public class SysPrivilege {

    /**
     * 权限ID
     */
    private Long id;

    /**
     * 权限名称
     */
    private String privilegeName;

    /**
     * 权限url
     */
    private String privilegeUrl;
}
