package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;
    
    @RequestMapping("/login")
    public String login(@RequestParam(value = "username") String username) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, "");
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "this is login:" + username;
    }

    @RequestMapping("/open")
    public String open() {
        return "this is open";
    }

    @RequestMapping("/internal")
    public String internal() {
        return "this is internal";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "this is admin";
    }
}
