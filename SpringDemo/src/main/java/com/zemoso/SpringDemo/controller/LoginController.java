package com.zemoso.SpringDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/home")
    public String showHomePage()
    {
        return "home";
    }
    @GetMapping("/welcome")
    public String welcomePage()
    {
        return "welcome";
    }
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        return "fancy-login" ;
    }

    @GetMapping("/access-denied")
    public String showAccessDenied()
    {
        return "access-denied";
    }
}
