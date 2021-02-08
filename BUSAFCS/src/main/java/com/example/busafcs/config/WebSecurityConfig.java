package com.example.busafcs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.busafcs.filter.JWTAuthorizationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
	
	/*
	 * @Autowired private AuthEntryPointJwt unauthorizedHandler;
	 */
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		http.cors().and().csrf().disable()
		.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.authorizeRequests().antMatchers("/api/auth/**").permitAll()
		.antMatchers("/api/test/**").permitAll()
		.anyRequest().authenticated();
		*/
		/*
		http.csrf().disable()
			.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/api/user/*").permitAll()
			.antMatchers(HttpMethod.GET, "/api/user/*").permitAll()
			
			//.antMatchers(HttpMethod.GET, "/user").permitAll()
			.anyRequest().authenticated();
			*/
		
		/*
		 * http.csrf().disable() //.addFilterAfter(new JWTAuthorizationFilter(),
		 * UsernamePasswordAuthenticationFilter.class) .authorizeRequests()
		 * .antMatchers("/auth/*").permitAll() .antMatchers("/api/user/*").permitAll()
		 * 
		 * //.antMatchers(HttpMethod.GET, "/user").permitAll()
		 * .anyRequest().authenticated(); http.addFilterAfter(new
		 * JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
		 */
		/*
		http.cors().and().csrf().disable()
		.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.authorizeRequests().antMatchers("/api/auth/**").permitAll()
		.antMatchers("/api/user/**").hasRole("USER")
		.anyRequest().authenticated();
		
		*/

	//http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		/*
		http.csrf().disable()
		.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests()
		.antMatchers("/api/auth/**").permitAll()
		.antMatchers("/api/user/*").hasRole("USER")
		
		//.antMatchers(HttpMethod.GET, "/user").permitAll()
		.anyRequest().authenticated();
			*/
		
		http.csrf().disable()
		//.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
		//.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests()
		.antMatchers("/api/auth/**").permitAll()
		//.antMatchers("/api/user/**").hasRole("USER")
		
		//.antMatchers(HttpMethod.GET, "/user").permitAll()
		//.antMatchers("/api/user/**").hasRole("USER")
		//.antMatchers("/api/user-management/**").hasAnyRole("ADMIN")
		.anyRequest().authenticated();
	}
	
	@Bean
	public JWTAuthorizationFilter authenticationJwtTokenFilter() {
		return new JWTAuthorizationFilter();
	}
	
	
}
