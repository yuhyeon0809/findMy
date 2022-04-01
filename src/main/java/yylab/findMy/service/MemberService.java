package yylab.findMy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yylab.findMy.domain.Member;
import yylab.findMy.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

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

}
