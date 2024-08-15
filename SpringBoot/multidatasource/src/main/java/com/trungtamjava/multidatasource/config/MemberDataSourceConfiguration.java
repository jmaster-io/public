package com.trungtamjava.multidatasource.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.trungtamjava.multidatasource.model.member.Member;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.trungtamjava.multidatasource.repository.member", entityManagerFactoryRef = "memberEntityManagerFactory", transactionManagerRef = "memberTransactionManager")
public class MemberDataSourceConfiguration {

	@Bean
	@Primary
	@ConfigurationProperties("app.datasource.member")
	public DataSourceProperties memberDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	public DataSource memberDataSource() {
		return memberDataSourceProperties().initializeDataSourceBuilder().type(DriverManagerDataSource.class).build();
	}

	@Primary
	@Bean(name = "memberEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean memberEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(memberDataSource()).packages(Member.class).build();
	}

	@Primary
	@Bean(name = "memberTransactionManager")
	public PlatformTransactionManager memberTransactionManager(
			final @Qualifier("memberEntityManagerFactory") LocalContainerEntityManagerFactoryBean memberEntityManagerFactory) {
		return new JpaTransactionManager(memberEntityManagerFactory.getObject());
	}

}