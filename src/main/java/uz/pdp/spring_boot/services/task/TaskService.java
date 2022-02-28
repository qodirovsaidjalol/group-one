package uz.pdp.spring_boot.services.task;

import org.springframework.beans.factory.annotation.Qualifier;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.auth.AuthUserCreateDto;
import uz.pdp.spring_boot.dto.auth.AuthUserDto;
import uz.pdp.spring_boot.dto.auth.AuthUserUpdateDto;
import uz.pdp.spring_boot.dto.task.TaskCreateDto;
import uz.pdp.spring_boot.dto.task.TaskDto;
import uz.pdp.spring_boot.dto.task.TaskUpdateDto;
import uz.pdp.spring_boot.entity.Auditable;
import uz.pdp.spring_boot.entity.task.Task;
import uz.pdp.spring_boot.entity.user.AuthUser;
import uz.pdp.spring_boot.services.GenericCrudService;

import java.util.List;

public interface TaskService extends GenericCrudService<
        Task,
        TaskDto,
        TaskCreateDto,
        TaskUpdateDto,
        GenericCriteria,
        Long> {

    List<TaskDto> getAllByColumn(Long id);

    Task getTask(Long id);
}
