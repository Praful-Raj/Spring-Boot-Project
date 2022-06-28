package com.learn.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfigMovie extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	{
		try
		{
			PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
			//create user authentication information
			//inMemoryAuthentication -> we are not storing any information in db/file, instead we are storing in Spring Boot Memory Space
			auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema().withUser("praful").password(encoder.encode("12345")).roles("manager")
			.and().withUser("raj").password(encoder.encode("abcde")).roles("cashier")
			.and().withUser("ashok").password(encoder.encode("12345")).roles("admin");
		}
		catch(Exception ex)
		{
			System.out.println("error in sec. configure : " + ex.getMessage());
		}
	}

	//encoder or encrypt
	//we are not using any password encoder or encrypt, password will be stored as plain text
	/*
	@Bean
	PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	*/
	
	@Override
	public void configure(WebSecurity web) {
		try
		{
			web.ignoring().antMatchers("/h2-console/**");
		}
		catch(Exception ex)
		{
			System.out.println("error in bypass: "+ex.getMessage());
		}
		
	}
	
	
	
}
