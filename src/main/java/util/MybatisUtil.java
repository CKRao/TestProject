package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.Objects;

/**
 * @Author: ClarkRao
 * @Date: 2019/10/21 22:54
 * @Description:
 */
public class MybatisUtil {

    private volatile static SqlSessionFactory sqlSessionFactory;

    private MybatisUtil() {}

    public static SqlSessionFactory getSqlSessionFactory() {
        if (Objects.isNull(sqlSessionFactory)) {
            synchronized (MybatisUtil.class) {
                if (Objects.isNull(sqlSessionFactory)) {
                    try {
                        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
                        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
                        reader.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return sqlSessionFactory;
    }

    /**
     * 获取会话
     * @return
     */
    public static SqlSession getSession() {
        return getSqlSessionFactory().openSession();
    }
}
