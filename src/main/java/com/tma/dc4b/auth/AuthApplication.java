package com.tma.dc4b.auth;

import com.tma.dc4b.auth.config.TheFliesProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 */
@ComponentScan
@EnableAutoConfiguration
@EnableConfigurationProperties({TheFliesProperties.class})
@Slf4j
public class AuthApplication {

  public static void main(String[] args) {
    SpringApplication.run(AuthApplication.class, args);
  }
}
