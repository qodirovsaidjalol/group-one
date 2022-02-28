package uz.pdp.spring_boot.dto.task;

import lombok.*;
import uz.pdp.spring_boot.dto.GenericDto;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TaskUpdateDto extends GenericDto{
    private String name;
    private Long columnId;
    private String description;
    private Long level;
    private String deadline;

    @Builder(builderMethodName = "childBuilder")
    public TaskUpdateDto(Long id, String name, Long columId, String description,Long level,String deadline) {
        super(id);
        this.name = name;
        this.columnId = columId;
        this.description = description;
        this.level = level;
        this.deadline = deadline;
    }
}
