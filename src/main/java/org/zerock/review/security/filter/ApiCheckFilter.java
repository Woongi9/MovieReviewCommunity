package org.zerock.review.security.filter;

import lombok.extern.log4j.Log4j2;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
public class ApiCheckFilter extends OncePerRequestFilter {

    private AntPathMatcher antPathMatcher;
    private String pattern;

    public ApiCheckFilter(String pattern) {
        this.antPathMatcher = new AntPathMatcher();
        this.pattern = pattern;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest servletRequest,
                                    HttpServletResponse servletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        log.info("REQUESTURI: " + servletRequest.getRequestURI());

        log.info(antPathMatcher.match(pattern, servletRequest.getRequestURI()));

        if (antPathMatcher.match(pattern, servletRequest.getRequestURI())) {
            log.info("ApiCheckFilter..............................");
            log.info("ApiCheckFilter..............................");
            log.info("ApiCheckFilter..............................");

            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
