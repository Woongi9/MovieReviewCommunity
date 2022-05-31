package org.zerock.review.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.review.entity.Member;
import org.zerock.review.entity.MemberRole;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {
//    @Autowired
//    private MemberRepository memberRepository;
//
//    @Autowired
//    private ReviewRepository reviewRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    @Test
//    public void insertMembers() {
//        IntStream.rangeClosed(1,100).forEach(i ->{
//            Member member = Member.builder()
//                    .email("user" + i + "@google.com")
//                    .nickname("사용자" + i)
//                    .fromSocial(false)
//                    .password(passwordEncoder.encode("1111"))
//                    .build();
//
//            member.addMemberRole(MemberRole.USER);
//
//            if(i > 80)
//                member.addMemberRole(MemberRole.MANAGER);
//
//            if(i > 90)
//                member.addMemberRole(MemberRole.ADMIN);
//
//            memberRepository.save(member);
//        });
//    }
//
//    @Commit
//    @Transactional
//    @Test
//    public void testDeleteMember() {
//        Long mid = 1L;
//        Member member = Member.builder().mid(mid).build();
//
//        reviewRepository.deleteByMember(member);
//        memberRepository.deleteById(mid);
//    }
//
//    @Test
//    public void testFind() {
//        Optional<Member> result = memberRepository.findByEmail("user95@google.com", false);
//
//        Member member = result.get();
//
//        System.out.println(member);
//    }
}