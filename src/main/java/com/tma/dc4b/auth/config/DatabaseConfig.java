package com.tma.dc4b.auth.config;

import com.tma.dc4b.auth.domain.Authority;
import com.tma.dc4b.auth.domain.User;
import com.tma.dc4b.auth.repository.AuthorityRepository;
import com.tma.dc4b.auth.repository.UserRepository;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 */
@Configuration
@EnableNeo4jRepositories
@EnableTransactionManagement
public class DatabaseConfig {

  @Autowired
  UserRepository userRepository;
  @Autowired
  AuthorityRepository authorityRepository;

  @Bean
  @EventListener(ApplicationReadyEvent.class)
  CommandLineRunner demo() {
    return args -> {
      userRepository.deleteAll();
      User user = new User("user", "password");
      List<Authority> authorities = Collections.singletonList(new Authority("ROLE_USER"));
      user.setAuthorities(new HashSet<>(authorities));
      authorityRepository.save(authorities);
      userRepository.save(user);
    };
  }
}
