package com.vueprac.fyni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/greeting")
    public String greeting() {
        return "index";
    }
}
