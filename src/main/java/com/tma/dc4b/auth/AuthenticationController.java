package com.tma.dc4b.auth;

import java.security.Principal;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 */
@EnableResourceServer
@RestController
@SessionAttributes("authorizationRequest")
public class AuthenticationController {

  @GetMapping("/user")
  public Principal user(Principal user) {
    return user;
  }
}
