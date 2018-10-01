package com.videocall.app.aduiovideocall.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebApplicationInitializer {


	@Autowired
	private DataSource dataSource;


	@Override
	public void onStartup(ServletContext servletContext) {

		servletContext.addListener(HttpSessionEventPublisher.class);
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select email as principal, password as credentails, true from user where email=?")
		.authoritiesByUsernameQuery("select user_email as principal, role_name as role from user_roles where user_email=?")
		.passwordEncoder(passwordEncoder()).rolePrefix("ROLE_");  
		
	}
   
	@Bean
	public PasswordEncoder passwordEncoder() {
		// TODO Auto-generated method stub
		return new BCryptPasswordEncoder();
	}


	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}
	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//		http.authorizeRequests().antMatchers("/register", "/", "/about", "/login", "/css/**", "/webjars/**").permitAll().anyRequest().authenticated()
////				.antMatchers("/profile").hasAnyRole("USER,ADMIN")
////				.antMatchers("/users","/addTask").hasRole("ADMIN")
//				.and().formLogin().loginPage("/login").permitAll()
//				.defaultSuccessUrl("/profile").and().logout().logoutSuccessUrl("/login");
//	}

		http
				.sessionManagement()
				.maximumSessions(1).sessionRegistry(sessionRegistry());
	http.authorizeRequests().antMatchers("/register", "/", "/about", "/login", "/css/**","/js/**", "/webjars/**").permitAll()
	.antMatchers("/profile","/subjectLevel").hasAnyRole("USER","TEACHER","ADMIN")
	.antMatchers("/users","/addTask").hasRole("ADMIN")
	.and().formLogin().loginPage("/login").permitAll()
	.defaultSuccessUrl("/profile").and().logout().logoutSuccessUrl("/login");
}


}
