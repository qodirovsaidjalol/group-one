package uz.pdp.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.pdp.spring_boot.config.UserDetails;
import uz.pdp.spring_boot.entity.user.AuthUser;
import uz.pdp.spring_boot.reposiroty.OrganizationRepository;
import uz.pdp.spring_boot.services.auth.AuthUserServiceImpl;
import uz.pdp.spring_boot.services.organization.OrganizationServiceImpl;

@Controller
public class HomeController {

    private final AuthUserServiceImpl authUserService;
    private final OrganizationServiceImpl organizationService;
    private final OrganizationRepository organizationRepository;

    @Autowired
    public HomeController(AuthUserServiceImpl authUserService, OrganizationServiceImpl organizationService, OrganizationRepository organizationRepository) {
        this.authUserService = authUserService;
        this.organizationService = organizationService;
        this.organizationRepository = organizationRepository;
    }

    @RequestMapping(value = {"home"}, method = RequestMethod.GET)
    public String homePage() {
        AuthUser user = authUserService.getUser(((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        if (user.isSuperAdmin())
            return "superAdminPage";
        else if (user.getRole().getName().equals("Admin"))
            return "adminPage";
        return null;
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

}
