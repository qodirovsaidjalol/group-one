package uz.pdp.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.colim.CreateColumDto;
import uz.pdp.spring_boot.services.colum.ColumService;
import uz.pdp.spring_boot.services.colum.ColumServiceImpl;

@Controller
@RequestMapping("/colum/*")
public class ColumController extends AbstractController<ColumService> {

    public ColumController(ColumService service) {
        super(service);
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

  @RequestMapping("colum/list")
    public String listColum(Model model){
        model.addAttribute("columns",service.getAll(new GenericCriteria()));
        return "colum/list";
    }

}
