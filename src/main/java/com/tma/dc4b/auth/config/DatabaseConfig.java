package com.tma.dc4b.auth.config;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 */
@Configuration
@EnableNeo4jRepositories(basePackages = "com.tma.dc4b.auth.repository")
@EnableTransactionManagement
public class DatabaseConfig extends Neo4jConfiguration {

  @Override
  @Bean
  public SessionFactory getSessionFactory() {
    org.neo4j.ogm.config.Configuration config = new org.neo4j.ogm.config.Configuration();
    config.driverConfiguration()
        .setDriverClassName("org.neo4j.ogm.drivers.bolt.driver.BoltDriver")
        .setURI("bolt://neo4j:123456@localhost");
    return new SessionFactory(config, "com.tma.dc4b.auth.domain");
//    return new SessionFactory("com.tma.dc4b.auth.domain");
  }

  @Override
  @Bean
  @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
  public Session getSession() throws Exception {
    return super.getSession();
  }
}
