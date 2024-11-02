package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.enetity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/signup")
    public String signUpPage(){
        return "members/new";
    }

    @PostMapping("/join")
    public String join(MemberForm form) {
        log.info(form.toString());
        // 1. DTO를 엔티티로 변환
        Member member = form.toEntity();
        log.info(member.toString());
        // 2. 리파지토리로 엔티티를 DB에 저장
        Member saved = memberRepository.save(member);
        log.info(saved.toString());
        return "redirect:/members/"+saved.getId();
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model){
        Member member = memberRepository.findById(id).orElse(null);
        model.addAttribute("member", member);
        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model){
        ArrayList<Member> memberList = memberRepository.findAll();
        model.addAttribute("memberList", memberList);
        return "members/index";
    }

    @GetMapping("/members/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Member memberEntity = memberRepository.findById(id).orElse(null);
        model.addAttribute("member", memberEntity);
        return "members/edit";
    }

    @PostMapping("/members/update")
    public String update(MemberForm form){
        Member memberEntity = form.toEntity();
        Member target = memberRepository.findById(memberEntity.getId()).orElse(null);
        if(target != null){
            memberRepository.save(memberEntity);
        }
        return "redirect:/members/"+memberEntity.getId();
    }

    @GetMapping("members/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        Member target = memberRepository.findById(id).orElse(null);
        if(target != null) {
            memberRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제됐습니다!");
        }
        return "redirect:/members";
    }
}
