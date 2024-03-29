package com.marex333.inventory.controllers;

import com.marex333.inventory.model.Alcohol;
import com.marex333.inventory.session.SessionObject;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.util.stream.Collectors.toList;

@Controller
public class CommonController {

    @Resource
    SessionObject sessionObject;

    @RequestMapping(path = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("sessionObject", sessionObject);
        return "redirect:/";
    }
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String main1(Model model) {
        model.addAttribute("sessionObject", sessionObject);
        if(sessionObject.getUser() != null) {
            model.addAttribute("alcohols", sessionObject.getUser().getAlcoholList());
        }
        return "main";
    }
    @RequestMapping(path = "/about", method = RequestMethod.GET)
    public String about(Model model) {
        model.addAttribute("sessionObject", sessionObject);
        return "about";
    }
    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String test(Model model) {
        model.addAttribute("sessionObject", sessionObject);
        return "test";
    }
}
