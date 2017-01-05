package com.tma.dc4b.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
@Slf4j
public class FLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {


  public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) {
    new SecurityContextLogoutHandler().logout(request, response, authentication);

    log.debug("LOGOUT LOGOUT LOGOUT LOGOUT LOGOUT LOGOUT LOGOUT LOGOUT ");

    response.setStatus(HttpServletResponse.SC_ACCEPTED);
  }
}
