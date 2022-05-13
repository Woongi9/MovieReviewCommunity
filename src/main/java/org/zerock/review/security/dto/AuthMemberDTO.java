package org.zerock.review.security.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Log4j2
@Getter
@Setter
@ToString
public class AuthMemberDTO extends User implements OAuth2User {
    //DTO 역할 + 스프링 시큐리티에서 인증 작업

    private String email;

    private String name;

    private boolean fromSocial;

    private Map<String, Object> attr;

    public AuthMemberDTO(String username, String password, boolean fromSocial,
                             Collection<? extends GrantedAuthority> authorities, Map<String, Object> attr) {
        this(username,password, fromSocial, authorities);
        this.attr = attr;
    }

    public AuthMemberDTO(String username, String password,
                         boolean fromSocial,
                         Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.email = username;
        this.fromSocial = fromSocial;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.attr;
    }
}