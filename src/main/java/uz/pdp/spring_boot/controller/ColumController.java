package uz.pdp.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "create",method = RequestMethod.GET)
    public String create() {
        return "colum/create";
    }
    @RequestMapping(value = "create",method = RequestMethod.POST)
    public String createPost( @ModelAttribute CreateColumDto dto) {
        service.create(dto);
        return "redirect:colum/list";

    }

  @RequestMapping("colum/list")
    public String listColum(Model model){
        model.addAttribute("columns",service.getAll(new GenericCriteria()));
        return "colum/list";
    }

}
