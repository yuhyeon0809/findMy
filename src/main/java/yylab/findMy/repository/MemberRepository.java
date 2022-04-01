package yylab.findMy.repository;

import yylab.findMy.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByMemberId(String memberId);
    List<Member> findAll();
}
