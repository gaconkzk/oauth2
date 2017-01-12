package com.tma.dc4b.auth.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 */
@Setter
@NoArgsConstructor
@NodeEntity
public class Authority implements GrantedAuthority {

  @GraphId
  @Getter
  private Long id;

  private String authority;

  public Authority(String authority) {
    this.authority = authority;
  }

  @Override
  public String getAuthority() {
    return this.authority;
  }
}
