package com.tma.dc4b.auth.domain;

import java.util.Collection;
import java.util.Set;
import lombok.Setter;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 */
@Setter
@NodeEntity
public class User implements UserDetails {

  private String password;
  private String username;
  private boolean isAccountNonExpired = true;
  private boolean isAccountNonLocked = true;
  private boolean isCredentialsNonExpired = true;
  private boolean isEnabled = true;

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
    return this.isAccountNonExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return this.isAccountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return this.isCredentialsNonExpired;
  }

  @Override
  public boolean isEnabled() {
    return this.isEnabled;
  }
}
