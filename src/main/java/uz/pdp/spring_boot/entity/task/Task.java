package uz.pdp.spring_boot.entity.task;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import uz.pdp.spring_boot.entity.Auditable;
import uz.pdp.spring_boot.entity.BaseEntity;
import uz.pdp.spring_boot.entity.column.Colum;
import uz.pdp.spring_boot.entity.column.Colum;
import uz.pdp.spring_boot.entity.project.Project;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@ToString
public class Task extends Auditable implements BaseEntity {

    @ManyToOne
    private Project project;

    @ManyToOne
    private Colum column;

    private String name;

    private String description;

    private Long level;

    private boolean completed;

    private String deadline;

    private String tz_path;

    private Long isBlocked;
}