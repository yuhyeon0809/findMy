package yylab.findMy.domain.member;

import yylab.findMy.domain.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByMemberId(String memberId);
    List<Member> findAll();
}
