package com.ad.multi.db.example.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.ad.multi.db.example.repository.product",
        entityManagerFactoryRef = "productEntityManager",
        transactionManagerRef = "productTransactionManager")
public class ProductRepositoryConfig {

    @Primary
    @Bean
    @ConfigurationProperties(prefix="spring.datasource.product")
    public DataSource productDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean productEntityManager() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setDataSource(productDataSource());
        entityManagerFactoryBean.setPackagesToScan("com.ad.multi.db.example.entity.product");

        Map<String, Object> jpaProperties = Map.of("hibernate.hbm2ddl.auto","create");
        entityManagerFactoryBean.setJpaPropertyMap(jpaProperties);


        return entityManagerFactoryBean;
    }

    @Bean
    @Primary
    public PlatformTransactionManager productTransactionManager() {
        return new JpaTransactionManager(productEntityManager().getObject());
    }

}
