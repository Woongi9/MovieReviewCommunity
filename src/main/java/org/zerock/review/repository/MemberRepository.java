package org.zerock.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.review.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
