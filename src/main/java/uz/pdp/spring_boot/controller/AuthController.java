package uz.pdp.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.auth.AuthUserCreateDto;
import uz.pdp.spring_boot.services.auth.AuthUserService;
import uz.pdp.spring_boot.services.auth.AuthUserServiceImpl;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth/*")
public class AuthController extends AbstractController<AuthUserService> {

    @Autowired
    public AuthController(@Qualifier("authUserServiceImpl") AuthUserServiceImpl service) {
        super(service);
    }

    @GetMapping("create")
    public String userCreatePage(Model model) {
        model.addAttribute("dto", new AuthUserCreateDto());
        return "auth/create";
    }

    @PostMapping("create")
    public String userCreate(@Valid @ModelAttribute(name = "dto") AuthUserCreateDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "auth/create";
        }
        service.create(dto);
        return "auth/list";
    }

    @GetMapping("update/{id}")
    public String updatePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("user", service.get(id));
        return "auth/update";
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute(name = "dto") AuthUserCreateDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "auth/create";
        }
        service.create(dto);
        return "auth/list";
    }


    @RequestMapping(value = "delete/{id}/", method = RequestMethod.GET)
    public String deletePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("user", service.get(id));
        return "auth/delete";
    }

    @RequestMapping(value = "delete/{id}/", method = RequestMethod.POST)
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/auth/list";
    }

    @RequestMapping(value = "block/{id}/", method = RequestMethod.GET)
    public String blockPage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("user", service.get(id));
        return "auth/block";
    }

    @RequestMapping(value = "block/{id}/", method = RequestMethod.POST)
    public String block(@PathVariable(name = "id") Long id) {
        service.block(id, false);
        return "redirect:/auth/list";
    }

    @RequestMapping(value = "unblock/{id}/", method = RequestMethod.GET)
    public String unblockPage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("user", service.get(id));
        return "auth/unblock";
    }

    @RequestMapping(value = "unblock/{id}/", method = RequestMethod.POST)
    public String unblock(@PathVariable(name = "id") Long id) {
        service.block(id, true);
        return "redirect:/auth/list";
    }

    @RequestMapping("list")
    public String list(Model model/*, @PathVariable(name = "userId") Long userId*/) {
        model.addAttribute("users", service.getAll(new GenericCriteria()));
        return "auth/list";
    }

    @RequestMapping("detail/{id}/")
    public String detail(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("user", service.get(id));
        return "auth/detail";
    }
}
