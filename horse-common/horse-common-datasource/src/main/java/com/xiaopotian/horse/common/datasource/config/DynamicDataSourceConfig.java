package com.xiaopotian.horse.common.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.xiaopotian.horse.common.datasource.support.DataSourceConstants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeConstants;
import java.sql.Driver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * ==========================================
 * 动态数据源切换配置
 *
 * @author : 小破天
 * @date : 2019/7/4 17:13
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@Slf4j
@Configuration
@AllArgsConstructor
public class DynamicDataSourceConfig implements TransactionManagementConfigurer {
    private final Map<Object, Object> dataSourceMap = new HashMap<>(20);
    private final DruidDataSourceProperties dataSourceProperties;
    private final StringEncryptor stringEncryptor;

    @Bean("dynamicDataSource")
    public DynamicDataSource dataSource() {
        DynamicDataSource ds = new DynamicDataSource();
        DruidDataSource dds = new DruidDataSource();
        dds.setUrl(dataSourceProperties.getUrl());
        dds.setDriverClassName(dataSourceProperties.getDriverClassName());
        dds.setUsername(dataSourceProperties.getUsername());
        dds.setPassword(dataSourceProperties.getPassword());
        ds.setDefaultTargetDataSource(dds);
        dataSourceMap.put(0, dds);
        ds.setTargetDataSources(dataSourceMap);

        return ds;
    }

    /**
     * 组装默认配置的数据源，查询数据库配置
     */
    @PostConstruct
    public void init() {
        dataSourceMap.clear();

        DriverManagerDataSource dds = new DriverManagerDataSource();
        dds.setUrl((dataSourceProperties.getUrl()));
        dds.setDriverClassName(dataSourceProperties.getDriverClassName());
        dds.setUsername(dataSourceProperties.getUsername());
        dds.setPassword(dataSourceProperties.getPassword());

        List<Map<String, Object>> dbList = new JdbcTemplate(dds).queryForList(DataSourceConstants.QUERY_DS_SQL);
        log.info("开始 -> 初始化数据源");
        Optional.of(dbList).ifPresent(list -> list.forEach(db -> {
            log.info("数据源:{}", db.get(DataSourceConstants.DS_NAME));
            DruidDataSource ds = new DruidDataSource();
            ds.setUrl(String.valueOf(db.get(DataSourceConstants.DS_JDBC_URL)));
            ds.setDriverClassName(Driver.class.getName());
            ds.setUsername(String.valueOf(db.get(DataSourceConstants.DS_USER_NAME)));

            String decPwd = stringEncryptor.decrypt(String.valueOf(db.get(DataSourceConstants.DS_USER_PWD)));
            ds.setPassword(decPwd);

            dataSourceMap.put(db.get(DataSourceConstants.DS_ROUTE_KEY), ds);
        }));

        log.info("结束 ->初始化动态数据源，共计 {} 条", dataSourceMap.size());
    }

    /**
     * 重新加载数据源配置
     *
     * @return
     */
    public Boolean reload() {
        init();
        DynamicDataSource dataSource = dataSource();
        dataSource.setTargetDataSources(dataSourceMap);
        dataSource.afterPropertiesSet();
        return Boolean.FALSE;
    }

    /**
     * 管理动态数据源的事务
     *
     * @return PlatformTransactionManager
     */
    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    /**
     * 管理动态数据源的事务
     *
     * @return PlatformTransactionManager
     */
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return txManager();
    }
}
