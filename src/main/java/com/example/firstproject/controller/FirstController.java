package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model){
        model.addAttribute("username", "hongpark");

        return "greetings"; //greetings.mustache 파일 반환
        // 서버가 templates에서 찾아서 반환해준다.
    }
}
