package yylab.findMy.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import yylab.findMy.domain.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(Long id);
    Optional<Member> findByMemberId(String memberId);
}
