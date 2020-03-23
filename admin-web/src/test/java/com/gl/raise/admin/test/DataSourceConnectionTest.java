package com.gl.raise.admin.test;

import com.gl.raise.admin.entity.Admin;
import com.gl.raise.admin.mapper.AdminMapper;
import com.gl.raise.admin.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * spring与mybatis整合的测试类
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml", "classpath:spring-persist-tx.xml"})
public class DataSourceConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    /**
     * 获取日志
     */
    private Logger logger = LoggerFactory.getLogger(DataSourceConnectionTest.class);


    /**
     * 连接数据库测试
     */
    @Test
    public void connectionTest() throws Exception {
        Connection connection = dataSource.getConnection();
        logger.info("连接信息: {}", connection.toString());
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

    /**
     * 测试是否配置好事务
     */
    @Test
    public void txTest() {
        Admin admin = createDefaultAdmin();
        adminService.saveAdmin(admin);

    }

    /**
     * 获取秒级时间戳
     * @return
     */
    private Integer timeStamp() {
        String timeStampStr = String.valueOf(System.currentTimeMillis() / 1000);
        return Integer.valueOf(timeStampStr);
    }

    /**
     * 创建默认的admin信息, 主要用于测试
     * @return
     */
    private Admin createDefaultAdmin() {
        Integer timeStamp = timeStamp();
        Admin admin = new Admin();
        admin.setAccount("1581285200");
        admin.setMobile("18296128077");
        admin.setPassword("gl18296128077");
        admin.setUsername("罪恶王冠");
        admin.setEmail("1581285200@qq.com");
        admin.setCreateTime(timeStamp);
        admin.setUpdateTime(timeStamp);

        return admin;
    }
}
