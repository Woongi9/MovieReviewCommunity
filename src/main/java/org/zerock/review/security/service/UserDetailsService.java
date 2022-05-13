package org.zerock.review.security.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Service;
import org.zerock.review.entity.Member;
import org.zerock.review.repository.MemberRepository;
import org.zerock.review.security.dto.AuthMemberDTO;

import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {

        log.info("UserDetailsService loadUserByUsername " + username);

        Optional<Member> result = memberRepository.findByEmail(username, false);

        if (result.isEmpty()) {
            throw new UsernameNotFoundException("CHeck Email or Social");
        }

        Member member = result.get();
        log.info("------------------------------");
        log.info(member);

        AuthMemberDTO authMember = new AuthMemberDTO(
                member.getEmail(),
                member.getPassword(),
                member.isFromSocial(),
                member.getRoleSet().stream()
                        .map(role -> new SimpleGrantedAuthority(
                                "ROLE_" + role.name()
                        )).collect(Collectors.toSet())
        );

        authMember.setName(member.getNickname());
        authMember.setFromSocial(member.isFromSocial());

        return authMember;
    }
}
