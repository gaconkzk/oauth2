package com.tma.dc4b.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
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
  TokenStore tokenStore;

  public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) {
    String authorization = request.getHeader("authorization");
    if (authorization != null && !authorization.isEmpty()) {
      OAuth2AccessToken accessToken = tokenStore
          .readAccessToken(request.getHeader("authorization").split(" ")[1]);
      tokenStore.removeAccessToken(accessToken);
    }

    response.setStatus(HttpServletResponse.SC_ACCEPTED);
  }
}
