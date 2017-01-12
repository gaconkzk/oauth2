package com.tma.dc4b.auth.domain;

import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 *
 */
@Setter
@Getter
@NoArgsConstructor
@NodeEntity
public class User {

  @GraphId
  private Long id;

  private String password;
  private String username;
  private boolean enabled = true;
  private boolean accountNonExpired = true;
  private boolean accountNonLocked = true;
  private boolean credentialsNonExpired = true;

  @Relationship(direction = Relationship.INCOMING, type = "HAS")
  private Set<Authority> authorities;

  public User(String user, String password) {
    this.username = user;
    this.password = password;
  }
}
