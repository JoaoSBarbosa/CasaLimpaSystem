package com.joaosbarbosa.dev.casaLimpaPlus.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AuthController {

    @GetMapping("/login")
    private String login(){
        return "admin/auth/login";
    }
}
