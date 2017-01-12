package com.tma.dc4b.auth.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "theflies", ignoreUnknownFields = true)
public class TheFliesProperties {

  private String dbUri;
  private String dbDriverClassName;

  private String dbUsername;
  private String dbPassword;

}
