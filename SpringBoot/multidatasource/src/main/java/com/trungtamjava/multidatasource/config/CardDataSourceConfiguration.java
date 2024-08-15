package com.trungtamjava.multidatasource.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.trungtamjava.multidatasource.repository.card", 
	entityManagerFactoryRef = "cardEntityManagerFactory", 
	transactionManagerRef = "cardTransactionManager")
public class CardDataSourceConfiguration {
	@Bean
	@ConfigurationProperties("app.datasource.card")
	public DataSourceProperties cardDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	public DataSource cardDataSource() {
		return cardDataSourceProperties().initializeDataSourceBuilder().type(DriverManagerDataSource.class).build();
	}

	@Bean(name = "cardEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean cardEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(cardDataSource()).packages("com.trungtamjava.multidatasource.model.card").build();
	}

	@Bean(name = "cardTransactionManager")
	public PlatformTransactionManager cardTransactionManager(
			final @Qualifier("cardEntityManagerFactory") LocalContainerEntityManagerFactoryBean cardEntityManagerFactory) {
		return new JpaTransactionManager(cardEntityManagerFactory.getObject());
	}
}
