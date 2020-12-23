package com.seata.consul.order.common;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author code-generator
 * @date 2020-12-14 15:47:05
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.seata.consul.*.*.mapper")
public class MybatisPlusConfig {

    //
    //
    // /**
    //  * @param sqlSessionFactory SqlSessionFactory
    //  * @return SqlSessionTemplate
    //  */
    // @Bean
    // public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
    //     return new SqlSessionTemplate(sqlSessionFactory);
    // }
    //
    // /**
    //  * 从配置文件获取属性构造datasource，注意前缀，这里用的是druid，根据自己情况配置,
    //  * 原生datasource前缀取"spring.datasource"
    //  *
    //  * @return
    //  */
    // @Bean
    // @ConfigurationProperties(prefix = "spring.datasource.druid")
    // public DataSource druidDataSource() {
    //     DruidDataSource druidDataSource = new DruidDataSource();
    //     return druidDataSource;
    // }
    //
    // /**
    //  * 构造datasource代理对象，替换原来的datasource
    //  * @param druidDataSource
    //  * @return
    //  */
    // @Primary
    // @Bean("dataSource")
    // public DataSourceProxy dataSourceProxy(DataSource druidDataSource) {
    //     return new DataSourceProxy(druidDataSource);
    // }
    //
    // @Bean(name = "sqlSessionFactory")
    // public SqlSessionFactory sqlSessionFactoryBean(DataSourceProxy dataSourceProxy) throws Exception {
    //     MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
    //     bean.setDataSource(dataSourceProxy);
    //     ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    //     // bean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
    //     bean.setMapperLocations(resolver.getResources("classpath*:mybatis/**/*-mapper.xml"));
    //
    //     SqlSessionFactory factory = null;
    //     try {
    //         factory = bean.getObject();
    //     } catch (Exception e) {
    //         throw new RuntimeException(e);
    //     }
    //     return factory;
    // }



    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
