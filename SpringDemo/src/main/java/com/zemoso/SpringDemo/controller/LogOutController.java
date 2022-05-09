package com.zemoso.SpringDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogOutController {
    @RequestMapping("/logout")
    public String logout()
    {
        return "index.html";
    }
}
