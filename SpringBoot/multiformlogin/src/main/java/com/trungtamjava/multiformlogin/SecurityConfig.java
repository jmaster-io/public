package com.trungtamjava.multiformlogin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public UserDetailsService userDetailsService() throws Exception {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("user").password(encoder().encode("userPass")).roles("USER").build());

		manager.createUser(User.withUsername("admin").password(encoder().encode("adminPass")).roles("ADMIN").build());

		return manager;
	}

	@Bean
	public static PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Configuration
	@Order(1)
	public static class App1ConfigurationAdapter extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.antMatcher("/admin/**").authorizeRequests().anyRequest().hasRole("ADMIN")
					.and().formLogin().loginPage("/loginAdmin").loginProcessingUrl("/admin/login")
					.failureUrl("/loginAdmin?error=loginError").defaultSuccessUrl("/admin/page")

					.and().logout().logoutUrl("/admin_logout").logoutSuccessUrl("/protectedLinks")
					.deleteCookies("JSESSIONID")

					.and().exceptionHandling().accessDeniedPage("/403")

					.and().csrf().disable();
		}
	}

	@Configuration
	@Order(2)
	public static class App2ConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			http.antMatcher("/user/**").authorizeRequests().anyRequest().hasRole("USER")

					.and().formLogin().loginPage("/loginUser").loginProcessingUrl("/user/login")
					.failureUrl("/loginUser?error=loginError").defaultSuccessUrl("/user/page")

					.and().logout().logoutUrl("/user_logout").logoutSuccessUrl("/protectedLinks")
					.deleteCookies("JSESSIONID")

					.and().exceptionHandling().accessDeniedPage("/403")

					.and().csrf().disable();
		}
	}
}
