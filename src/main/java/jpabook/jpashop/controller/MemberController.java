package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping(value = "/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(@Valid MemberForm form, BindingResult result) {

        //오류시 해당 페이지 이동동
       if(result.hasErrors()){
            return "members/createMemberForm";
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        Member member = new Member();
        member.setName(form.getName());
        member.setAddress(address);

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/MemberList";
    }

//    @GetMapping("/members/1/edit")
    @GetMapping("/members/{memberId}/edit")
    public String updateMemberForm(@PathVariable("memberId") Long memberId, Model model){

        System.out.println("controller.updateItemForm == start");
//        Member members = (Member) memberService.findOne(memberId);
//
//        MemberForm form = new MemberForm();
//
//        form.setName(members.getName());
////        form.setName(members.getName());
////        form.setStreet(members.getAddress(form.getCity(),form.getZipcode(),form.getStreet()));
////        form.setZipcode(members.getZipcode());

//        model.addAttribute("form",form);
        System.out.println("controller.updateItemForm == end");
        return "members/updateMemberForm";
    }
}
