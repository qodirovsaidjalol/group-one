package uz.pdp.spring_boot.dto.task;

import lombok.*;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Component;
import uz.pdp.spring_boot.dto.Dto;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@Component
@NoArgsConstructor
public class TaskCreateDto implements Dto {

    private String name;
    private Long projectId;
    private Long columnId;
    private String description;
    private Long level;
    private String deadline;

}
