package uz.pdp.spring_boot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import uz.pdp.spring_boot.dto.task.TaskCreateDto;
import uz.pdp.spring_boot.dto.task.TaskDto;
import uz.pdp.spring_boot.dto.task.TaskUpdateDto;
import uz.pdp.spring_boot.entity.project.Project;
import uz.pdp.spring_boot.entity.task.Task;

import java.util.List;


@Component
@Mapper(componentModel = "spring")
public interface TaskMapper extends BaseMapper<
        Task,
        TaskDto,
        TaskCreateDto,
        TaskUpdateDto> {
    @Override
    @Mapping(target = "tz_path", ignore = true)
    List<TaskDto> toDto(List<Task> e);

    @Override
    TaskDto toDto(Task task);

    @Override
    List<Task> fromDto(List<TaskDto> e);

    @Override
    @Mapping(target = "tz_path", ignore = true)
    Task fromCreateDto(TaskCreateDto taskCreateDto);

    @Override
    Task fromUpdateDto(TaskUpdateDto taskUpdateDto);
}
