package com.tma.dc4b.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

/**
 *
 */
@ComponentScan
@EnableAutoConfiguration
@EnableNeo4jRepositories(basePackages = "com.tma.dc4b.auth.repository")
@Slf4j
public class AuthApplication {

  public static void main(String[] args) {
    SpringApplication.run(AuthApplication.class, args);
  }
}
