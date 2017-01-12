package com.tma.dc4b.auth.dto;

import com.tma.dc4b.auth.domain.User;
import java.util.Collection;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 */
public class UserDTO implements UserDetails {

  @Getter
  private User user;

  public UserDTO(User user) {
    this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.user.getAuthorities();
  }

  @Override
  public String getPassword() {
    return this.user.getPassword();
  }

  @Override
  public String getUsername() {
    return this.user.getUsername();
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
