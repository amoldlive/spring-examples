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
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setDataSource(productDataSource());
        em.setPackagesToScan(
                new String[] { "com.ad.multi.db.example.entity.product"});


        Map<String, Object> properties = Map.of("hibernate.hbm2ddl.auto","update");
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    @Primary
    public PlatformTransactionManager productTransactionManager() {
        return new JpaTransactionManager(productEntityManager().getObject());
    }

}
