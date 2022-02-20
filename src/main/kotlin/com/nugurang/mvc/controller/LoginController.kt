package com.nugurang.mvc.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class LoginController {
    @RequestMapping("/login")
    fun login(): String {
        return "forward:/login/index.html"
    }
}