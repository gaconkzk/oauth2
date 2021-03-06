package com.tma.dc4b.auth.service;

import com.tma.dc4b.auth.dto.UserDTO;
import com.tma.dc4b.auth.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserDetailsService implements
    org.springframework.security.core.userdetails.UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return new UserDTO(
        Optional.ofNullable(userRepository.findOneByUsernameAndAccountNonLocked(username, true))
        .orElseThrow(() -> new UsernameNotFoundException("User not existed")));
  }
}
