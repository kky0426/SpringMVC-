package com.example.jy.myboard.config.root;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.example.jy.myboard.dao")
@EnableTransactionManagement
public class MyBatisConfig {
	
	private String driverClassName = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/connectdb?useUnicode=true&characterEncoding=utf8";
	private String username = "connectuser";
	private String password = "1036523";
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(url);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean() {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(dataSource());
		factory.setConfigLocation(new ClassPathResource("mybatis_config.xml"));
		return factory;
	}
	
	@Bean
	public SqlSessionTemplate sessionTemplate() throws Exception{
		SqlSessionFactoryBean factory = sqlSessionFactoryBean();
		SqlSessionTemplate template = new SqlSessionTemplate(factory.getObject());
		return template;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
