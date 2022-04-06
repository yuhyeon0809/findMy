package yylab.findMy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yylab.findMy.domain.member.Member;
import yylab.findMy.domain.member.MemberRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final EntityManager em;

    public Long join(Member member) {

        long start = System.currentTimeMillis();

        try {
            //validateMember(member);
            memberRepository.save(member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join: " + timeMs + "ms");
        }
    }

    public void validateMember(Member member) {
        memberRepository.findByMemberId(member.getMemberId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findAllMembers() {

        long start = System.currentTimeMillis();

        try {
            return memberRepository.findAll();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findAllMembers: " + timeMs + "ms");
        }

    }

    public Optional<Member> findOneMember(String memberId) {

        long start = System.currentTimeMillis();

        try {
            return memberRepository.findByMemberId(memberId);
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("fineOneMember: " + timeMs + "ms");
        }

    }

    public void init_member() {

        long start = System.currentTimeMillis();

        try {
            em.createNativeQuery("TRUNCATE TABLE Member")
                    .executeUpdate();


        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("init_member: " + timeMs + "ms");
        }
    }

}
