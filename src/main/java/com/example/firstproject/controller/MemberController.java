package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.enetity.Member;
import com.example.firstproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/signup")
    public String signup(){
        return "members/new";
    }

    @PostMapping("/join")
    public String join(MemberForm form) {
        System.out.println(form.toString());
        // 1. DTO를 엔티티로 변환
        Member member = form.toEntity();
        System.out.println(member.toString());
        // 2. 리파지토리로 엔티티를 DB에 저장
        Member saved = memberRepository.save(member);
        System.out.println(saved.toString());
        return "";
    }


}
