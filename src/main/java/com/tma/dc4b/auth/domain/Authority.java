package com.tma.dc4b.auth.domain;

import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 */
@Setter
@NodeEntity
public class Authority implements GrantedAuthority {

  private String authority;

  public Authority(String authority) {
    this.authority = authority;
  }

  @Override
  public String getAuthority() {
    return this.authority;
  }
}
