package org.zerock.review.security.filter;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
public class ApiLoginFilter extends AbstractAuthenticationProcessingFilter {

    public ApiLoginFilter(String defaultFilterProccessUrl) {
        super(defaultFilterProccessUrl);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest servletRequest,
                                                HttpServletResponse servletResponse)
            throws AuthenticationException, IOException, ServletException {

        log.info("--------------APiLOginFilter--------------");
        log.info("attemptAuthentication");

        String email = servletRequest.getParameter("email");
        String pw = "1111";

        if (email == null) {
            throw new BadCredentialsException("email cannot be null");
        }

        return null;
    }
}
