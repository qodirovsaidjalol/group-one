package uz.pdp.spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = {"", "/home"}, method = RequestMethod.GET)
    public String homePage() {
        return "index";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

}
