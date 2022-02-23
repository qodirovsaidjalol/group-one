package uz.pdp.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.organization.OrganizationCreateDto;
import uz.pdp.spring_boot.services.organization.OrganizationService;

@Controller
@RequestMapping("/organization/*")
public class OrganizationController extends AbstractController<OrganizationService> {

    @Autowired
    public OrganizationController(OrganizationService service) {
        super(service);
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPage() {
        return "organization/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(Model model, @ModelAttribute OrganizationCreateDto dto) {
        Long id = service.create(dto);
        model.addAttribute("organization", service.get(id));
        return "auth/create_admin";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deletePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/delete";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/organization/list";
    }


    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updatePage(@PathVariable Long id) {
        return "organization/update";
    }

    @RequestMapping(value = "update/", method = RequestMethod.PATCH)
    public String update() {
        return "redirect:/";
    }

    @RequestMapping("detail/{id}")
    public String detail(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/detail";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("organizations", service.getAll(new GenericCriteria()));
        return "organization/list";
    }


    @RequestMapping(value = "block/{id}", method = RequestMethod.GET)
    public String blockPage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("user", service.get(id));
        return "auth/block";
    }

    @RequestMapping(value = "block/{id}", method = RequestMethod.POST)
    public String block(@PathVariable(name = "id") Long id) {
        service.block(id, false);
        return "redirect:/auth/list";
    }

    @RequestMapping(value = "unblock/{id}", method = RequestMethod.GET)
    public String unblockPage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("user", service.get(id));
        return "auth/unblock";
    }

    @RequestMapping(value = "unblock/{id}", method = RequestMethod.POST)
    public String unblock(@PathVariable(name = "id") Long id) {
        service.block(id, true);
        return "redirect:/auth/list";
    }
}
