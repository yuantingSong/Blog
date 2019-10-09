package com.yuanting.Blog.config;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yuanting.Blog.jwt.MyUserDetails;
 

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); 
	}

	@Bean
	public MyUserDetails userDetailsService() {
		return new MyUserDetails(); 
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService())
	        .passwordEncoder(passwordEncoder());
	    auth.inMemoryAuthentication().withUser("2").password(passwordEncoder().encode("2")).roles("USER", "ADMIN");
 
	}
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/css/**", "/js/**","/images/**", "/webjars/**", "/", "/register","/resume","/contact","/articleCenter").permitAll()
			.antMatchers("/articles","/about").permitAll() 
		    .anyRequest().authenticated()
	//	  .and()
		 // 	.addFilter(new JWT)
		  .and()
		  	.formLogin() 
		  	.loginPage("/login")
		  	.defaultSuccessUrl("/")
            .usernameParameter("username")
            .passwordParameter("password")
		    .permitAll()
		   .and()
        	.logout().deleteCookies("JSESSIONID")
        	.permitAll()
        	.logoutSuccessUrl("/")
  		  .and().sessionManagement().maximumSessions(1);
		
		http
			.rememberMe().rememberMeParameter("remember-new").key("uniqueAndSecret").tokenValiditySeconds(86400);
        http
        	.cors()
        	.and()
        	.csrf().disable();
	}
}
