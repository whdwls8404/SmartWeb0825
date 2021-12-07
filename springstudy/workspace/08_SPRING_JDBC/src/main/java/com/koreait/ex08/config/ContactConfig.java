package com.koreait.ex08.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.koreait.ex08.repository.ContactRepository;
import com.koreait.ex08.service.ContactService;
import com.koreait.ex08.service.ContactServiceImpl;

@Configuration
public class ContactConfig {

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("scott");
		dataSource.setPassword("1111");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate template() {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource());
		return template;
	}
	
	@Bean
	public ContactRepository repository() {
		return new ContactRepository();
	}
	
	@Bean
	public ContactService service() {
		return new ContactServiceImpl();
	}
	
}