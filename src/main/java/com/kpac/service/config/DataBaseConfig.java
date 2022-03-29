package com.kpac.service.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * className DataBaseConfig
 * @version 1.0
 * @author Supreeth
 *
 */

@Configuration
@ComponentScan("com.kpac.service.repo")
public class DataBaseConfig {

		/**
		 * 
		 * dataSource
		 * 
		 * @return DataSource
		 */
		@Bean
	    public DataSource dataSource() {
	        return new EmbeddedDatabaseBuilder()
	          .setType(EmbeddedDatabaseType.H2)
	          .addScript("classpath:schema.sql")
	          .addScript("classpath:test-data.sql")
	          .build();
	    }

	    /**
	     * 
	     * mysqlDataSource
	     * 
	     * @return DataSource
	     */
	    @Bean
	    public DataSource mysqlDataSource() {
	        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/kpac");
	        dataSource.setUsername("root");
	        dataSource.setPassword("admin");

	        return dataSource;
	    }
	    
}
