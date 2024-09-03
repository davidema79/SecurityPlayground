package com.example.SecurityPlayground.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api/v1")
public class Controller {

    @GetMapping("/open/greeting")
    public  String greetingFormal(){
        return "Good morning Sir";
    }

    @GetMapping("/protected/greeting")
    public  String testFamiliar(@AuthenticationPrincipal OAuth2User principal){
        String name = principal.getAttribute("name");
        String location = principal.getAttribute("location");

        return String.format("Hi %s from %s, \nhow are you doing today?",name, location);
    }
}
