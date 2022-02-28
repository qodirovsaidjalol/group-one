package uz.pdp.spring_boot.controller;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.pdp.spring_boot.config.UserDetails;

@Controller
public class HomeController {


    @RequestMapping(value = {"home"}, method = RequestMethod.GET)
    public String homePage(Model model) {

        return "index";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }


    @GetMapping(value = {"/auth/login"})
    public String loginPage() {
        return "login";
    }

}
