package entity.model;

import entity.SysRole;
import lombok.Data;
import lombok.ToString;

/**
 * @Author: ClarkRao
 * @Date: 2019/10/21 23:19
 * @Description: 扩展SysRole对象，通过此方式来接收额外的值
 *
 * 打印内容只包含子类属性，却不包含父类SysRole的属性，此处@Data修饰，此注解包含了getter，setter，tostring，
 * 所以此处的tostring如果不设置参数的话，打印string的时候只会包含子类的属性，
 * 解决：在@Data的基础上再加一个@ToString(callSuper = true)注解，callSuper = true即解决缺少父类属性的问题。
 */
@Data
@ToString(callSuper = true)
public class SysRoleExtend extends SysRole {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 邮箱
     */
    private String userEmail;
}
