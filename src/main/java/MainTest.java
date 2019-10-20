import entity.Country;
import entity.SysUser;
import junit.framework.Assert;
import lombok.extern.slf4j.Slf4j;
import mapper.CountryMapper;
import mapper.UserMapper;
import mystruct.array.Array;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/14 16:30
 * @Description: 主要测试主程序
 */
@Slf4j
public class MainTest {
    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) {
        log.info("-------Test Start-------");
        try(Reader reader = Resources.getResourceAsReader("mybatis-config.xml")) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            //在mybatis-config.xml 配置了事务管理器，则需要在开启会话的时候设置自动提交
            //如果使用了无参构造器，则需要在插入和更新操作后，手动sqlSession.commit()
            SqlSession sqlSession = sqlSessionFactory.openSession(true);

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            //查找id为1的用户
            SysUser sysUser = userMapper.selectById(1L);

            log.info("sysUser ： {}",sysUser);

            //查找所有的用户
            List<SysUser> sysUsers = userMapper.selectAll();

            sysUsers.forEach(System.out::println);

            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("-------Test End-------");
    }
}
