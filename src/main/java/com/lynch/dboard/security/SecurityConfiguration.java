package com.lynch.dboard.security;

import com.lynch.dboard.service.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  AppUserDetailsService appUserDetailsService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(appUserDetailsService)
        .passwordEncoder(new BCryptPasswordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.securityContext()
            .and()
            .exceptionHandling()
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/api/users/register").permitAll()
            .antMatchers(HttpMethod.POST, "/api/messages/send").permitAll()
            .antMatchers(HttpMethod.GET, "/users/usernames/all").permitAll()
            .antMatchers(HttpMethod.GET, "/messageTest").permitAll()
            .antMatchers( "/api/user").authenticated()
            .antMatchers(HttpMethod.GET, "/api/discussion/headers").permitAll()
      .antMatchers( HttpMethod.GET,"/api/discussions/tag/**").hasAnyRole("USER", "ADMIN")
            .antMatchers( "/api/discussions/**").hasAnyRole("USER", "ADMIN")
            //.antMatchers( "/api/comments/**").hasAnyRole("USER", "ADMIN")
            //.antMatchers( "/api/tags/**").hasAnyRole("USER", "ADMIN")
            .and()
            .httpBasic()
            .and()
            .cors()
            .and()
            .csrf().disable();
   //  .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource(){
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
    configuration.setAllowedMethods(Arrays.asList("GET", "PUT", "POST", "DELETE", "HEAD", "OPTIONS"));
    configuration.setAllowedHeaders(Arrays.asList("*"));
    configuration.addExposedHeader("Authorization");
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }


  @Bean
  public BCryptPasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }

}


