package yylab.findMy.web.member;

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

    @GetMapping("/member/join")
    public String joinForm() {
        return "member/joinForm";
    }

    @PostMapping("/member/join")
    public String join(MemberDto dto) {
        Member member = new Member();
        member.setMemberId(dto.getMemberId());
        member.setPassword(dto.getPassword());
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/member/list")
    public String list(Model model) {
        List<Member> memberList = memberService.findAllMembers();
        model.addAttribute("memberList", memberList);
        return "member/memberList";
    }

    @PostMapping("/member/list")
    public String checkedList() {
        return "redirect:/";
    }

    @GetMapping("/admin/initmember")
    public String init_db() {
        memberService.init_member();
        return "admin/initMember";
    }


}
