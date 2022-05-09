package org.zerock.review.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        //BCryptPasswordEncoder는 bcrypt라는 해시 함수를 이용해 패스워드 암호화
        //복호화 불가능
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/sample/all").permitAll()
                .antMatchers("/sample/member").hasRole("USER");

        http.formLogin(); //인가/인증에 문제시 로그인 화면
        http.csrf().disable();
        http.logout();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        //사용자 게정은 user1
        auth.inMemoryAuthentication().withUser("user1")
                .password("$2a$10$lpFybEGcNvXUJ.KeBbS45.Je4bzyfN22g/gmkaNUR2DRYt0lFHGTe")
                .roles("USER");
    }
}
