package com.marex333.inventory.controllers;

import com.marex333.inventory.services.IAuthenticatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserAuthenticatorController {
    @Autowired
    IAuthenticatorService authenticatorService;
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login() {
        return "/login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String login,
                        @RequestParam String password) {
        authenticatorService.authenticate(login, password);
        return "redirect:/login";
    }
}
