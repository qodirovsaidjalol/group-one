//package uz.pdp.spring_boot.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import uz.pdp.spring_boot.config.SecurityConfigurations;
//import uz.pdp.spring_boot.config.UserDetails;
//import uz.pdp.spring_boot.criteria.GenericCriteria;
//import uz.pdp.spring_boot.dto.proect.ProjectCreateDto;
//import uz.pdp.spring_boot.entity.column.Colum;
//import uz.pdp.spring_boot.services.project.ProjectService;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/project/*")
//public class ProjectController extends AbstractController<ProjectService> {
//
//    @Autowired
//    public ProjectController(ProjectService service) {
//        super(service);
//    }
//
//    @RequestMapping(value = "create", method = RequestMethod.GET)
//    public String create() {
//        return "project/create";
//    }
//
//    @RequestMapping(value = "create", method = RequestMethod.POST)
//    public String create(@ModelAttribute ProjectCreateDto dto, Long id) {
//        dto.setOrganization(service.getOrg(1L));
//        service.create(dto);
//        return "redirect:/project/list/";
//    }
//
//    @RequestMapping("delete/{id}")
//    public String delete(@PathVariable Long id) {
//        service.delete(id);
//        return "redirect:/project/list/";
//    }
//
//    @RequestMapping("list")
//    public String list(Model model) {
//        model.addAttribute("projects", service.getAllByOrg(2L));
//        return "project/list";
//    }
//
//    @RequestMapping("/detail/{id}/")
//    public String addMembers(Model model, @PathVariable Long id) {
//
//        model.addAttribute("columns", service.getColum(id));
//        model.addAttribute("projectId", id);
//        return "project/details";
//    }
//}
