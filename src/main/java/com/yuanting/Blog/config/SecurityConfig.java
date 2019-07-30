package com.yuanting.Blog.config;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yuanting.Blog.service.impl.SecurityServiceImpl;
 

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
	}

	@Bean
	public SecurityServiceImpl userDetailsService() {
		return new SecurityServiceImpl(); 
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService())
	        .passwordEncoder(passwordEncoder());
 
	}
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/css/**", "/js/**","/images/**", "/webjars/**", "/", "/home").permitAll()
			.antMatchers("/","/about").permitAll() 
		    .anyRequest().authenticated()
		  .and()
		  	.formLogin() 
		  	.loginPage("/login")
		  	.defaultSuccessUrl("/home")
            .usernameParameter("username")
            .passwordParameter("password")
		    .permitAll()
		   .and()
        	.logout().deleteCookies("JSESSIONID")
        	.permitAll()
  		  .and().sessionManagement().maximumSessions(1);
		
			http
			.rememberMe().rememberMeParameter("remember-new").key("uniqueAndSecret").tokenValiditySeconds(86400);
        http.csrf().disable();
	}
}
