import entity.SysRole;
import entity.model.SysRoleExtend;
import lombok.extern.slf4j.Slf4j;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import util.MybatisUtil;

import java.util.List;

/**
 * @Author: ClarkRao
 * @Date: 2019/10/21 22:38
 * @Description:
 */

@Slf4j
public class MybatisTest {

    @Test
    public void testSelectRolesByUserId() {
        SqlSession sqlSession = MybatisUtil.getSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> sysRoles = userMapper.selectRolesByUserId(1L);
            //结果不为空
            Assert.assertNotNull(sysRoles);
            //角色数量大于0
            Assert.assertTrue(sysRoles.size() > 0);
            //打印角色列表
            sysRoles.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserId2() {
        SqlSession sqlSession = MybatisUtil.getSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRoleExtend> sysRoleExtends = userMapper.selectRolesByUserId2(1L);
            //结果不为空
            Assert.assertNotNull(sysRoleExtends);
            //角色数量大于0
            Assert.assertTrue(sysRoleExtends.size() > 0);
            //打印角色列表
            sysRoleExtends.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserId3() {
        SqlSession sqlSession = MybatisUtil.getSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> sysRoles = userMapper.selectRolesByUserId3(1L);
            //结果不为空
            Assert.assertNotNull(sysRoles);
            //角色数量大于0
            Assert.assertTrue(sysRoles.size() > 0);
            //打印角色列表
            sysRoles.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
