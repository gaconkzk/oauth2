package com.tma.dc4b.auth.domain;

import java.util.Collection;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 */
@Setter
@NoArgsConstructor
@NodeEntity
public class User implements UserDetails {

  @GraphId
  @Getter
  private Long id;

  @Property
  private String password;
  @Property
  private String username;

  @Relationship(direction = Relationship.INCOMING, type = "HAS")
  private Set<Authority> authorities;

  public User(String user, String password) {
    this.username = user;
    this.password = password;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.authorities;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
