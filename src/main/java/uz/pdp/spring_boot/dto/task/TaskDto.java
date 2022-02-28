package uz.pdp.spring_boot.dto.task;

import lombok.*;
import uz.pdp.spring_boot.dto.GenericDto;
import uz.pdp.spring_boot.entity.task.Task;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TaskDto extends GenericDto {

    private String name;
    private String description;
    private String level;
    private Boolean completed;
    private String deadline;
    private boolean isBlocked;
    private String tz_path;

    @Builder(builderMethodName = "childBuilder")
    public TaskDto(Long id, String name, String description, String level, boolean completed,String deadline) {
        super(id);
        this.name = name;
        this.description =description;
        this.level = level;
        this.completed = completed;
        this.deadline= deadline;
    }

    public TaskDto(Task task) {
        super(task.getId());
        this.name=task.getName();
        this.description=task.getDescription();
        this.deadline=task.getDeadline();
    }
}
