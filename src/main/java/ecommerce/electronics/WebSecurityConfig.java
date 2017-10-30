package ecommerce.electronics;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests().antMatchers("/cart").authenticated()
			.and()
			.authorizeRequests().anyRequest().permitAll()
			.and()
		.formLogin()
			.loginPage("/login")
	        .defaultSuccessUrl("/")
	        .permitAll()
	        .and()
	    .logout()
	        .permitAll();
	}
	
	
}
