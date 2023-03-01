package com.marex333.inventory.controllers;

import com.marex333.inventory.exceptions.UserPersistException;
import com.marex333.inventory.model.User;
import com.marex333.inventory.services.IAuthenticatorService;
import com.marex333.inventory.session.SessionObject;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserAuthenticatorController {
    @Autowired
    IAuthenticatorService authenticatorService;
    @Resource
    SessionObject sessionObject;
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("sessionObject", this.sessionObject);
        return this.sessionObject.isLogged() ? "redirect:/main" : "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String login,
                        @RequestParam String password) {
        authenticatorService.authenticate(login, password);
        return sessionObject.isLogged() ? "redirect:/main" : "redirect:/login";
    }
    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout() {
        authenticatorService.logout();
        return "redirect:/main";
    }
    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String register (Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register (@ModelAttribute User user, String password2){
        try {
            authenticatorService.persist(user, password2);
        } catch (UserPersistException e) {
            System.out.println("User Persist Exception");
            return "redirect:/register";
        }
        return "redirect:/main";
    }

    @RequestMapping(path = "/demo", method = RequestMethod.GET)
    public String demo() {
        authenticatorService.authenticate("demo","demo");
        return "redirect:/main";
    }
}
