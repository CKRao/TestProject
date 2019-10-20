import entity.Country;
import junit.framework.Assert;
import lombok.extern.slf4j.Slf4j;
import mapper.CountryMapper;
import mystruct.array.Array;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

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

            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            Country country = new Country();
            country.setCountryName("China");
            country.setCountryCode("CN");

            CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
            int i = countryMapper.insertOne(country);
//            sqlSession.commit();
            Assert.assertEquals(1,i);

            System.out.println(countryMapper.selectOne(2L));
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("-------Test End-------");
    }
}
