package org.refrap.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {

    @GetMapping("/admin**")
    public String adminPage(Model model){

        model.addAttribute("title", "Spring Security + Hibernate Example");
        model.addAttribute("message", "This page is for ROLE_ADMIN only!");

        return "/admin";
    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request){
        if (error != null) {
            model.addAttribute("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
        }

        if (logout != null) {
            model.addAttribute("msg", "You've been logged out successfully.");
        }
        return "/login";
    }

    @GetMapping("/403")
    public String error403(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!(auth instanceof AnonymousAuthenticationToken)){
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            System.out.println(userDetails);
            model.addAttribute(userDetails.getUsername());
        }


        return "/403";
    }

    // customize the error message
    private String getErrorMessage(HttpServletRequest request, String key) {

        Exception exception = (Exception) request.getSession().getAttribute(key);

        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username and password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Invalid username and password!";
        }

        return error;
    }
}
