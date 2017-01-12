package com.tma.dc4b.auth;

import org.liquigraph.core.api.Liquigraph;
import org.liquigraph.core.configuration.Configuration;
import org.liquigraph.core.configuration.ConfigurationBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class LiguigraphMigration implements CommandLineRunner {

  @Bean
  public Configuration configuration() {
    return new ConfigurationBuilder()
        .withMasterChangelogLocation("db/liquigraph/changelog.xml")
        .withUri("jdbc:neo4j:bolt://localhost")
        .withUsername("neo4j")
        .withPassword("123456")
        .withRunMode()
        .build();
  }

  @Override
  public void run(String... args) throws Exception {
    Liquigraph liquigraph = new Liquigraph();
    liquigraph.runMigrations(configuration());
  }
}
