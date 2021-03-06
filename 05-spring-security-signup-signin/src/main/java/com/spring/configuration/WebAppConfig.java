package com.spring.configuration;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan("com.spring")
@PropertySource("classpath:persistence.properties")
@EnableWebMvc
@EnableTransactionManagement
public class WebAppConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;

	private final Logger LOG = Logger.getLogger(getClass().getName());

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public ViewResolver viewResolver() {
		final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource datasource = new ComboPooledDataSource();

		LOG.info(">>> jdbc.url=" + env.getProperty("jdbc.url"));
		LOG.info(">>> jdbc.user=" + env.getProperty("jdbc.user"));
		
		try {
			datasource.setDriverClass(env.getProperty("jdbc.driver"));
			datasource.setJdbcUrl(env.getProperty("jdbc.url"));
			datasource.setUser(env.getProperty("jdbc.user"));
			datasource.setPassword(env.getProperty("jdbc.password"));
		} catch (PropertyVetoException ex) {
			throw new RuntimeException(ex);
		}

		datasource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		datasource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		datasource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		datasource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return datasource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}

	private int getIntProperty(String prop) {
		return Integer.parseInt(env.getProperty(prop));
	}
	
	private Properties getHibernateProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		return props;				
	}

}
