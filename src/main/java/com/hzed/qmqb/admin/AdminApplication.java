package com.hzed.qmqb.admin;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author wuchengwu
 */

@Slf4j
@ServletComponentScan
@MapperScan(value = {"com.hzed.qmqb.admin.persistence.auto.mapper"})
@SpringBootApplication
public class AdminApplication {

    public static void main(String[] args) {

        SpringApplication.run(AdminApplication.class, args);
        log.info("==========恭喜大佬，贺喜大佬，项目启动成功！==========");
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new com.alibaba.druid.pool.DruidDataSource();
    }

    /**
     * 指定xml资源文件
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] gatewayRes = resolver.getResources("classpath*:com/hzed/qmqb/admin/persistence/**/*.xml");
        sqlSessionFactoryBean.setMapperLocations(gatewayRes);
     //   sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:/config/spring-mybatis.xml"));
        return sqlSessionFactoryBean.getObject();
    }
}
