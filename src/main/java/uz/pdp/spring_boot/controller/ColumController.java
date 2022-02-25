package uz.pdp.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.colim.CreateColumDto;
import uz.pdp.spring_boot.entity.project.Project;
import uz.pdp.spring_boot.reposiroty.PermissionRepository;
import uz.pdp.spring_boot.reposiroty.ProjectRepository;
import uz.pdp.spring_boot.services.colum.ColumService;
import uz.pdp.spring_boot.services.colum.ColumServiceImpl;
import uz.pdp.spring_boot.services.project.ProjectService;

@Controller
@RequestMapping("/colum/*")
public class ColumController extends AbstractController<ColumService> {
    ProjectRepository projectRepository;
    @Autowired
    public ColumController(ColumService service, ProjectRepository projectRepository) {
        super(service);
        this.projectRepository = projectRepository;
    }



    @RequestMapping(value = "create/{id}",method = RequestMethod.GET)
    public String create(@PathVariable Long id,Model model) {
        model.addAttribute("projectId",id);
        return "colum/create";
    }



   @ResponseBody
    @RequestMapping(value = "create",method = RequestMethod.POST)
    public String createPost( @ModelAttribute CreateColumDto dto) {
        service.create(dto);
        return "created";

    }

  @RequestMapping("list/{id}/")
    public String listColum(Model model, @PathVariable Long id){

        model.addAttribute("columns",service.getAllByProject(projectRepository.getById(id)));
        return "colum/list";
    }

}
