package org.zerock.review.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.zerock.review.security.service.OAuth2UserDetailsService;
import org.zerock.review.security.service.UserDetailsService;

@Configuration
@Log4j2
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    PasswordEncoder passwordEncoder() {
        //BCryptPasswordEncoder는 bcrypt라는 해시 함수를 이용해 패스워드 암호화
        //복호화 불가능
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.authorizeRequests()
                .antMatchers("/movie/list", "/h2-console/**", "/").permitAll()
                .antMatchers("/movie/read").hasRole("USER")
                .antMatchers("/movie/register").hasRole("USER")
                .antMatchers("/movie/modify").hasRole("USER");

        http.formLogin().defaultSuccessUrl("/movie/list"); //인가/인증에 문제시 로그인 화면
        http.csrf().disable();
        http.logout().logoutSuccessUrl("/");
        http.oauth2Login().defaultSuccessUrl("/movie/list");
    }
}