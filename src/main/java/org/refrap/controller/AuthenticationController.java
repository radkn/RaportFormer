package org.refrap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {

    @GetMapping("/admin**")
    public String adminPage(Model model){

        model.addAttribute("title", "Spring Security + Hibernate Example");
        model.addAttribute("message", "This page is for ROLE_ADMIN only!");

        return "/admin";
    }

    @GetMapping("/login")
    public String login(){

        return "/login";
    }

    @PostMapping("/403")
    public String error403(Model model){

        return "/403";
    }
}
