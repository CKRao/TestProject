package entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: ClarkRao
 * @Date: 2019/10/20 21:30
 * @Description: 用户表
 */
@Data
public class SysUser {

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 邮箱
     */
    private String userEmail;

    /**
     * 简介
     */
    private String userInfo;

    /**
     * 头像
     */
    private byte[] headImg;

    /**
     * 创建时间
     */
    private Date createTime;
}
