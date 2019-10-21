package entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: ClarkRao
 * @Date: 2019/10/20 21:38
 * @Description: 角色表
 */
@Data
public class SysRole {
    /**
     * 角色ID
     */
    private Long id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 有效标记
     */
    private String enabled;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * SysUser用户对象，查询时可用来接收用户信息额外的值
     */
    private SysUser user;
}
