package yylab.findMy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import yylab.findMy.domain.member.Member;
import yylab.findMy.service.MemberService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String joinForm() {
        return "member/joinForm";
    }

    @PostMapping("/join")
    public String join(MemberDto dto) {
        Member member = new Member();
        member.setMemberId(dto.getMemberId());
        member.setPassword(dto.getPassword());
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> memberList = memberService.findAllMembers();
        model.addAttribute("memberList", memberList);
        return "member/memberList";
    }

    @PostMapping("/members")
    public String checkedList() {
        return "redirect:/";
    }


}
