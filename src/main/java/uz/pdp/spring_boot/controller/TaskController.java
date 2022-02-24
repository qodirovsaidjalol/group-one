package uz.pdp.spring_boot.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.auth.AuthUserCreateDto;
import uz.pdp.spring_boot.dto.task.TaskCreateDto;
import uz.pdp.spring_boot.dto.task.TaskUpdateDto;
import uz.pdp.spring_boot.services.organization.OrganizationService;
import uz.pdp.spring_boot.services.task.TaskService;
import uz.pdp.spring_boot.services.task.TaskServiceImpl;



@Controller
@RequestMapping("/task/*")
public class TaskController extends AbstractController<TaskService>{

    public TaskController(@Qualifier("taskServiceImpl") TaskServiceImpl service) {
        super(service);
    }

    @GetMapping("create")
    public String taskCreatePage(Model model) {
        model.addAttribute("dto", new TaskCreateDto());
        return "task/create";
    }

    @PostMapping("create")
    public String taskCreate(@ModelAttribute(name = "dto") TaskCreateDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/";
        }

        service.create(dto);
        return "redirect:/";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public ModelAndView updatePage(ModelAndView modelAndView, @PathVariable(name = "id") Long id) {
        modelAndView.setViewName("task/update");
        modelAndView.addObject("task", service.get(id));
        return modelAndView;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute TaskUpdateDto dto) {
        System.out.println("alik");
        System.out.println(dto);
        service.update(dto);
        return "redirect:/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public ModelAndView deletePage(ModelAndView modelAndView, @PathVariable(name = "id") Long id) {
        modelAndView.setViewName("task/delete");
        modelAndView.addObject("task", service.get(id));
        return modelAndView;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "list/{id}", method = RequestMethod.GET)
    public ModelAndView listPage(ModelAndView modelAndView,@PathVariable(name = "id") Long id) {
        modelAndView.setViewName("task/list");
        modelAndView.addObject("tasks",service.getAllByColumn(id));
        return modelAndView;
    }
}
