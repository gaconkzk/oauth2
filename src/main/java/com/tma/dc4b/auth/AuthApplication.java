package com.tma.dc4b.auth;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 */
@SpringBootApplication
@RestController
@EnableAuthorizationServer
@EnableResourceServer
public class AuthApplication extends WebMvcConfigurerAdapter {

  @GetMapping("/user")
  public Principal user(Principal user) {
    return user;
  }

  @Configuration
  @Order(-20)
  protected  static class LoginConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
          .formLogin()
          .and()
            .requestMatchers()
            .antMatchers("/login","/oauth/authorize", "/oauth/confirm_access")
          .and()
            .authorizeRequests()
              .anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.parentAuthenticationManager(authenticationManager);
    }
  }

  public static void main(String[] args) {
    SpringApplication.run(AuthApplication.class, args);
  }

}
