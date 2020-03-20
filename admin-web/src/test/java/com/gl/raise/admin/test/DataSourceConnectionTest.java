package com.gl.raise.admin.test;

import com.gl.raise.admin.entity.Admin;
import com.gl.raise.admin.mapper.AdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * spring与mybatis整合的测试类
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml"})
public class DataSourceConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 连接数据库测试
     */
    @Test
    public void connectionTest() throws Exception {
        Connection connection = dataSource.getConnection();
        System.err.println(connection);
    }

    /**
     * 测试自动装配mapper
     */
    @Test
    public void mapperTest() {
        /*Integer timeStamp = timeStamp();
        Admin admin = new Admin();
        admin.setAccount("1581285200");
        admin.setMobile("18296128077");
        admin.setPassword("gl18296128077");
        admin.setUsername("罪恶王冠");
        admin.setEmail("1581285200@qq.com");
        admin.setCreateTime(timeStamp);
        admin.setUpdateTime(timeStamp);

        int count = adminMapper.insertSelective(admin);
        System.out.println(count);*/

        Admin admin = adminMapper.selectByPrimaryKey(1);
        System.out.println(admin);
    }

    private Integer timeStamp() {
        String timeStampStr = String.valueOf(System.currentTimeMillis() / 1000);
        return Integer.valueOf(timeStampStr);
    }
}
