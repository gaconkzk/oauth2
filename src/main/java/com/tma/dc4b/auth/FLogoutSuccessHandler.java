package com.tma.dc4b.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
@Slf4j
public class FLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

  @Autowired
  @Qualifier("jwtTokenStore")
  TokenStore tokenStore;

  public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) {
    response.setStatus(HttpServletResponse.SC_ACCEPTED);
  }
}
