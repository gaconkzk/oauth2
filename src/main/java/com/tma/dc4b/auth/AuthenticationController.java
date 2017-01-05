package com.tma.dc4b.auth;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class AuthenticationController {

  @GetMapping("/user")
  public Principal user(Principal user) {
    return user;
  }
}
