package dev.sangwon.carwith.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/socialLogin")
    public String socialLogin(){
        return "socialLogin";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }
}
