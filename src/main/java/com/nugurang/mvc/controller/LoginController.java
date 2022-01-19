package com.nugurang.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LoginController.class);
    //</editor-fold>

    @RequestMapping("/login")
    public String login() {
        return "forward:/login/index.html";
    }
}
