package uz.pdp.spring_boot.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.spring_boot.dto.GenericDto;
import uz.pdp.spring_boot.entity.task.Task;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class TaskDto extends GenericDto {

    private String name;
    private Long projectId;
    private Long columnId;
    private String description;
    private String level;
    private Boolean completed;
    private String deadline;

    @Builder(builderMethodName = "childBuilder")
    public TaskDto(Long id, String name, String description, String level, boolean completed,String deadline,Long projectId,Long columnId) {
        super(id);
        this.name = name;
        this.description =description;
        this.level = level;
        this.completed = completed;
        this.deadline= deadline;
        this.projectId = projectId;
        this.columnId = columnId;
    }

    public TaskDto(Task task) {
        super(task.getId());
        this.name=task.getName();
        this.description=task.getDescription();
        this.deadline=task.getDeadline();
        this.columnId=task.getColumn().getId();
    }
}
