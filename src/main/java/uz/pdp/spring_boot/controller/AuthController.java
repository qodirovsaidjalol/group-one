package uz.pdp.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.auth.AuthUserCreateDto;
import uz.pdp.spring_boot.dto.auth.AuthUserUpdateDto;
import uz.pdp.spring_boot.services.auth.AuthUserService;

@Controller
@RequestMapping("/auth/*")
public class AuthController extends AbstractController<AuthUserService> {

    @Autowired
    public AuthController(@Qualifier("authUserServiceImpl") AuthUserService service) {
        super(service);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createPage(Model model) {
        model.addAttribute("user", new AuthUserCreateDto());
        return "auth/create";
    }

    @RequestMapping(value = "/createAdmin/{id}", method = RequestMethod.GET)
    public String createAdmin(Model model, @PathVariable(name = "id") Long id) {
        AuthUserCreateDto dto = new AuthUserCreateDto();
        dto.setOrganizationId(id);
        model.addAttribute("user", dto);
        return "auth/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute AuthUserCreateDto createDto, Model model) {
        service.create(createDto);
        if (createDto.getOrganizationId() != null) return "redirect:/organization/list";
        return "redirect:/auth/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", service.get(id));
        return "auth/edit";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable("id") Long id, RedirectAttributes redirectAttributes, @ModelAttribute AuthUserUpdateDto dto, Model model) {
        service.update(dto);
        model.addAttribute("user", service.get(id));
        return "redirect:/auth/list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", service.get(id));
        return "auth/delete";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes, Model model) {
        service.delete(id);
        return "redirect:/auth/list";
    }

    @RequestMapping(value = "block/{id}", method = RequestMethod.GET)
    public String blockPage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("user", service.get(id));
        return "auth/block";
    }

    @RequestMapping(value = "block/{id}", method = RequestMethod.POST)
    public String block(@PathVariable(name = "id") Long id) {
        service.block(id);
        return "redirect:/auth/list";
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public String detail(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("user", service.get(id));
        return "auth/detail";
    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("users", service.getAll(new GenericCriteria()));
        return "auth/list";
    }

    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    public String getAllFromOrg(Model model) {
        model.addAttribute("users", service.getAllFromOrganization());
        return "auth/list";
    }
}
