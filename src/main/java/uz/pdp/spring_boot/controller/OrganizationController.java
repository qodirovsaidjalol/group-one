package uz.pdp.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.organization.OrganizationUpdateDto;
import uz.pdp.spring_boot.dto.organization.OrganizationCreateDto;
import uz.pdp.spring_boot.services.auth.AuthUserService;
import uz.pdp.spring_boot.services.organization.OrganizationServiceImpl;

@Controller
@RequestMapping("/organization/*")
public class OrganizationController extends AbstractController<OrganizationServiceImpl> {

    private final AuthUserService authUserService;

    @Autowired
    public OrganizationController(OrganizationServiceImpl service, AuthUserService authUserService) {
        super(service);
        this.authUserService = authUserService;
    }

    @RequestMapping("create")
    public String createPage(Model model) {
        model.addAttribute("organization", new OrganizationCreateDto());
        return "organization/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute("dto") OrganizationCreateDto dto) {
        service.create(dto);
        return "redirect:/organization/list";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/edit";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable("id") Long id, RedirectAttributes redirectAttributes, @ModelAttribute OrganizationUpdateDto dto, Model model) {
        service.update(dto);
        return "redirect:/organization/list";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deletePage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/delete";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes, Model model) {
        service.delete(id);
        return "redirect:/organization/list";
    }

    @RequestMapping(value = "block/{id}", method = RequestMethod.GET)
    public String blockPage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/block";
    }

    @RequestMapping(value = "block/{id}", method = RequestMethod.POST)
    public String block(@PathVariable(name = "id") Long id) {
        service.block(id);
        return "redirect:/organization/list";
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    public String detail(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("organization", service.get(id));
        model.addAttribute("owner", authUserService.get(service.get(id).getOwner()));
        return "organization/detail";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("organizations", service.getAll(new GenericCriteria()));
        return "organization/list";
    }
}
