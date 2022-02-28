package uz.pdp.spring_boot.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.spring_boot.dto.task.TaskCreateDto;
import uz.pdp.spring_boot.dto.task.TaskUpdateDto;
import uz.pdp.spring_boot.entity.column.Colum;
import uz.pdp.spring_boot.entity.task.Task;
import uz.pdp.spring_boot.services.colum.ColumService;
import uz.pdp.spring_boot.services.project.ProjectService;
import uz.pdp.spring_boot.services.task.TaskService;
import uz.pdp.spring_boot.services.task.TaskServiceImpl;

import java.util.List;


@Controller
@RequestMapping("/task/*")
public class TaskController extends AbstractController<TaskService> {

    private final ColumService columService;
    private final ProjectService projectService;

    public TaskController(@Qualifier("taskServiceImpl") TaskServiceImpl service, ColumService columService, ProjectService projectService) {
        super(service);
        this.columService = columService;
        this.projectService = projectService;
    }

    @GetMapping("create/{id}")
    public String taskCreatePage(Model model, @PathVariable(name = "id") Long columnId) {
        model.addAttribute("dto", new TaskCreateDto());
        model.addAttribute("columnId", columnId);
        return "task/create";
    }

    @PostMapping("create/{id}/")
    public String taskCreate(@ModelAttribute(name = "dto") TaskCreateDto dto, @PathVariable Long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/";
        }
        Colum colum = columService.getColum(id);
        dto.setColumnId(id);
        dto.setProjectId(colum.getProject().getId());
        service.create(dto);
        return "redirect:/task/list/"+id+"/";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public ModelAndView updatePage(ModelAndView modelAndView, @PathVariable(name = "id") Long id) {
        modelAndView.setViewName("task/update");
        modelAndView.addObject("task", service.getTask(id));
        return modelAndView;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute TaskUpdateDto dto) {
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

    @RequestMapping(value = "list/{id}/", method = RequestMethod.GET)
    public ModelAndView listPage(ModelAndView modelAndView, @PathVariable(name = "id") Long id) {
        modelAndView.setViewName("task/list");
        modelAndView.addObject("columnId", id);
        modelAndView.addObject("tasks", service.getAllByColumn(id));
        return modelAndView;
    }


    @RequestMapping(value = "addmember/{id}/", method = RequestMethod.GET)
    public String addMemberPage(Model model, @PathVariable(name = "id") Long id) {
        Task task = service.getTask(id);
        System.out.println(task.getProject().getId());
        model.addAttribute("users", projectService.getMembers(task.getProject().getId()));
        return "task/addmember";
    }

    @RequestMapping(value = "addmember/{id}/", method = RequestMethod.POST)
    public String addMember(@PathVariable Long id, @ModelAttribute(name = "users") List<Long> idList) {
        Task task = service.getTask(id);
        for (Long aLong : idList) {
            System.out.println(aLong);
        }
//        projectMemberService.addUser(id,idList);
        return "redirect:/";
    }
}