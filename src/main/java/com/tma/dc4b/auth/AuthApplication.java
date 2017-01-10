package com.tma.dc4b.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 */
@SpringBootApplication
@RestController
@EnableResourceServer
@SessionAttributes("authorizationRequest")
@Slf4j
public class AuthApplication extends WebMvcConfigurerAdapter {

  @Autowired
  public TokenStore tokenStore;

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/login").setViewName("login");
  }

  // TODO: We need user details services, password encoder here
  @Configuration
  @Order(-20)
  protected static class LoginConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private FLogoutSuccessHandler customLogoutSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      // @formatter:off
      http
          .logout().invalidateHttpSession(true).clearAuthentication(true)
        .and()
          .formLogin().loginPage("/login").permitAll()
        .and()
          .requestMatchers()
            .antMatchers("/login","/oauth/authorize","/oauth/confirm_access")
        .and()
          .authorizeRequests()
            .anyRequest().authenticated();
      // @formatter:on
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
