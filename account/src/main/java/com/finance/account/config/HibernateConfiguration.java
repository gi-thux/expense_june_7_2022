package com.finance.account.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
    @Value("com.mysql.cj.jdbc.Driver")
    private  String DRIVER;
    @Value("jdbc:mysql://localhost:3306/account")
    private  String DB_URL;
    @Value("root")
    private  String DB_USERNAME;
    @Value("root")
    private  String DB_PASSWORD;
    @Value("org.hibernate.dialect.MySQL5Dialect")
    private String HIBERNATE_DIALECT;
    @Value("create")
    private String HBM2DDL;
    @Value("true")
    private  String SHOW_SQL;
    @Value("com.finance.account.model")
    private String PACKAGE_TO_SCAN;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
      factoryBean.setPackagesToScan(PACKAGE_TO_SCAN);
        Properties prop = new Properties();
        prop.put("hibernate.dialect", HIBERNATE_DIALECT);
        prop.put("hibernate.hbm2ddl.auto",HBM2DDL);
        prop.put("hibernate.show_sql", SHOW_SQL);
        factoryBean.setHibernateProperties(prop);
        return factoryBean;

    }

@Bean
    public TransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
   return transactionManager;
    }

}
