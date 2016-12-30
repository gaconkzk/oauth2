package com.tma.dc4b.auth;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

/**
 *
 */
@Component
public class SimpleCORSFilter extends GenericFilterBean {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletResponse res = (HttpServletResponse) response;

    res.setHeader("Access-Control-Allow-Origin", "*");
    res.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
    res.setHeader("Access-Control-Max-Age", "3600");
    res.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");

    chain.doFilter(request, res);
  }
}
