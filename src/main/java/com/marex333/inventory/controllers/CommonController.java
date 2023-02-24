package com.marex333.inventory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {
    @RequestMapping(path = "/main", method = RequestMethod.GET)
    public String main() {
        return "redirect:/";
    }
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String main1() {
        return "main";
    }
}
