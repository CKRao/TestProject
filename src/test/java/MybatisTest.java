import entity.SysRole;
import entity.SysUser;
import entity.model.SysRoleExtend;
import lombok.extern.slf4j.Slf4j;
import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import util.MybatisUtil;

import java.util.Date;
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

    @Test
    public void testInsert() {
        SqlSession sqlSession = MybatisUtil.getSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("lalala");
            user.setUserPassword("123456");
            user.setUserInfo("测试来了");
            user.setUserEmail("test@test.com");
            user.setCreateTime(new Date());
            user.setHeadImg(new byte[]{1,2,3});
            int result= userMapper.insert(user);
            Assert.assertEquals(1,result);
            Assert.assertNull(user.getId());
            log.info(user.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //为了不影响其他测试，选择回滚
            //由于默认的sqlSessionFactory.openSession()是不自动提交的
            //因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testInsert2() {
        SqlSession sqlSession = MybatisUtil.getSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("lalala");
            user.setUserPassword("123456");
            user.setUserInfo("测试来了");
            user.setUserEmail("test@test.com");
            user.setCreateTime(new Date());
            user.setHeadImg(new byte[]{1,2,3});
            int result= userMapper.insert2(user);
            Assert.assertEquals(1,result);
            Assert.assertNotNull(user.getId());
            log.info(user.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //为了不影响其他测试，选择回滚
            //由于默认的sqlSessionFactory.openSession()是不自动提交的
            //因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testInsert3() {
        SqlSession sqlSession = MybatisUtil.getSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = new SysUser();
            user.setUserName("lalala");
            user.setUserPassword("123456");
            user.setUserInfo("测试来了");
            user.setUserEmail("test@test.com");
            user.setCreateTime(new Date());
            user.setHeadImg(new byte[]{1,2,3});
            int result= userMapper.insert3(user);
            Assert.assertEquals(1,result);
            Assert.assertNotNull(user.getId());
            log.info(user.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //为了不影响其他测试，选择回滚
            //由于默认的sqlSessionFactory.openSession()是不自动提交的
            //因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testSelectByUser() {
        SqlSession sqlSession = MybatisUtil.getSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = userMapper.selectByUser("", "test@ck.top");

            Assert.assertNotNull(sysUser);
            Assert.assertEquals("test@ck.top",sysUser.getUserEmail());

            log.info(sysUser.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //为了不影响其他测试，选择回滚
            //由于默认的sqlSessionFactory.openSession()是不自动提交的
            //因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}
