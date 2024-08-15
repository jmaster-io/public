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

import com.trungtamjava.multidatasource.model.cardholder.CardHolder;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.trungtamjava.multidatasource.repository.cardholder", entityManagerFactoryRef = "cardHolderEntityManagerFactory", transactionManagerRef = "cardHolderTransactionManager")
public class CardHolderDataSourceConfiguration {

	@Bean
	@ConfigurationProperties("app.datasource.cardholder")
	public DataSourceProperties cardHolderDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	public DataSource cardholderDataSource() {
		return cardHolderDataSourceProperties().initializeDataSourceBuilder().type(DriverManagerDataSource.class).build();
	}

	@Bean(name = "cardHolderEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean cardHolderEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(cardholderDataSource()).packages(CardHolder.class).build();
	}

	@Bean(name = "cardHolderTransactionManager")
	public PlatformTransactionManager cardHolderTransactionManager(
			final @Qualifier("cardHolderEntityManagerFactory") LocalContainerEntityManagerFactoryBean cardHolderEntityManagerFactory) {
		return new JpaTransactionManager(cardHolderEntityManagerFactory.getObject());
	}
}