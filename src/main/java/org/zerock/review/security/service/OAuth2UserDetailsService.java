package org.zerock.review.security.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.zerock.review.entity.Member;
import org.zerock.review.entity.MemberRole;
import org.zerock.review.repository.MemberRepository;
import org.zerock.review.security.dto.AuthMemberDTO;

import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class OAuth2UserDetailsService extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("------------------------------");
        //oAuth2UserRequest 객체
        log.info("userRequest: " + userRequest);

        String clientName = userRequest.getClientRegistration().getClientName();

        log.info("clientName : " + clientName);
        log.info(userRequest.getAdditionalParameters());

        OAuth2User oAuth2User = super.loadUser(userRequest);

        log.info("===================================");

        oAuth2User.getAttributes().forEach((k,v) ->{
            log.info(k + " : " + v);
        });

        String email = null;

        if (clientName.equals("Google")) {
            email = oAuth2User.getAttribute("email");
        }

        log.info("EMAIL: " + email);

        Member member = saveSocialMember(email);

        AuthMemberDTO authMemberDTO = new AuthMemberDTO(
                member.getEmail(),
                member.getPassword(),
                true,
                member.getRoleSet().stream().map(
                        role -> new SimpleGrantedAuthority("ROLE_" + role.name())

                ).collect(Collectors.toList()),
                oAuth2User.getAttributes()
        );

        authMemberDTO.setName(member.getNickname());
        return authMemberDTO;
    }

    private Member saveSocialMember(String email) {

        Optional<Member> result = memberRepository.findByEmail(email, true);

        if (result.isPresent()) {
            return result.get();
        }

        Member member = Member.builder()
                .email(email)
                .password(passwordEncoder.encode("1111"))
                .nickname(email)
                .fromSocial(true)
                .build();

        member.addMemberRole(MemberRole.USER);

        memberRepository.save(member);

        return member;
    }
}
